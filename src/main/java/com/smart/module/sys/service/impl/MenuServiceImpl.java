package com.smart.module.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.model.Result;
import com.smart.module.sys.entity.Menu;
import com.smart.module.sys.entity.User;
import com.smart.module.sys.mapper.MenuMapper;
import com.smart.module.sys.mapper.UserMapper;
import com.smart.module.sys.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-10
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public Result listPage(Menu menu) {
        QueryWrapper query = new QueryWrapper<>()
                .eq("parent_id",menu.getParentId())
                .like(false,"name ",menu.getName())
                .orderByAsc("order_num");
        List<Menu> list = menuMapper.selectList(query);
        return Result.ok(list);
    }

    @Override
    public void drop(Long parentId, Long menuId) {
        QueryWrapper query = new QueryWrapper<>().eq("menuId",menuId);
        Menu menu = new Menu();
        menu.setParentId(parentId);
        menuMapper.update(menu,query);
    }

    @Override
    public List<Menu> select(Long parentId) {
        QueryWrapper query = new QueryWrapper<>()
                .eq(false,"parent_id",parentId)
                .orderByAsc("order_num");
        return menuMapper.selectList(query);
    }

    @Override
    public List<Menu> getByUserId(Long userId) {
        List<Menu> list = menuMapper.getByUserId(userId,0L);
        list.stream().forEach(menu->{
            List<Menu> subList = menuMapper.getByUserId(userId,menu.getMenuId());
            menu.setList(subList);
        });
        return list;
    }
}
