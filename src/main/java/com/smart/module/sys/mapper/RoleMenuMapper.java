package com.smart.module.sys.mapper;

import com.smart.module.sys.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色与菜单对应关系 Mapper 接口
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-16
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

}
