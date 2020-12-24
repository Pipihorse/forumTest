package pipihorse.Servlet;

import pipihorse.Pojo.Zc;
import pipihorse.Service.PostService;
import pipihorse.Service.ZcService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author 皮皮马
 * @create 2020-12-20 23:18
 */
@WebServlet("/zc")
public class ZcServlet extends HttpServlet {
    private ZcService service=new ZcService();
    private PostService postService=new PostService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("zcget");
        int userId=Integer.parseInt(req.getParameter("userId"));
        int num=Integer.parseInt(req.getParameter("num"));
        int postId=Integer.parseInt(req.getParameter("postId"));
        PrintWriter out=resp.getWriter();
        System.out.println("zcServletUserId:"+userId);
        if (service.praiseTread(userId,postId)==0){
            System.out.println("zcServlet:"+userId);
            Zc zc=new Zc();
            zc.setUserId(userId);
            zc.setPostId(postId);
            zc.setPraiseTread(num);
            Boolean b=service.zanCai(zc);
            postService.cai(postId);
            postService.zan(postId);
            out.print(b);
        }else {
          out.print("false");
        }

    }
}
