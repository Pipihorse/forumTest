package pipihorse.Service;
import pipihorse.Dao.ReplyDao;
import pipihorse.Pojo.Reply;
import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-18 14:16
 */

public class ReplyService {
    ReplyDao dao=new ReplyDao();
    public List<Reply> find(int userId){
        return dao.find(userId);
    }
    public Boolean insert(Reply reply){
        return dao.insert(reply);
    }

}
