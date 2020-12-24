package pipihorse.Dao;

import pipihorse.Pojo.Reply;
import pipihorse.util.Connutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-18 14:09
 */
public class ReplyDao {
    private Connection conn= Connutil.getConnection();
    //根据帖子id查询评论
    public List<Reply> find(int sendId){
        List<Reply> list=new ArrayList<Reply>();
        String sql="select id,send_id,user_id,reply_content,reply_date,praise_tread from reply where send_id=?";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,sendId);
            ResultSet set = pre.executeQuery();
            while(set.next()){
                Reply reply=new Reply();
                reply.setId(set.getInt("id"));
                reply.setSendId(set.getInt("send_id"));
                reply.setUserId(set.getInt("user_id"));
                reply.setReplyContent(set.getString("reply_content"));
                reply.setReplyDate(set.getString("reply_date"));
                reply.setPraiseTread(set.getInt("praise_tread"));
                list.add(reply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //插入评论
    public Boolean insert(Reply reply){
        String sql="insert into reply(send_id,user_id,reply_content,reply_date) values(?,?,?,?)";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,reply.getSendId());
            pre.setInt(2,reply.getUserId());
            pre.setString(3,reply.getReplyContent());
            pre.setString(4,reply.getReplyDate());
            int i = pre.executeUpdate();
            if (i==1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //根据帖子id查询总评论数
    public int findByIdNum(int id){
        String sql="select count(1) from reply where send_id=?";
        int replyNum=0;
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,id);
            ResultSet res = pre.executeQuery();
            while (res.next()){
                replyNum=res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replyNum;
    }
}
