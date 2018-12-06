package com.jfmlc.demo.modules.base.controller.user;

import com.jfmlc.demo.base.BaseController;
import com.jfmlc.demo.modules.base.domain.user.UserRole;
import com.jfmlc.demo.modules.base.service.UserRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author fumei
 * @date 2018-11-26 11:58
 */
@RestController
@Api(description = "用户角色管理接口")
@RequestMapping("/demo/userRole")
@Transactional
public class UserRoleController extends BaseController<UserRole, String> {

@Autowired
private UserRoleService userRoleService;

@Override
public UserRoleService getService(){
        return userRoleService;
        }

}





















