package com.jfmlc.demo.modules.base.service.impl;

import com.jfmlc.demo.modules.base.dao.LogDao;
import com.jfmlc.demo.modules.base.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 日志接口实现
 * @author Exrickx
 */
@Slf4j
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public LogDao getRepository() {
        return logDao;
    }
}
