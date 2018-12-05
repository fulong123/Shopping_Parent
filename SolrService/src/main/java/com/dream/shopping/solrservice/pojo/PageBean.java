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

    //当前页
    private long total;
    //当前页记录
    private List rows;

    public PageBean() {
    }

    public PageBean(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
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
