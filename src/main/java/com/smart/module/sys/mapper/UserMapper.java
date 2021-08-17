package com.smart.module.sys.mapper;

import com.smart.module.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<String> listUserRoles(Long userId);

    List<String> listUserPerms(Long userId);
}
