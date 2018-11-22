package com.jfmlc.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author fumei
 * @date 2018-11-19 14:53
 */
@Data
@Entity
public class Permission {

    @ApiModelProperty(value = "菜单/权限名称")
    private String name;

}
