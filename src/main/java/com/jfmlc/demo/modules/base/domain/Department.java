package com.jfmlc.demo.modules.base.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jfmlc.demo.base.BaseEntity;
import com.jfmlc.demo.common.constants.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * @author fumei
 */
@Data
@Entity
@Table(name = "t_department")
@TableName("t_department")
public class Department extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门名称")
    private  String department;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "是否为父节点（含子节点） 默认false")
    private Boolean isParent =false;

    @ApiModelProperty(value = "排序值")
    @Column(precision = 10, scale = 2)
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用  0启用  -1禁用")
    private Integer status = Constants.STATUS_ENABLE;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "父节点名称")
    private String parentTitle;

}
