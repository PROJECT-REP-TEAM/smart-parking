package com.smart.module.sys.controller;


import com.smart.common.model.Result;
import com.smart.module.sys.entity.Org;
import com.smart.module.sys.service.IOrgService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 机构管理 前端控制器
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-16
 */
@RestController
@RequestMapping("/sys/org")
public class OrgController {

    @Autowired
    private IOrgService orgService;

    /**
     * 机构列表
     */
    @PostMapping("/list")
    public Result list(Org org){
        return orgService.listPage(org);
    }

    /**
     * 树结构
     */
    @RequestMapping("/select")
    public Result select(Long parentId){
        List<Org> list = orgService.select(parentId);
        return Result.ok(list);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresRoles("admin")
    public Result save(@RequestBody Org org){
        org.setGmtCreate(LocalDateTime.now());
        org.setGmtModified(LocalDateTime.now());
        orgService.saveOrUpdate(org);
        return Result.ok();
    }

    /**
     * 获取
     */
    @PostMapping("/getById")
    @RequiresRoles("admin")
    public Result getById(Long id){
        Org org = orgService.getById(id);
        return Result.ok(org);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresRoles("admin")
    public Result delete(Long orgId){
        orgService.removeById(orgId);
        return Result.ok();
    }
}
