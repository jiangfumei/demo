package com.jfmlc.demo.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author fumei
 * @date 2018-11-22 14:28
 */
@Data
@Entity
@TableName("t_demo")
public class Demo implements Serializable {
    @ApiModelProperty(value = "唯一标识 id")
    private Long id;

    @ApiModelProperty(value = "demo name")
    private String name;


}
