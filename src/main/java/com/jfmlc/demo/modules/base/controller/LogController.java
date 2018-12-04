package com.jfmlc.demo.modules.base.controller;

import com.jfmlc.demo.base.BaseController;
import com.jfmlc.demo.modules.base.domain.Log;
import com.jfmlc.demo.modules.base.service.LogService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author fumei
 * @date 2018-11-26 11:58
 */
@Slf4j
@RestController
@Api(description = "日志管理管理接口")
@RequestMapping("/demo/log")
@Transactional
public class LogController extends BaseController<Log, String>{

@Autowired
private LogService logService;

@Override
public LogService getService(){
        return logService;
        }

}
