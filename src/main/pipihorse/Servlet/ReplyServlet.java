package pipihorse.Servlet;

import net.sf.json.JSONArray;
import pipihorse.Pojo.Reply;
import pipihorse.Service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-18 14:17
 */
@WebServlet("/reply")
public class ReplyServlet extends HttpServlet {
    private ReplyService service=new ReplyService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sendId=Integer.parseInt(req.getParameter("sendId"));
        List<Reply> list = service.find(sendId);
        System.out.println(list);
        JSONArray jsonArray=JSONArray.fromObject(list);
        PrintWriter out =resp.getWriter();
        out.print(jsonArray);
    }
}
