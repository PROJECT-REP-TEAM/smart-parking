package com.smart.module.sys.service;

import com.smart.common.model.Result;
import com.smart.module.sys.entity.Log;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.module.sys.entity.User;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-11
 */
public interface ILogService extends IService<Log> {

    Result listPage(Log log);
}
