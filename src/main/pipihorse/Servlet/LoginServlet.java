package pipihorse.Servlet;

import pipihorse.Pojo.User;
import pipihorse.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @Author 皮皮马
 * @create 2020-12-14 16:17
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=service.findUser(username,password);
        PrintWriter out =resp.getWriter();
        if (user.getUsername()!=null){
            req.getSession().setAttribute("user",user);
            out.print("true");
        }else{
            out.print("false");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
