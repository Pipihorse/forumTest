package pipihorse.util;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 皮皮马
 * @create 2020-12-14 16:19
 */
public class Connutil {
    public static Connection getConnection(){
        final String url="jdbc:mysql://localhost:3306/forum?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        final String root="root";
        final String password="123456";
        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,root,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  conn;
    }
}
