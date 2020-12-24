package pipihorse.Pojo;

/**
 * @Author 皮皮马
 * @create 2020-12-20 22:59
 */
public class Zc {
    private int id;
    private int postId;
    private int userId;
    private int praiseTread;

    @Override
    public String toString() {
        return "Zc{" +
                "id=" + id +
                ", postId=" + postId +
                ", userId=" + userId +
                ", praiseTread=" + praiseTread +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPraiseTread() {
        return praiseTread;
    }

    public void setPraiseTread(int praiseTread) {
        this.praiseTread = praiseTread;
    }
}
