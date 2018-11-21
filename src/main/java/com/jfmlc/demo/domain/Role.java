package com.jfmlc.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author fumei
 * @date 2018-11-19 14:41
 */
@Data
@Entity
public class Role {

    @ApiModelProperty(value = "角色名称")
    private String name;
}
