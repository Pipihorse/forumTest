package pipihorse.Service;

import pipihorse.Dao.PostDao;
import pipihorse.Pojo.Post;
import pipihorse.util.Page;

import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-17 15:09
 */
public class PostService {
    private PostDao dao=new PostDao();
    public Boolean insert(Post post){
        return dao.insert(post);
    }
    public List<Post> findAll(Page page){
        return dao.findAll(page);
    }
    public List<Post> findNew(Page page){
        return dao.findNew(page);
    }
    public List<Post> findHot(Page page){
        return dao.findHot(page);
    }
    public int findAllNum(){
        return dao.findAllNum();
    }
    public int findByIdNum(int id){
        return dao.findByIdNum(id);
    }
    public Post findById(int id){
        return dao.findById(id);
    }
    public List<Post> findAll(Page page,int forum){
        return dao.findAll(page,forum);
    }
    public Boolean comment(int post_id){
        return dao.comment(post_id);
    }

    public Boolean zan(int post_id){
        return dao.zan(post_id);
    }
    public Boolean cai(int post_id){
        return dao.cai(post_id);
    }
}
