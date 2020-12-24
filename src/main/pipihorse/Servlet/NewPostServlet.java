package pipihorse.Servlet;

import net.sf.json.JSONArray;
import pipihorse.Service.PostService;
import pipihorse.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-18 9:22
 */
@WebServlet("/newPost")
public class NewPostServlet extends HttpServlet {
    PostService service=new PostService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage=Integer.valueOf(req.getParameter("currentPage")); //当前页
        int recordCount=service.findAllNum(); //总记录数
        int pageSize=5;   //每页记录数
        Page page=new Page(currentPage,pageSize,recordCount);
        List list=service.findNew(page);
        JSONArray jsonArray=JSONArray.fromObject(list);
        PrintWriter out=resp.getWriter();
        out.print(jsonArray);
    }
}
