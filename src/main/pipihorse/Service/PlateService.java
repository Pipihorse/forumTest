package pipihorse.Service;

import pipihorse.Dao.PlateDao;
import pipihorse.Pojo.Plate;
import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-17 10:18
 */
public class PlateService {
    private PlateDao dao=new PlateDao();
    public List<Plate> findAll(){
        return dao.findAll();
    }
}
