package com.jfmlc.demo.modules.base.service.impl;

import com.jfmlc.demo.base.BaseDao;
import com.jfmlc.demo.modules.base.dao.user.RolePermissionDao;
import com.jfmlc.demo.modules.base.domain.user.RolePermission;
import com.jfmlc.demo.modules.base.service.RolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fumei
 * @date 2018-12-04 15:49
 */
@Slf4j
@Service
@Transactional
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    public BaseDao<RolePermission, String> getRepository() {
        return rolePermissionDao;
    }
}
