package pipihorse.Dao;

import pipihorse.Pojo.Post;
import pipihorse.util.Connutil;
import pipihorse.util.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-17 15:09
 */
public class PostDao {
    private Connection conn = Connutil.getConnection();

    //新增帖子
    public Boolean insert(Post post) {
        if (post.getImage() == null) {
            String sql = "insert into post(forum,user_id,title,card_content,send_date) values(?,?,?,?,?)";
            try {
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, post.getForum());
                pre.setInt(2, post.getUserId());
                pre.setString(3, post.getTitle());
                pre.setString(4, post.getContent());
                pre.setString(5, post.getSendDate());
                int i = pre.executeUpdate();
                if (i == 1) {
                    return true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "insert into post(forum,user_id,title,card_content,image,send_date) values(?,?,?,?,?,?)";
            try {
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, post.getForum());
                pre.setInt(2, post.getUserId());
                pre.setString(3, post.getTitle());
                pre.setString(4, post.getContent());
                pre.setString(5, post.getImage());
                pre.setString(6, post.getSendDate());
                int i = pre.executeUpdate();
                if (i == 1) {
                    return true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //查询帖子
    public List<Post> findAll(Page page) {
        List<Post> list = new ArrayList<>();
        String sql = "select id,forum,user_id,title,card_content,image,send_date,post_type,reply_num,view_num from post limit ?,? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, page.getPageSize() * (page.getCurrentPage() - 1));
            pre.setInt(2, page.getPageSize());
            ResultSet set = pre.executeQuery();
            while (set.next()) {
                {
                    Post post = new Post();
                    post.setId(set.getInt("id"));
                    post.setForum(set.getInt("forum"));
                    post.setUserId(set.getInt("user_id"));
                    post.setTitle(set.getString("title"));
                    post.setContent(set.getString("card_content"));
                    post.setImage(set.getString("image"));
                    post.setSendDate(set.getString("send_date"));
                    post.setPostType(set.getInt("post_type"));
                    post.setReplyNum(set.getInt("reply_num"));
                    post.setViewNum(set.getInt("view_num"));
                    list.add(post);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //查询新帖子
    public List<Post> findNew(Page page){
        List<Post> list = new ArrayList<>();
        String sql = "select id,forum,user_id,title,card_content,image,send_date,post_type,reply_num,view_num from post order by STR_TO_DATE(send_date,'%Y-%m-%d %T') desc limit ?,? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, page.getPageSize() * (page.getCurrentPage() - 1));
            pre.setInt(2, page.getPageSize());
            ResultSet set = pre.executeQuery();
            while (set.next()) {
                {
                    Post post = new Post();
                    post.setId(set.getInt("id"));
                    post.setForum(set.getInt("forum"));
                    post.setUserId(set.getInt("user_id"));
                    post.setTitle(set.getString("title"));
                    post.setContent(set.getString("card_content"));
                    post.setImage(set.getString("image"));
                    post.setSendDate(set.getString("send_date"));
                    post.setPostType(set.getInt("post_type"));
                    post.setReplyNum(set.getInt("reply_num"));
                    post.setViewNum(set.getInt("view_num"));
                    list.add(post);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //查询总记录数
    public int findAllNum() {
        String sql = "select count(1) from post";
        int num = 0;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet set = pre.executeQuery();
            while (set.next()) {
                num = set.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public List<Post> findHot(Page page){
        List<Post> list = new ArrayList<>();
        String sql = "select id,forum,user_id,title,card_content,image,send_date,post_type,reply_num,view_num from post order by (reply_num) desc,id limit ?,? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, page.getPageSize() * (page.getCurrentPage() - 1));
            pre.setInt(2, page.getPageSize());
            ResultSet set = pre.executeQuery();
            while (set.next()) {
                {
                    Post post = new Post();
                    post.setId(set.getInt("id"));
                    post.setForum(set.getInt("forum"));
                    post.setUserId(set.getInt("user_id"));
                    post.setTitle(set.getString("title"));
                    post.setContent(set.getString("card_content"));
                    post.setImage(set.getString("image"));
                    post.setSendDate(set.getString("send_date"));
                    post.setPostType(set.getInt("post_type"));
                    post.setReplyNum(set.getInt("reply_num"));
                    post.setViewNum(set.getInt("view_num"));
                    list.add(post);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int findByIdNum(int id){
        String sql = "select count(1) from post where id=?";
        int num = 0;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,id);
            ResultSet set = pre.executeQuery();
            while (set.next()) {
                num = set.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    //根据id查帖子
    public Post findById(int id) {
        Post post = new Post();
        String sql = "select id,forum,user_id,title,card_content,image,send_date,post_type,view_num,praise,tread from post where id=? ";
        int replyNum=new ReplyDao().findByIdNum(id);
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,id);
            ResultSet set = pre.executeQuery();
            while (set.next()) {
                {
                    post.setId(set.getInt("id"));
                    post.setForum(set.getInt("forum"));
                    post.setUserId(set.getInt("user_id"));
                    post.setTitle(set.getString("title"));
                    post.setContent(set.getString("card_content"));
                    post.setImage(set.getString("image"));
                    post.setSendDate(set.getString("send_date"));
                    post.setPostType(set.getInt("post_type"));
                    post.setReplyNum(replyNum);
                    post.setViewNum(set.getInt("view_num"));
                    post.setPraise(set.getInt("praise"));
                    post.setTread(set.getInt("tread"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    //板块分类
    public List<Post> findAll(Page page,int forum){
        List<Post> list = new ArrayList<>();
        String sql = "select id,forum,user_id,title,card_content,image,send_date,post_type,reply_num,view_num from post where forum=? limit ?,? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,forum);
            pre.setInt(2, page.getPageSize() * (page.getCurrentPage() - 1));
            pre.setInt(3, page.getPageSize());
            ResultSet set = pre.executeQuery();
            while (set.next()) {
                {
                    Post post = new Post();
                    post.setId(set.getInt("id"));
                    post.setForum(set.getInt("forum"));
                    post.setUserId(set.getInt("user_id"));
                    post.setTitle(set.getString("title"));
                    post.setContent(set.getString("card_content"));
                    post.setImage(set.getString("image"));
                    post.setSendDate(set.getString("send_date"));
                    post.setPostType(set.getInt("post_type"));
                    post.setReplyNum(set.getInt("reply_num"));
                    post.setViewNum(set.getInt("view_num"));
                    list.add(post);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //更新点赞人数
    public Boolean zan(int post_id){
        String sql="update post set praise=(select count(1) from zc where post_id=? and praise_tread=1) where id=?";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,post_id);
            pre.setInt(2,post_id);
            int i = pre.executeUpdate();
            if (i==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //更新点踩人数
    public Boolean cai(int post_id){
        String sql="update post set tread=(select count(1) from zc where post_id=? and praise_tread=2) where id=?";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,post_id);
            pre.setInt(2,post_id);
            int i = pre.executeUpdate();
            if (i==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //更新评论人数
    public Boolean comment(int post_id){
        String sql="update post set reply_num=(select count(1) from reply where send_id=?) where id=?";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,post_id);
            pre.setInt(2,post_id);
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
