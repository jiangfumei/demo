package com.jfmlc.demo.modules.base.controller;

import com.jfmlc.demo.base.BaseController;
import com.jfmlc.demo.modules.base.service.RolePermissionService;
import com.jfmlc.demo.modules.base.domain.user.RolePermission;
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
@Api(description = "角色权限管理接口")
@RequestMapping("/demo/rolePermission")
@Transactional
public class RolePermissionController extends BaseController<RolePermission, String> {

@Autowired
private RolePermissionService rolePermissionService;

@Override
public RolePermissionService getService(){
        return rolePermissionService;
        }

}
