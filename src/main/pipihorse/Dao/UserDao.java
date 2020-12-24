package pipihorse.Dao;

import pipihorse.Pojo.User;
import pipihorse.util.Connutil;

import java.sql.*;

/**
 * @Author 皮皮马
 * @create 2020-12-14 16:17
 */
public class UserDao {
    private Connection conn=Connutil.getConnection();
    //查询用户
    public User findUser(String username,String password){
        User user=new User();
        if (username==null||password==null){
            return user;
        }
        String sql="select id,username,password,sex,image,Email,hasActive,register_date from user where username=? and password=?";
        try {
            PreparedStatement pare=conn.prepareStatement(sql);
            pare.setString(1,username);
            pare.setString(2,password);
            ResultSet res = pare.executeQuery();
            while (res.next()){
                user.setId(res.getInt(1));
                user.setUsername(res.getString(2));
                user.setPassword(res.getString(3));
                user.setSex(res.getString("sex"));
                user.setImage(res.getString("image"));
                user.setEmail(res.getString("Email"));
                user.setHasActive(res.getInt("hasActive"));
                user.setRegisterDate(res.getString("register_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }
    //根据用户名查询用户
    public User findByName(String username){
        String sql="select id,username,password,sex,image,Email,register_date from user where username=?";
        User user=new User();
        try {
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setString(1,username);
            ResultSet res = pre.executeQuery();
            while(res.next()){
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
                user.setSex(res.getString("sex"));
                user.setImage(res.getString("image"));
                user.setEmail(res.getString("Email"));
                user.setRegisterDate(res.getString("register_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //添加用户
    public Boolean insert(User user){
        String sql="insert into user(username,password,sex,Email,register_date) values(?,?,?,?,?)";
        int i=0;
        System.out.println("insert:"+user);
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,user.getUsername());
            pre.setString(2,user.getPassword());
            pre.setString(3,user.getSex());
            pre.setString(4,user.getEmail());
            pre.setString(5, user.getRegisterDate());
             i = pre.executeUpdate();
            System.out.println(i);
             if (i==1){
                 return true;
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //修改用户信息
    public User update(User user){
        if (user.getImage()==null){
            String sql="update user set username=?,password=?,sex=?,Email=?  where id=?";
            try {
                PreparedStatement pre=conn.prepareStatement(sql);
                pre.setString(1,user.getUsername());
                pre.setString(2,user.getPassword());
                pre.setString(3,user.getSex());
                pre.setString(4,user.getEmail());
                pre.setInt(5,user.getId());
                int i = pre.executeUpdate();
                if (i==1){
                    return findByName(user.getUsername());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            String sql = "update user set username=?,password=?,sex=?,Email=?,image=?  where id=?";
            try {
                PreparedStatement pre=conn.prepareStatement(sql);
                pre.setString(1,user.getUsername());
                pre.setString(2,user.getPassword());
                pre.setString(3,user.getSex());
                pre.setString(4,user.getEmail());
                pre.setString(5,user.getImage());
                pre.setInt(6,user.getId());
                int i = pre.executeUpdate();
                if (i==1){
                    return findByName(user.getUsername());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    //根据用户ID查用户
    public User findById(int id){
        User user=new User();
        String sql="select id,username,password,sex,image,Email,hasActive,register_date from user where id=?";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1,id);
            ResultSet res = pre.executeQuery();
            while(res.next()){
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
                user.setSex(res.getString("sex"));
                user.setImage(res.getString("image"));
                user.setEmail(res.getString("Email"));
                user.setHasActive(res.getInt("hasActive"));
                user.setRegisterDate(res.getString("register_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
