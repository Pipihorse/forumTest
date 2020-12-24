package pipihorse.Servlet;

import pipihorse.Pojo.Reply;
import pipihorse.Service.PostService;
import pipihorse.Service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 皮皮马
 * @create 2020-12-18 18:47
 */
@WebServlet("/replyInfo")
public class ReplyInfoServlet extends HttpServlet {
    private ReplyService service=new ReplyService();
    private PostService postService=new PostService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Reply reply=new Reply();
        int userId=Integer.parseInt(req.getParameter("userId"));
        String content=req.getParameter("content");
        int postId=Integer.parseInt(req.getParameter("postId"));
        reply.setSendId(postId);
        reply.setUserId(userId);
        reply.setReplyContent(content);
        reply.setReplyDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //打印Reply对象
        System.out.println(reply);
        Boolean insert = service.insert(reply);
        Boolean comment = postService.comment(postId);
        System.out.println("comment:"+comment);
        PrintWriter out = resp.getWriter();
        out.print(insert);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int praiseTread=Integer.parseInt(req.getParameter("num"));
        int userId=Integer.parseInt(req.getParameter("userId"));
        System.out.println("userId:"+userId);
        System.out.println("praiseTread:"+praiseTread);
        PrintWriter out = resp.getWriter();

    }
}
