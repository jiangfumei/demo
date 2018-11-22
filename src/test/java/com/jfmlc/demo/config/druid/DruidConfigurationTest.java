package com.jfmlc.demo.config.druid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author fumei
 * @date 2018-11-22 11:20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@RestController
public class DruidConfigurationTest {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/dataSource")
    @Test
    public String dataSource() {
        try {
            System.out.println("dataSource = "+dataSource);
            Connection conn = dataSource.getConnection();
            System.out.println("conn = "+conn);
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "end.";
    }

}
