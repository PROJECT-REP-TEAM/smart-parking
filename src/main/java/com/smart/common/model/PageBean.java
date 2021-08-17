package com.smart.common.model;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页模板
 * 爪哇笔记 https://blog.52itstyle.vip
 * @author 小柒2012
 */
public class PageBean<T> {

    @TableField(exist = false)
    private List<T> pageData = new ArrayList<>();
    @TableField(exist = false)
    private Integer pageSize = Integer.valueOf(10);
    @TableField(exist = false)
    private Integer pageNo = Integer.valueOf(1);
    @TableField(exist = false)
    private Long totalCount = 0L;
    @TableField(exist = false)
    private String description;
    @TableField(exist = false)
    private String beginTime;
    @TableField(exist = false)
    private String endTime;

    public PageBean(List<T> pageData, Long totalCount) {
        this.pageData = pageData;
        this.totalCount = totalCount;
    }

    public PageBean() {

    }

    public List<T> getPageData() {
        return this.pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNo() {
        return this.pageNo - 1;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}