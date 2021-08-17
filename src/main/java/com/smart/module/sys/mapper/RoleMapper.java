package com.smart.module.sys.mapper;

import com.smart.module.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 系统角色 Mapper 接口
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-12
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<String> getMenu(Long roleId);

    List<String> getOrg(Long roleId);

}
