package com.smart.module.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.module.sys.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-10
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getByUserId(Long userId,Long parentId);
}
