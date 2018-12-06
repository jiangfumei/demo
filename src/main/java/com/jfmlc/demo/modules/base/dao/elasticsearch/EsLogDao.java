package com.jfmlc.demo.modules.base.dao.elasticsearch;

import com.jfmlc.demo.modules.base.domain.elasticsearch.EsLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
*信息数据处理层
*@author fumei
*@date 2018-11-26 13:50
*/
public interface EsLogDao extends ElasticsearchRepository<EsLog, String> {

    /**
     * 通过类型获取
     * @param type
     * @param pageable
     * @return
     */
    Page<EsLog> findByLogType(Integer type, Pageable pageable);

}
