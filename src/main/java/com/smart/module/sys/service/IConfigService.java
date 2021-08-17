package com.smart.module.sys.service;

import com.smart.common.model.Result;
import com.smart.module.sys.entity.Config;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.module.sys.entity.Role;

/**
 * <p>
 * 基础配置 服务类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-16
 */
public interface IConfigService extends IService<Config> {

    Result listPage(Config config);
}
