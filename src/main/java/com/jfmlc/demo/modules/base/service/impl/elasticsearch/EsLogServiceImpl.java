package com.jfmlc.demo.modules.base.service.impl.elasticsearch;

import com.jfmlc.demo.base.BaseDao;
import com.jfmlc.demo.common.vo.SearchVo;
import com.jfmlc.demo.modules.base.dao.elasticsearch.EsLogDao;
import com.jfmlc.demo.modules.base.domain.elasticsearch.EsLog;
import com.jfmlc.demo.modules.base.service.elasticsearch.EsLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private EsLogDao logDao;


    @Override
    public EsLog saveog(EsLog esLog) {
        return null;
    }

    @Override
    public void deleteLog(String id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Page<EsLog> findByCondition(Integer type, String key, SearchVo searchVo, Pageable pageable) {
        return null;
    }

    @Override
    public BaseDao<EsLog, String> getRepository() {
        return null;
    }
}
