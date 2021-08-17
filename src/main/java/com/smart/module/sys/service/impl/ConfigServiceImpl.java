package com.smart.module.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.model.Result;
import com.smart.module.sys.entity.Config;
import com.smart.module.sys.entity.Log;
import com.smart.module.sys.mapper.ConfigMapper;
import com.smart.module.sys.service.IConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 基础配置 服务实现类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-16
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

    @Resource
    private ConfigMapper configMapper;

    @Override
    public Result listPage(Config config) {
        IPage<Config> page = new Page(config.getPageNo(),config.getPageSize());
        QueryWrapper query = new QueryWrapper<>()
                .like(false,"config_key ",config.getConfigKey());
        IPage<Config> list = configMapper.selectPage(page,query);
        return Result.ok(list);
    }
}
