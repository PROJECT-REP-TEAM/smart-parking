package com.smart.module.sys.service;

import com.smart.common.model.Result;
import com.smart.module.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-09
 */
public interface IUserService extends IService<User> {

    Result listPage(User user);

    User getUser(String username);

    List<String> listUserRoles(Long userId);

    List<String> listUserPerms(Long userId);
}
