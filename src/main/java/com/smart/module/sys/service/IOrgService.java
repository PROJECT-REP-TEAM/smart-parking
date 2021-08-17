package com.smart.module.sys.service;

import com.smart.common.model.Result;
import com.smart.module.sys.entity.Org;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.module.sys.entity.Role;

import java.util.List;

/**
 * <p>
 * 机构管理 服务类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-16
 */
public interface IOrgService extends IService<Org> {

    Result listPage(Org org);

    List<Org> select(Long parentId);

}
