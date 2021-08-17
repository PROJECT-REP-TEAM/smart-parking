package com.smart.module.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.smart.common.model.PageBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统日志
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_log")
public class Log extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 响应时间
     */
    private Integer time;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求参数
     */
    private String params;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 访问方式 0:PC 1:手机 2:未知
     */
    private Integer deviceType;

    /**
     * 类型 0: 一般日志记录 1: 异常错误日志
     */
    private Integer logType;

    /**
     * 异常详细信息
     */
    private String exceptionDetail;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;


}
