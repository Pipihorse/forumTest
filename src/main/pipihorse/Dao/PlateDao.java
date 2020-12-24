package pipihorse.Dao;

import pipihorse.Pojo.Plate;
import pipihorse.util.Connutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-17 10:13
 */
public class PlateDao {
    private Connection conn= Connutil.getConnection();
    public List<Plate> findAll(){
        String sql="select id,title,info from plate";
        List<Plate> list=new ArrayList<>();
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            while (res.next()){
                Plate plate=new Plate();
                plate.setId(res.getInt("id"));
                plate.setTitle(res.getString("title"));
                plate.setInfo(res.getString("info"));
                list.add(plate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
