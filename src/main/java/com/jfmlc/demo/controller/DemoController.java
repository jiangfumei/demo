package com.jfmlc.demo.controller;

import com.jfmlc.demo.dao.mapper.DemoMapper;
import com.jfmlc.demo.domain.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fumei
 * @date 2018-11-22 16:43
 */
@RestController
@RequestMapping(value = "/demo/demo")
public class DemoController {

    @Autowired
    private DemoMapper demoMapper;

   /* //http://localhost:8888/getUserListByName?userName=xiaoli
    //条件查询
    @GetMapping("getUserListByName")
    public List<Demo> getUserListByName(String userName)
    {
        Map map = new HashMap();
        map.put("user_name", userName);
        return demoMapper.selectByMap(map);
    }*/

    //http://localhost:8888/saveUser?userName=xiaoli&userPassword=111
    //保存用户
    @GetMapping("saveDemo")
    public void insertTest() {
        Demo demo = new Demo();
        demo.setName("李四");
        Integer i = demoMapper.insert(demo);
        Long id = demo.getId();
        System.err.println("影响行数==>" + i);
        System.err.println("id==>" + id);
    }



}
