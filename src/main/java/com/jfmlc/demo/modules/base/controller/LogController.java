package com.jfmlc.demo.modules.base.controller;

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
import org.springframework.web.bind.annotation.*;


/**
 * @author fumei
 * @date 2018-11-26 11:58
 */
@Slf4j
@RestController
@Api(description = "日志管理管理接口")
@RequestMapping("/demo/log")
@Transactional
public class LogController{

        @Value("${demo.logRecord.es}")
        private Boolean esRecord;

        @Autowired
        private EsLogService esLogService;

        @Autowired
        private LogService logService;

        @Autowired
        public LogService getService(){
                return logService;
                }

        @ApiOperation(value = "分页获取全部")
        public Result<Object> getAllByPage(@RequestParam(required = false) Integer type,
                                           @RequestParam String key,
                                           @ModelAttribute SearchVo searchVo,
                                           @ModelAttribute PageVo pageVo){

                if(esRecord){
                        Page<EsLog> es = esLogService.findByCondition(type, key, searchVo, PageUtil.initPage(pageVo));
                        return new ResultUtil<Object>().setData(es);
                }else{
                        Page<Log> log = logService.findByCondition(type, key, searchVo, PageUtil.initPage(pageVo));
                        return new ResultUtil<Object>().setData(log);
                }
        }

        @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
        @ApiOperation(value = "批量删除")
        public Result<Object> delByIds(@PathVariable String[] ids){
                for (String id : ids){
                        if (esRecord){
                                esLogService.deleteLog(id);
                        }else {
                                logService.delete(id);
                        }
                }
                return new ResultUtil<Object>().setSuccessMsg("删除成功");
        }


        @RequestMapping(value = "/delAll",method = RequestMethod.DELETE)
        @ApiOperation(value = "删除全部")
        public Result<Object> delAll(){
                if (esRecord){
                        esLogService.deleteAll();
                }else {
                        logService.deleteAll();
                }
                return new ResultUtil<Object>().setSuccessMsg("删除全部成功");

        }


}
