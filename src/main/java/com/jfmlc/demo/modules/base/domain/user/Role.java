package com.jfmlc.demo.modules.base.domain.user;

import com.baomidou.mybatisplus.annotations.TableName;
import com.jfmlc.demo.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author fumei
 * @date 2018-11-19 14:41
 */
@Data
@Entity
@Table(name = "t_role")
@TableName("t_role")
@ApiModel(value = "角色对象")
public class Role extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名称")
    private String name;
}
