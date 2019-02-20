package com.jfmlc.demo.modules.base.controller;

import com.jfmlc.demo.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.jfmlc.demo.modules.base.domain.Department;
import com.jfmlc.demo.modules.base.service.DepartmentService;
import com.jfmlc.demo.common.utils.PageUtil;
import com.jfmlc.demo.common.utils.ResultUtil;
import com.jfmlc.demo.common.vo.PageVo;
import com.jfmlc.demo.common.vo.Result;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;


/**
 * @author fumei
 * @date 2018-11-26 11:58
 */
@Slf4j
@RestController
@Api(description = "部门管理管理接口")
@RequestMapping("/demo/department")
@Transactional
public class DepartmentController extends BaseController<Department, String>{

@Autowired
private DepartmentService departmentService;

@Override
public DepartmentService getService(){
        return departmentService;
        }

}
