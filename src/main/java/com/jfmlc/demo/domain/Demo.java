package com.jfmlc.demo.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import com.jfmlc.demo.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author fumei
 * @date 2018-11-22 14:28
 */
@Data
@Entity
@TableName("t_demo")
public class Demo extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "demo name")
    private String name;


}
