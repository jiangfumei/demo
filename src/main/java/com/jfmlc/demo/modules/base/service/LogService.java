package com.jfmlc.demo.modules.base.service;

import com.jfmlc.demo.base.BaseService;
import com.jfmlc.demo.common.vo.SearchVo;
import com.jfmlc.demo.modules.base.domain.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 日志管理接口
 * @author fumei
 * @date 2018-11-26 13:47
 */
public interface LogService extends BaseService<Log,String> {

        /**
         * 分页搜索获取日志
         * @param type
         * @param key
         * @param searchVo
         * @param pageable
         * @return
         */
        Page<Log> findByCondition(Integer type, String key, SearchVo searchVo, Pageable pageable);

        /**
         * 删除所有
         */
        void deleteAll();

        }
