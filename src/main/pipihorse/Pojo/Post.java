package pipihorse.Pojo;

/**
 * @Author 皮皮马
 * @create 2020-12-16 14:08
 */
public class Post {
    private int id;
    private int userId;     //发帖用户
    private int forum;      //所属板块
    private String title;   //标题
    private String content;  //内容
    private String image;   //图片
    private  int postType;  //帖子类型
    private int viewNum;    //浏览人数
    private int replyNum;  //帖子回复数
    private String sendDate; //发帖时间
    private int tread;  //点踩人数
    private int praise;      //点赞人数

    public int getTread() {
        return tread;
    }

    public void setTread(int tread) {
        this.tread = tread;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int prais) {
        this.praise = prais;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getForum() {
        return forum;
    }

    public void setForum(int forum) {
        this.forum = forum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", forum=" + forum +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", postType=" + postType +
                ", viewNum=" + viewNum +
                ", replyNum=" + replyNum +
                ", sendDate='" + sendDate + '\'' +
                '}';
    }
}
