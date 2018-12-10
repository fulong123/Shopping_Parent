package com.dream.shopping.solrservice.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/12/5
 * Time: 15:02
 */
@Component
public class PageBean implements Serializable {
    private static final long serialVersionUID = 2400733408054733050L;

    //商品总数
    private long total;
    //商品列表
    private List rows;
    // 总页数
    private int pageCount;
    // 当前页
    private int curPage;

    public PageBean() {
    }

    public PageBean(long total, List rows, int pageCount, int curPage) {
        this.total = total;
        this.rows = rows;
        this.pageCount = pageCount;
        this.curPage = curPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
