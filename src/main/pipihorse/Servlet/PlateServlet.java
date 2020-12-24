package pipihorse.Servlet;

import net.sf.json.JSONArray;
import pipihorse.Pojo.Plate;
import pipihorse.Service.PlateService;

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
 * @create 2020-12-17 10:19
 */
@WebServlet("/plate")
public class PlateServlet extends HttpServlet {
    private PlateService service=new PlateService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Plate:doget");
        List<Plate> list=service.findAll();
        JSONArray jsonArray=JSONArray.fromObject(list);
        PrintWriter out =resp.getWriter();
        out.print(jsonArray);
    }
}
