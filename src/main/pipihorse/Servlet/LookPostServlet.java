package pipihorse.Servlet;

import pipihorse.Pojo.Post;
import pipihorse.Pojo.User;
import pipihorse.Service.PostService;
import pipihorse.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 皮皮马
 * @create 2020-12-18 10:36
 */
@WebServlet("/lookpost")
public class LookPostServlet extends HttpServlet {
    private PostService postService=new PostService();
    private UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        Post post=postService.findById(id);
        User user=userService.findById(post.getUserId());
        req.setAttribute("post",post);
        req.setAttribute("user1",user);
        req.getRequestDispatcher("/pages/post.jsp").forward(req, resp);
    }
}
