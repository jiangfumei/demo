package com.jfmlc.demo.modules.base.service.impl.elasticsearch;

import com.jfmlc.demo.base.BaseDao;
import com.jfmlc.demo.modules.base.dao.elasticsearch.EsLogDao;
import com.jfmlc.demo.modules.base.domain.elasticsearch.EsLog;
import com.jfmlc.demo.modules.base.service.elasticsearch.EsLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fumei
 * @date 2018-12-04 16:51
 */
@Service
@Transactional
@Slf4j
public class EsLogServiceImpl implements EsLogService {

    @Autowired
    private EsLogDao esLogDao;

    @Override
    public BaseDao<EsLog, String> getRepository() {
        return esLogDao;
    }
}
