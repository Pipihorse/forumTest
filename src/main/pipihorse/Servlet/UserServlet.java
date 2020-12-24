package pipihorse.Servlet;

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
 * @create 2020-12-14 19:58
 */
@WebServlet("/username")
public class UserServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = service.findByName(req.getParameter("username"));
        PrintWriter out=resp.getWriter();
        if (user.getUsername()!=null){
            out.print("false");
        }else {
            out.print("true");
        }
    }
}
