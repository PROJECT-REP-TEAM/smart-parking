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
 * 基础配置
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_config")
public class Config extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 唯一标识
     */
    private String configKey;

    /**
     * 值
     */
    private String configValue;

    /**
     * 备注
     */
    private String configRemark;

    /**
     * 创建人
     */
    private Long userIdCreate;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    /**
     * 状态 0 禁用 1 可用
     */
    private Integer status;


}
