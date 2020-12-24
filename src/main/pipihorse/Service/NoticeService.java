package pipihorse.Service;

import pipihorse.Dao.NoticeDao;
import pipihorse.Pojo.Notice;

/**
 * @Author 皮皮马
 * @create 2020-12-21 19:59
 */
public class NoticeService {
    private NoticeDao dao=new NoticeDao();
    public Boolean insert(Notice notice){
        return dao.insert(notice);
    }
}
