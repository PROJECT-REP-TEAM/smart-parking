package com.smart.module.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.model.Result;
import com.smart.module.sys.entity.User;
import com.smart.module.sys.mapper.UserMapper;
import com.smart.module.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result listPage(User user) {
        IPage<User> page = new Page(user.getPageNo(),user.getPageSize());
        QueryWrapper query = new QueryWrapper<>()
                .like(false,"username ",user.getUsername())
                .or().like(false,"nickname ",user.getNickname());
        IPage<User> list = userMapper.selectPage(page,query);
        return Result.ok(list);
    }

    @Override
    public User getUser(String username) {
        QueryWrapper query = new QueryWrapper();
        query.eq("username",username);
        return userMapper.selectOne(query);
    }

    @Override
    public List<String> listUserRoles(Long userId) {
        return userMapper.listUserRoles(userId);
    }

    @Override
    public List<String> listUserPerms(Long userId) {
        return userMapper.listUserPerms(userId);
    }
}
