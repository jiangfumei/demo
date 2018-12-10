package com.jfmlc.demo.modules.base.domain;

import com.jfmlc.demo.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author fumei
 */
@Data
@Entity
@Table(name = "t_department")
@TableName("t_department")
public class Department extends BaseEntity {

    private static final long serialVersionUID = 1L;

}
