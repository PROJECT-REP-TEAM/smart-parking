package com.smart.module.sys.controller;


import com.smart.common.model.Result;
import com.smart.common.util.ShiroUtils;
import com.smart.module.sys.entity.Menu;
import com.smart.module.sys.service.IMenuService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-10
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(Menu menu){
        return menuService.listPage(menu);
    }

    /**
     * 树结构
     */
    @RequestMapping("/select")
    @RequiresRoles("admin")
    public Result select(Long parentId){
        List<Menu> list = menuService.select(parentId);
        return Result.ok(list);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresRoles("admin")
    public Result save(@RequestBody Menu menu){
        menuService.saveOrUpdate(menu);
        return Result.ok("保存成功");
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresRoles("admin")
    public Result delete(Long menuId){
        menuService.removeById(menuId);
        return Result.ok("删除成功");
    }


    /**
     * 获取菜单
     */
    @RequestMapping("/getByUser")
    public List<Menu> getByUser(){
        return menuService.getByUserId(ShiroUtils.getUserId());
    }


    /**
     * 变更树节点
     */
    @RequestMapping("/drop")
    @RequiresRoles("admin")
    public Result drop(Long parentId,Long menuId){
        menuService.drop(parentId,menuId);
        return Result.ok();
    }
}
