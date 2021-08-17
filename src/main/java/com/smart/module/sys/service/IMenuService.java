package com.smart.module.sys.service;

import com.smart.common.model.Result;
import com.smart.module.sys.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.module.sys.entity.User;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-10
 */
public interface IMenuService extends IService<Menu> {

    Result listPage(Menu menu);

    void drop(Long parentId,Long menuId);

    List<Menu> select(Long parentId);

    List<Menu> getByUserId(Long userId);
}
