package com.jfmlc.demo.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author fumei
 * @date 2018-11-21 15:00
 */
@Data
@Entity
public class BaseEntity {

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "更新日期")
    private Date updateDate;

    @ApiModelProperty(value = "创建者")
    private String createdBy;

    @ApiModelProperty(value = "更新者")
    private String updatedBy;

    @ApiModelProperty(value = "删除标志 默认正常状态 0")
    private Integer delFlag;
}
