package com.smart.module.sys.controller;


import com.smart.common.model.Result;
import com.smart.module.sys.entity.Log;
import com.smart.module.sys.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统日志 前端控制器
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-11
 */
@RestController
@RequestMapping("/sys/log")
public class LogController {

    @Autowired
    private ILogService logService;

    /**
     * 日志列表
     */
    @PostMapping("/list")
    public Result list(Log log){
        return logService.listPage(log);
    }
}
