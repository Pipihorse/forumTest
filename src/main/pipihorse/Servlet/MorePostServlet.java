package pipihorse.Servlet;

import net.sf.json.JSONArray;
import pipihorse.Pojo.Post;
import pipihorse.Pojo.Reply;
import pipihorse.Service.PostService;
import pipihorse.util.Page;

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
 * @create 2020-12-19 10:43
 */
@WebServlet("/more")
public class MorePostServlet extends HttpServlet {
    private PostService service=new PostService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type1="1";
        int currentPage= Integer.valueOf(req.getParameter("currentPage")); //当前页
        if (req.getParameter("type")!=null){
            type1=req.getParameter("type");
        }

        int type=Integer.parseInt(type1);
        int recordCount=service.findAllNum(); //总记录数
        int pageSize=5;   //每页记录数
        Page page=new Page(currentPage,pageSize,recordCount);
        if (type==1){
            List<Post> list=service.findNew(page);
            page.setPostList(list);
        }else if (type==2){
            List<Post> list=service.findHot(page);
            page.setPostList(list);
        }
        req.setAttribute("type",type);
        System.out.println(page);
        req.setAttribute("pages",page);
        req.getRequestDispatcher("/pages/more.jsp").forward(req, resp);

    }
}
