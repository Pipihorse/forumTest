package pipihorse.Service;

import pipihorse.Dao.ZcDao;
import pipihorse.Pojo.Zc;

/**
 * @Author 皮皮马
 * @create 2020-12-20 23:31
 */
public class ZcService {
    private ZcDao dao=new ZcDao();
    public Boolean zanCai(Zc zc){
        return dao.zanCai(zc);
    }
    public int praiseTread(int userId,int postId){
        return dao.praiseTread(userId,postId);
    }
}
