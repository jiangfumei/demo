package com.jfmlc.demo.modules.base.controller.elasticsearch;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import com.jfmlc.demo.common.utils.ResultUtil;
import com.jfmlc.demo.common.vo.EsCount;
import com.jfmlc.demo.common.vo.EsInfo;
import com.jfmlc.demo.common.vo.Result;
import com.jfmlc.demo.config.exception.DemoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fumei
 * @date 2018-12-05 15:18
 */
@Slf4j
@RestController
@Api(description = "Elasticsearch信息接口")
@RequestMapping("/demo/es")
@Transactional
public class EsLogController {

    @Value("${demo.elasticsearch.nodeClient}")
    private String ES_NODE_CLIENT;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ApiOperation(value = "获取es状态")
    public Result<EsInfo> getAllByPage(){
        String healthUrl = "http://"+ES_NODE_CLIENT+"_cluster/health";
        String countUrl = "http://"+ES_NODE_CLIENT+"_count";
        String healthResult = HttpUtil.get(healthUrl);
        String countResult = HttpUtil.get(countUrl);
        if (StrUtil.isBlank(healthResult) || StrUtil.isBlank(countResult)){
            throw new DemoException("连接ES失败，请检查ES运行状态");
        }
        EsInfo esInfo = new EsInfo();
        EsCount esCount = new EsCount();
        try{
            esInfo = new Gson().fromJson(healthResult,EsInfo.class);
            esCount = new Gson().fromJson(countResult,EsCount.class);
            esInfo.setCount(esCount.getCount());
        }catch(Exception e){
            e.printStackTrace();
            throw new DemoException("获取es信息错误");
        }
        return new ResultUtil<EsInfo>().setData(esInfo);
    }

}
