package com.jfmlc.demo.domain;

import com.jfmlc.demo.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.List;

/**
 * @author fumei
 * @date 2018-11-19 09:45
 */
@Data
@Entity
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String passWord;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "用户拥有角色")
    private List<Role> roles;


}
