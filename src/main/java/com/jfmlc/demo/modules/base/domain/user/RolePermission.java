package com.jfmlc.demo.modules.base.domain.user;

import com.baomidou.mybatisplus.annotations.TableName;
import com.jfmlc.demo.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
*@author fumei
*@date 2018-11-26 13:51
*/
@Data
@Entity
@Table(name = "t_role_permission")
@TableName("t_role_permission")
public class RolePermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

}
