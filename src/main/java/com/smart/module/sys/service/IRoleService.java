package com.smart.module.sys.service;

import com.smart.common.model.Result;
import com.smart.module.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.module.sys.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 系统角色 服务类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-12
 */
public interface IRoleService extends IService<Role> {

    Result listPage(Role Role);

    List<String> getMenu(Long roleId);

    List<String> getOrg(Long roleId);

    void saveMenu(Role role);

    void saveOrg(Role role);
}
