package com.smart.module.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.smart.common.model.PageBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 机构管理
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_org")
public class Org   extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构id
     */
    @TableId(value = "org_id", type = IdType.AUTO)
    private Long orgId;

    /**
     * 上级机构ID，一级机构为0
     */
    private Long parentId;

    /**
     * 机构编码
     */
    private String code;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 机构名称(全称)
     */
    private String fullName;

    /**
     * 机构负责人
     */
    private String director;

    /**
     * 联系邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 可用标识  1：可用  0：不可用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

}
