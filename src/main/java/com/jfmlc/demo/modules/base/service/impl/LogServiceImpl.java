package com.jfmlc.demo.modules.base.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.jfmlc.demo.common.vo.SearchVo;
import com.jfmlc.demo.modules.base.dao.LogDao;
import com.jfmlc.demo.modules.base.domain.Log;
import com.jfmlc.demo.modules.base.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public Page<Log> findByCondition(Integer type, String key, SearchVo searchVo, Pageable pageable) {
        return logDao.findAll(new Specification<Log>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Log> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Path<String> nameField = root.get("name");
                Path<String> requestUrlField = root.get("requestUrl");
                Path<String> requestTypeField = root.get("requestType");
                Path<String> requestParamField = root.get("requestParam");
                Path<String> userNameField = root.get("userName");
                Path<String> ipField = root.get("ip");
                Path<String> ipInfoField = root.get("ipInfo");
                Path<Date> createTimeField = root.get("createTime");

                List<Predicate> list = new ArrayList<>();
                //类型
                if (type != null)
                    list.add(criteriaBuilder.equal(root.get("logType").as(Integer.class),type));

                //模糊查询
                if (StrUtil.isNotBlank(key)){
                    Predicate p1 = criteriaBuilder.like(requestUrlField,'%'+key+'%');
                    Predicate p2 = criteriaBuilder.like(requestTypeField,'%'+key+'%');
                    Predicate p3 = criteriaBuilder.like(requestParamField,'%'+key+'%');
                    Predicate p4 = criteriaBuilder.like(userNameField,'%'+key+'%');
                    Predicate p5 = criteriaBuilder.like(ipField,'%'+key+'%');
                    Predicate p6 = criteriaBuilder.like(ipInfoField,'%'+key+'%');
                    Predicate p7 = criteriaBuilder.like(nameField,'%'+key+'%');
                    list.add(criteriaBuilder.or(p1,p2,p3,p4,p5,p6,p7));
                }

                //创建时间
                if (StrUtil.isNotBlank(searchVo.getStartDate())&&StrUtil.isNotBlank(searchVo.getEndDate())){
                    Date start = DateUtil.parse(searchVo.getStartDate());
                    Date end = DateUtil.parse(searchVo.getEndDate());
                    list.add(criteriaBuilder.between(createTimeField, start, end));
                }

                Predicate[] arr = new Predicate[list.size()];
                criteriaQuery.where(list.toArray(arr));
                return null;
            }
        },pageable);
    }

    @Override
    public void deleteAll() {

        logDao.deleteAll();

    }
}
