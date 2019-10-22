package com.vote.util;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * <b> 分页通用类 </b>
 * 
 * @author your_username
 * @param <T>
 * 
 */
public class Pager<T> implements Serializable {

    /**
     * 
     */
    //private static final long serialVersionUID = 4542617637761955078L;

    /**
     * pageNow 当前页
     */
    private int pageNow = 1;
    /**
     * pageSize 每页大小
     */
    private int pageSize = 10;
    /**
     * pageCount 总页数
     */
    private int pageCount;
    /**
     * rowCount 总条数
     */
    private int rowCount = 0;
    /**
     * prevPage 前一页
     */
    private int prevPage;
    /**
     * nextPage 下一页
     */
    private int nextPage;
    /**
     * firstPage 第一页
     */
    private int firstPage = 1;
    /**
     * lastPage 最后一页
     */
    private int lastPage;
    /**
     * begin 页面显示的第一个页码
     */
    private int beginPage;
    /**
     * end 页面显示的最后一个页码
     */
    private int endPage;
    /**
     * content 每页的内容
     */
    private List<T> content;

    // 以下set方式是需要赋值的
    /**
     * 设置当前页 <br>
     * 
     * @author your_username
     * 
     * @param pageNow
     */
    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    /**
     * 设置每页大小,也可以不用赋值,默认大小为10条 <br>
     * 
     * @author your_username
     * 
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 设置总条数,默认为0 <br>
     * 
     * @author your_username
     * 
     * @param rowCount
     */
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
        otherAttr();
    }

    /**
     * 设置分页内容 <br>
     * 
     * @author your_username
     * 
     * @param content
     */
    public void setContent(List<T> content) {
        this.content = content;
    }

    /**
     * 设置其他参数
     * 
     * @author your_username
     * 
     */
    public void otherAttr() {
        // 总页数
        this.pageCount = (rowCount - 1)/pageSize + 1;
        // 第一页
        this.firstPage = 1;
        // 最后一页
        this.lastPage = this.pageCount;
        
	    // 前 2 后 2 （显示页码）
		beginPage = pageNow - 2;
		if (beginPage < 1) {
			beginPage = 1;
		}
		endPage = beginPage + 4;
		if (endPage > pageCount) {
			endPage = pageCount;
		}
		beginPage = endPage - 4;
		if (beginPage < 1) {
			beginPage = 1;
		}
        
        // 上一页
        if (this.pageNow > 1) {
            this.prevPage = this.pageNow - 1;
        } else {
            this.prevPage = this.firstPage;
        }
        // 下一页
        if (this.pageNow < this.lastPage) {
            this.nextPage = this.pageNow + 1;
        } else {
            this.nextPage = this.lastPage;
        }
    }

    // 放开私有属性
    public int getPageNow() {
        return pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }
    
    public int getBeginPage() {
        return beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public List<T> getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Pager [PageNow=" + pageNow + ", pageSize=" + pageSize
                + ", pageCount=" + pageCount + ", rowCount=" + rowCount
                + ", prevPage=" + prevPage + ", nextPage=" + nextPage
                + ", firstPage=" + firstPage + ", lastPage=" + lastPage
                + ", content=" + content + "]";
    }

}