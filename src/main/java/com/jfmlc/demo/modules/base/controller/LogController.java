package com.jfmlc.demo.modules.base.controller;

import com.jfmlc.demo.base.BaseController;
import com.jfmlc.demo.common.utils.PageUtil;
import com.jfmlc.demo.common.utils.ResultUtil;
import com.jfmlc.demo.common.vo.PageVo;
import com.jfmlc.demo.common.vo.Result;
import com.jfmlc.demo.common.vo.SearchVo;
import com.jfmlc.demo.modules.base.domain.Log;
import com.jfmlc.demo.modules.base.domain.elasticsearch.EsLog;
import com.jfmlc.demo.modules.base.service.LogService;
import com.jfmlc.demo.modules.base.service.elasticsearch.EsLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author fumei
 * @date 2018-11-26 11:58
 */
@Slf4j
@RestController
@Api(description = "日志管理管理接口")
@RequestMapping("/demo/log")
@Transactional
public class LogController extends BaseController<Log, String>{

        @Value("${demo.logRecord.es}")
        private String esRecord;

        @Autowired
        private EsLogService esLogService;

        @Autowired
        private LogService logService;

        @Override
        public LogService getService(){
                return logService;
                }

        @ApiOperation(value = "分页获取全部")
        public Result<Object> getAllByPage(@RequestParam(required = false) Integer type,
                                           @RequestParam String key,
                                           @ModelAttribute SearchVo searchVo,
                                           @ModelAttribute PageVo pageVo){
                return null;

               /* if(esRecord){
                        Page<EsLog> es = esLogService.findByConfition(type, key, searchVo, PageUtil.initPage(pageVo));
                        return new ResultUtil<Object>().setData(es);
                }else{
                        Page<Log> log = logService.findByConfition(type, key, searchVo, PageUtil.initPage(pageVo));
                        return new ResultUtil<Object>().setData(log);
                }*/
        }




}
