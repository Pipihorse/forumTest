package pipihorse.Servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pipihorse.Pojo.Post;
import pipihorse.Service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-17 16:21
 */
@WebServlet("/post")
public class PostServlet extends HttpServlet {
    private PostService service=new PostService();
    private Post post=new Post();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //		- 创建磁盘工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
//		- 创建处理工具
        ServletFileUpload upload = new ServletFileUpload(factory);
//		- 设置上传文件的大小
        upload.setFileSizeMax(1024 * 1024 * 5);//最大可上传5M内容
        try {
//		- 接收表单提交的全部内容
            List<FileItem> fileItems = upload.parseRequest(req);
            Iterator<FileItem> iterator = fileItems.iterator();
//			- 循环接收内容，如果是文件，则保存，不是文件，则表示是表单提交的其他的参数
            System.out.println(iterator.hasNext());
            while (iterator.hasNext()) {
                FileItem fileItem = iterator.next();
                if (fileItem.isFormField()) {//普通的表单控件
                    String value = fileItem.getString();
                    value = new String(value.getBytes("ISO8859-1"), "UTF-8");
                    System.out.println(fileItem.getFieldName() + ":" + value); //打印普通的表单控件的名称和值
                    if (fileItem.getFieldName().equals("title")){
                        post.setTitle(value);
                    }
                    if (fileItem.getFieldName().equals("content")){
                        post.setContent(value);
                    }
                    if (fileItem.getFieldName().equals("mainForum")){
                        post.setForum(Integer.valueOf(value));
                    }
                    if (fileItem.getFieldName().equals("userId")){
                        post.setUserId(Integer.valueOf(value));
                    }


                } else {//是文件
                    //考虑保存文件
                    int fileSize = (int) fileItem.getSize();//取得文件字节长度
                    if (fileSize != 0) {
                        //获得文件字节输入流
                        InputStream in = fileItem.getInputStream();
                        byte b[] = new byte[fileSize];
                        in.read(b);//将文件内容读取到字节数组中
                        String fileName = fileItem.getName();//获得文件名称
                        File file = new File("F:\\imgTest\\" + System.currentTimeMillis() + (int) Math.random() * 10 + ".jpg");
                        //将字节数组写入到文件中
                        post.setImage(file.getName());
                        OutputStream out = new FileOutputStream(file);
                        out.write(b);//将字节数组写入到新的文件中
                        in.close();
                        out.close();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        post.setSendDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Boolean insert = service.insert(post);
        PrintWriter out = resp.getWriter();
        if (insert){
            out.print("true");
        }else
            out.print("false");
    }
}
