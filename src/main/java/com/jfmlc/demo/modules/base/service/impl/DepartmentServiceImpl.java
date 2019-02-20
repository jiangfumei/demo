package com.jfmlc.demo.modules.base.service.impl;

import com.jfmlc.demo.modules.base.dao.DepartmentDao;
import com.jfmlc.demo.modules.base.domain.Department;
import com.jfmlc.demo.modules.base.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门管理接口实现
 * @author fumei
 */
@Slf4j
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public DepartmentDao getRepository() {
        return departmentDao;
    }
}
