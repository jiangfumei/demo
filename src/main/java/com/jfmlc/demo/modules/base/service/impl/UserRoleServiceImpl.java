package com.jfmlc.demo.modules.base.service.impl;

import com.jfmlc.demo.base.BaseDao;
import com.jfmlc.demo.modules.base.dao.user.UserRoleDao;
import com.jfmlc.demo.modules.base.domain.user.UserRole;
import com.jfmlc.demo.modules.base.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fumei
 * @date 2018-12-04 11:41
 */
@Slf4j
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public BaseDao<UserRole, String> getRepository() {
        return userRoleDao;
    }
}
