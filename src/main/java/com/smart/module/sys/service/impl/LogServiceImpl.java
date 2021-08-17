package com.smart.module.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.model.Result;
import com.smart.module.sys.entity.Log;
import com.smart.module.sys.entity.User;
import com.smart.module.sys.mapper.LogMapper;
import com.smart.module.sys.mapper.UserMapper;
import com.smart.module.sys.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-11
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    @Resource
    private LogMapper logMapper;

    @Override
    public Result listPage(Log log) {
        IPage<Log> page = new Page(log.getPageNo(),log.getPageSize());
        QueryWrapper query = new QueryWrapper<>()
                .like(false,"username ",log.getUsername());
        IPage<Log> list = logMapper.selectPage(page,query);
        return Result.ok(list);
    }
}
