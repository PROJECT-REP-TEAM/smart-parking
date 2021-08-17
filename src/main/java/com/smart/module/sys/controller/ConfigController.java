package com.smart.module.sys.controller;


import com.smart.common.model.Result;
import com.smart.common.util.ShiroUtils;
import com.smart.module.sys.entity.Config;
import com.smart.module.sys.service.IConfigService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * <p>
 * 基础配置 前端控制器
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-16
 */
@RestController
@RequestMapping("/sys/config")
public class ConfigController {

    @Autowired
    private IConfigService configService;

    /**
     * 参数列表
     */
    @PostMapping("/list")
    public Result list(Config config){
        return configService.listPage(config);
    }

    /**
     * 获取
     */
    @PostMapping("/get")
    public Result get(Long id){
        Config config = configService.getById(id);
        return Result.ok(config);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresRoles("admin")
    public Result save(@RequestBody Config config){
        config.setUserIdCreate(ShiroUtils.getUserId());
        if (config.getId() == null) {
            config.setGmtCreate(LocalDateTime.now());
        }
        config.setGmtModified(LocalDateTime.now());
        configService.saveOrUpdate(config);
        return Result.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresRoles("admin")
    public Result delete(Long id){
        configService.removeById(id);
        return Result.ok();
    }
}
