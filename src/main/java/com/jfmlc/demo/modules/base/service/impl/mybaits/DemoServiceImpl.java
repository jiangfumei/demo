package com.jfmlc.demo.modules.base.service.impl.mybaits;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jfmlc.demo.modules.base.dao.mapper.DemoMapper;
import com.jfmlc.demo.modules.base.domain.Demo;
import com.jfmlc.demo.modules.base.service.mybaits.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fumei
 * @date 2018-12-04 15:20
 */
@Slf4j
@Service
@Transactional
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {
}
