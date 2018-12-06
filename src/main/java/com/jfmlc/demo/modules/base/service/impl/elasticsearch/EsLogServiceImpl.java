package com.jfmlc.demo.modules.base.service.impl.elasticsearch;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.jfmlc.demo.base.BaseDao;
import com.jfmlc.demo.common.vo.SearchVo;
import com.jfmlc.demo.modules.base.dao.elasticsearch.EsLogDao;
import com.jfmlc.demo.modules.base.domain.elasticsearch.EsLog;
import com.jfmlc.demo.modules.base.service.elasticsearch.EsLogService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.hibernate.cfg.annotations.QueryBinder;
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

        return logDao.save(esLog);
    }

    @Override
    public void deleteLog(String id) {
        logDao.deleteById(id);

    }

    @Override
    public void deleteAll() {
        logDao.deleteAll();

    }

    @Override
    public Page<EsLog> findByCondition(Integer type, String key, SearchVo searchVo, Pageable pageable) {
        if (type==null&& StrUtil.isBlank(key)&&StrUtil.isBlank((searchVo.getStartDate()))){
            // 无过滤条件获取全部
            return logDao.findAll(pageable);
        }else if (type!=null&&StrUtil.isBlank(key)&&StrUtil.isBlank(searchVo.getStartDate())){
            //仅有type
            return logDao.findByLogType(type,pageable);
        }

        QueryBuilder qb;

        QueryBuilder qb0 = QueryBuilders.termQuery("logType",type);
        QueryBuilder qb1 = QueryBuilders.multiMatchQuery(key,"name","requestUrl","requestType","requestParam","userName","ip","ipInfo");
        //在有type条件下
        if (StrUtil.isNotBlank(key)&&StrUtil.isNotBlank(searchVo.getStartDate())&&StrUtil.isNotBlank(searchVo.getEndDate())){
            //仅有key
            qb = QueryBuilders.boolQuery().must(qb0).must(qb1);
        }else if (StrUtil.isBlank(key)&&StrUtil.isNotBlank(searchVo.getStartDate())&&StrUtil.isNotBlank(searchVo.getEndDate())){
            //仅有时间范围
            Long start = DateUtil.parse(searchVo.getStartDate()).getTime();
            Long end = DateUtil.endOfDay(DateUtil.parse(searchVo.getEndDate())).getTime();
            QueryBuilder qb2 = QueryBuilders.rangeQuery("timeMills").gte(start).lte(end);
            qb = QueryBuilders.boolQuery().must(qb0).must(qb2);

        }else{
            //两者都有
            Long start = DateUtil.parse(searchVo.getStartDate()).getTime();
            Long end = DateUtil.endOfDay(DateUtil.parse(searchVo.getEndDate())).getTime();
            QueryBuilder qb2 = QueryBuilders.rangeQuery("timeMills").gte(start).lte(end);
            qb = QueryBuilders.boolQuery().must(qb0).must(qb2);

        }
        //多字段搜索
        return logDao.search(qb,pageable);
    }


}
