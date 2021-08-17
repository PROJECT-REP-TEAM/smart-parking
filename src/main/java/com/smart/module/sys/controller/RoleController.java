package com.smart.module.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.common.model.Result;
import com.smart.common.util.ShiroUtils;
import com.smart.module.sys.entity.Role;
import com.smart.module.sys.service.IRoleService;
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
 * 系统角色 前端控制器
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-12
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 角色列表
     */
    @PostMapping("/list")
    public Result list(Role role){
        return roleService.listPage(role);
    }

    /**
     * 角色选择
     */
    @PostMapping("/select")
    public Result select(){
        List<Role> list = roleService.list();
        return Result.ok(list);
    }

    /**
     * 角色选择
     */
    @PostMapping("/selectByUser")
    public Result selectByUser(){
        List<Role> list = roleService.list();
        return Result.ok(list);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresRoles("admin")
    public Result save(@RequestBody Role role){
        QueryWrapper query = new QueryWrapper();
        query.eq("role_sign",role.getRoleSign());
        Role entity = roleService.getOne(query);
        if(entity!=null){
            if(!entity.getRoleSign().equals(role.getRoleSign())){
                return Result.error("角色代码重复");
            }
        }else{
            role.setGmtCreate(LocalDateTime.now());
        }
        role.setGmtModified(LocalDateTime.now());
        role.setOrgId((long)-1);
        role.setUserIdCreate(ShiroUtils.getUserId());
        roleService.saveOrUpdate(role);
        return Result.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresRoles("admin")
    public Result delete(Long roleId){
        roleService.removeById(roleId);
        return Result.ok();
    }

    /**
     * 根据角色ID获取菜单
     */
    @PostMapping("/getMenu")
    public Result getMenu(Long roleId){
        List<String> list = roleService.getMenu(roleId);
        return Result.ok(list);
    }

    /**
     * 根据角色保存菜单
     */
    @PostMapping("/saveMenu")
    @RequiresRoles("admin")
    public Result saveMenu(@RequestBody Role role){
        roleService.saveMenu(role);
        return Result.ok();
    }

    /**
     * 根据角色ID获取机构
     */
    @PostMapping("/getOrg")
    public Result getOrg(Long roleId){
        List<String> list = roleService.getOrg(roleId);
        return Result.ok(list);
    }

    /**
     * 根据角色保存机构
     */
    @PostMapping("/saveOrg")
    @RequiresRoles("admin")
    public Result saveOrg(@RequestBody Role role){
        roleService.saveOrg(role);
        return Result.ok();
    }
}
