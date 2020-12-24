package pipihorse.Dao;

import pipihorse.Pojo.Zc;
import pipihorse.util.Connutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author 皮皮马
 * @create 2020-12-20 23:00
 */
public class ZcDao {
    private Connection conn= Connutil.getConnection();
    public Boolean zanCai(Zc zc){
        System.out.println("zcdao:"+zc);
        String sql="insert into zc(post_id,user_id,praise_tread) values(?,?,?)";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,zc.getPostId());
            pre.setInt(2,zc.getUserId());
            pre.setInt(3,zc.getPraiseTread());
            int i = pre.executeUpdate();
            if (i==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //判断是否已经点赞点踩
    public int praiseTread(int userId,int postId){
        String sql="select praise_tread from zc where user_id=? and post_id=?";
        int k=0;
        try {
            PreparedStatement pre= conn.prepareStatement(sql);
            pre.setInt(1,userId);
            pre.setInt(2,postId);
            ResultSet set = pre.executeQuery();
            while (set.next()){
            k=set.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("K:"+k);
        return k;
    }

    //统计点赞点踩人数
    public int count(int pt){
        String sql="select count(1) from zc where  praise_tread=?";
        int count=0;
        try {
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setInt(1,pt);
            ResultSet set = pre.executeQuery();
            while (set.next()){
                count=set.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
