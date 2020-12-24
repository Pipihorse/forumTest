package pipihorse.Servlet;

import net.sf.json.JSONArray;
import pipihorse.Pojo.User;
import pipihorse.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author 皮皮马
 * @create 2020-12-18 14:39
 */
@WebServlet("/userById")
public class userByIdServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId=Integer.parseInt(req.getParameter("userId"));
        User user=service.findById(userId);
        System.out.println("userById:"+user);
        JSONArray jsonArray=JSONArray.fromObject(user);
        PrintWriter out = resp.getWriter();
        out.print(jsonArray);
    }
}
