package pipihorse.Service;

import pipihorse.Dao.UserDao;
import pipihorse.Pojo.User;

/**
 * @Author 皮皮马
 * @create 2020-12-14 16:17
 */
public class UserService {
    UserDao dao=new UserDao();
    public User findUser(String username,String password){
       return dao.findUser(username,password);
    }
    public Boolean insert(User user){
        return dao.insert(user);
    }
    public User findByName(String username){
        return  dao.findByName(username);
    }
    public User update(User user){
        return dao.update(user);
    }
    public User findById(int id){
        return dao.findById(id);
    }


}
