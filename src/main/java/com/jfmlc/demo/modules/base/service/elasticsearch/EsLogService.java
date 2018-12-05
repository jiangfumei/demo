package com.jfmlc.demo.modules.base.service.elasticsearch;

import com.jfmlc.demo.base.BaseService;
import com.jfmlc.demo.common.vo.SearchVo;
import com.jfmlc.demo.modules.base.domain.elasticsearch.EsLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 信息接口
 * @author fumei
 * @date 2018-11-26 13:47
 */
public interface EsLogService extends BaseService<EsLog,String> {

        /**
         * 添加日志
         * @param esLog
         * @return
         */
        EsLog saveog(EsLog esLog);

        /**
         * 通过id删除日志
         * @param id
         */
        void deleteLog(String id);

        /**
         * 删除全部日志
         */
        void deleteAll();

        /**
         * 分页搜索获取日志
         * @param type
         * @param key
         * @param searchVo
         * @param pageable
         * @return
         */
        Page<EsLog> findByCondition(Integer type, String key, SearchVo searchVo, Pageable pageable);

        }
