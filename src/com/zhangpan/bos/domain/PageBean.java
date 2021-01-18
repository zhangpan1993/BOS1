package com.zhangpan.bos.domain;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class PageBean<T> {

    private int currentPage;//当前页
    private int pageSize;//每页数据大小
    private int total;//总记录数
    private List<T> rows;//数据列表
    private DetachedCriteria detachedCriteria;

    public PageBean() {
    }

    public PageBean(int currentPage, int pageSize, int total, List rows, DetachedCriteria detachedCriteria) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.rows = rows;
        this.detachedCriteria = detachedCriteria;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public DetachedCriteria getDetachedCriteria() {
        return detachedCriteria;
    }

    public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
        this.detachedCriteria = detachedCriteria;
    }

}
