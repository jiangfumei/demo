package com.jfmlc.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fumei
 * @date 2018-11-19 14:53
 */
@Data
public class Permission {

    @ApiModelProperty(value = "菜单/权限名称")
    private String name;

}
