package pipihorse.util;

import pipihorse.Pojo.Post;
import pipihorse.Pojo.Reply;

import java.util.List;

/**
 * @Author 皮皮马
 * @create 2020-12-17 19:41
 */
public class Page {
    private List<Post> postList;

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    private int currentPage; //当前页
    private int pageCount; //总页数
    private int pageSize; //每页显示条数
    private int recordCount; //总记录数
    private int beginPageIndex; //页码列表的开始索引
    private int endPageIndex;  //页码列表的结束索引

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", recordCount=" + recordCount +
                ", beginPageIndex=" + beginPageIndex +
                ", endPageIndex=" + endPageIndex +
                '}';
    }



    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getBeginPageIndex() {
        return beginPageIndex;
    }

    public void setBeginPageIndex(int beginPageIndex) {
        this.beginPageIndex = beginPageIndex;
    }

    public int getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(int endPageIndex) {
        this.endPageIndex = endPageIndex;
    }

    public Page(int currentPage, int pageSize, int recordCount){
        this.currentPage=currentPage;
        this.pageSize=pageSize;
        this.recordCount=recordCount;

        //计算其他属性
        pageCount=(recordCount + pageSize - 1) / pageSize;

        // 总页数不大于5页
        if (pageCount <= 5) {
            beginPageIndex = 1;
            endPageIndex = pageCount;
        }
        
        // 总页数大于5页
        else {
            beginPageIndex = currentPage - 4;
            endPageIndex = currentPage + 5;
            if (beginPageIndex < 1) {
                beginPageIndex = 1;
                endPageIndex = 10;
            }
            if (endPageIndex > pageCount) {
                beginPageIndex = pageCount - 10 + 1;
                endPageIndex = pageCount;
            }
        }
    }
}
