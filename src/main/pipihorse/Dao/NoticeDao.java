package pipihorse.Dao;

import pipihorse.Pojo.Notice;
import pipihorse.util.Connutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author 皮皮马
 * @create 2020-12-21 19:56
 */
public class NoticeDao {
    private Connection conn= Connutil.getConnection();
    public Boolean insert(Notice notice){
        String sql="insert into notice(title,content,user_id,notice_date) values(?,?,?,?)";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1,notice.getTitle());
            pre.setString(2,notice.getContent());
            pre.setInt(3,notice.getUserId());
            pre.setString(4,notice.getNoticeDate());
            int i = pre.executeUpdate();
            if (i==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
