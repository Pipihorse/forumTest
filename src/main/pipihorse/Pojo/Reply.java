package pipihorse.Pojo;

/**
 * @Author 皮皮马
 * @create 2020-12-16 14:08
 */
public class Reply {
    private int id;
    private int sendId;
    private int userId;
    private String replyContent;
    private int praiseTread;
    private String replyDate;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", sendId=" + sendId +
                ", userId=" + userId +
                ", replyContent='" + replyContent + '\'' +
                ", praiseTread=" + praiseTread +
                ", replyDate='" + replyDate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSendId() {
        return sendId;
    }

    public void setSendId(int sendId) {
        this.sendId = sendId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public int getPraiseTread() {
        return praiseTread;
    }

    public void setPraiseTread(int praiseTread) {
        this.praiseTread = praiseTread;
    }

    public String getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(String replyDate) {
        this.replyDate = replyDate;
    }
}
