package com.smart.module.sys.controller;


import com.smart.common.model.Result;
import com.smart.common.util.MD5Utils;
import com.smart.common.util.ShiroUtils;
import com.smart.module.sys.entity.User;
import com.smart.module.sys.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-09
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户列表
     */
    @RequestMapping("/list")
    public Result list(User user){
        return userService.listPage(user);
    }

    /**
     * 获取
     */
    @PostMapping("/get")
    public Result get(Long userId){
        User user = userService.getById(userId);
        return Result.ok(user);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresRoles("admin")
    public Result save(@RequestBody User user){
        User entity = userService.getUser(user.getUsername());
        if (entity!=null){
            if(user.getUserId().intValue() != entity.getUserId().intValue()){
                if(user.getUsername().equals(entity.getUsername())){
                    return Result.error("用户名重复！");
                }
            }
        }
        userService.saveOrUpdate(user);
        return Result.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresRoles("admin")
    public Result delete(Long userId){
        userService.removeById(userId);
        return Result.ok();
    }

    /**
     * 修改密码
     */
    @PostMapping("/updatePwd")
    @RequiresRoles("admin")
    public Result updatePwd(User user){
        String password = MD5Utils.encrypt(user.getUsername(),user.getPassword());
        User sysUser = new User();
        sysUser.setUserId(user.getUserId());
        sysUser.setPassword(password);
        userService.updateById(sysUser);
        return Result.ok();
    }

    /**
     * 获取当前用户信息
     */
    @PostMapping("/info")
    public Result info(){
        User user = userService.getById(ShiroUtils.getUserId());
        return Result.ok(user);
    }

    /**
     * 更新用户信息
     */
    @PostMapping("/update")
    @RequiresRoles("admin")
    public Result update(@RequestBody User user){
        userService.updateById(user);
        return Result.ok();
    }
}
