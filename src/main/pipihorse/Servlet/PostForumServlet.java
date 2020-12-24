package pipihorse.Servlet;

import pipihorse.Pojo.Post;
import pipihorse.Pojo.User;
import pipihorse.Service.PostService;
import pipihorse.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-21 1:56
 */
@WebServlet("/forum")
public class PostForumServlet extends HttpServlet {
    private PostService service=new PostService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int forum=Integer.parseInt(req.getParameter("forum"));
        int currentPage= Integer.valueOf(req.getParameter("currentPage")); //当前页
        int recordCount=service.findByIdNum(forum); //总记录数
        int pageSize=5;   //每页记录数
        Page page=new Page(currentPage,pageSize,recordCount);
        List<Post> list=service.findAll(page,forum);
        page.setPostList(list);
        System.out.println(page);
        req.setAttribute("pages",page);
        req.getRequestDispatcher("/pages/more.jsp").forward(req, resp);
    }
}
