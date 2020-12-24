package pipihorse.Servlet;

import pipihorse.Pojo.Notice;
import pipihorse.Service.NoticeService;

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
 * @create 2020-12-21 19:50
 */
@WebServlet("/addNotice")
public class addNoticeServlet extends HttpServlet {
    private NoticeService service=new NoticeService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Notice notice=new Notice();
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        String noticeDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        int userId=Integer.parseInt(req.getParameter("userId"));
        notice.setTitle(title);
        notice.setContent(content);
        notice.setNoticeDate(noticeDate);
        notice.setUserId(userId);
        System.out.println(notice);
        Boolean insert = service.insert(notice);
        PrintWriter out = resp.getWriter();
        out.print(out);
    }
}
