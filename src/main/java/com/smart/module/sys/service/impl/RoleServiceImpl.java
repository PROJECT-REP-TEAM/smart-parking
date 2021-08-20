package com.smart.module.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.common.model.Result;
import com.smart.module.sys.entity.Role;
import com.smart.module.sys.entity.RoleMenu;
import com.smart.module.sys.entity.RoleOrg;
import com.smart.module.sys.mapper.RoleMapper;
import com.smart.module.sys.mapper.RoleMenuMapper;
import com.smart.module.sys.mapper.RoleOrgMapper;
import com.smart.module.sys.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统角色 服务实现类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private RoleOrgMapper roleOrgMapper;

    @Override
    public Result listPage(Role role) {
        IPage<Role> page = new Page(role.getPageNo(),role.getPageSize());
        QueryWrapper query = new QueryWrapper<>()
                .like(false,"role_sign ",role.getRoleSign())
                .or().like(false,"role_name ",role.getRoleName());
        IPage<Role> list = roleMapper.selectPage(page,query);
        return Result.ok(list);
    }

    @Override
    public List<String> getMenu(Long roleId) {
        return roleMapper.getMenu(roleId);
    }

    @Override
    public List<String> getOrg(Long roleId) {
        return roleMapper.getOrg(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveMenu(Role role) {
        Long roleId = role.getRoleId();
        QueryWrapper query = new QueryWrapper<>().eq("role_id",roleId);
        roleMenuMapper.delete(query);
        List<Long> menuIdList = role.getMenuIdList();
        if(menuIdList!=null){
            menuIdList.forEach(menuId->{
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setMenuId(menuId);
                roleMenu.setRoleId(roleId);
                roleMenuMapper.insert(roleMenu);
            });
        }
    }

    @Override
    public void saveOrg(Role role) {
        Long roleId = role.getRoleId();
        QueryWrapper query = new QueryWrapper<>().eq("role_id",roleId);
        roleOrgMapper.delete(query);
        List<Long> menuIdList = role.getOrgIdList();
        if(menuIdList!=null){
            menuIdList.forEach(orgId->{
                RoleOrg roleOrg = new RoleOrg();
                roleOrg.setOrgId(orgId);
                roleOrg.setRoleId(roleId);
                roleOrgMapper.insert(roleOrg);
            });
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result deleteById(Long roleId) {
        roleMapper.deleteById(roleId);
        QueryWrapper query = new QueryWrapper<>().eq("role_id",roleId);
        roleMenuMapper.delete(query);
        return Result.ok("删除成功");
    }
}
