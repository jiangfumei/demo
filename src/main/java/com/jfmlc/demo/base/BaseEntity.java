package com.jfmlc.demo.base;

import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfmlc.demo.common.constants.Constants;
import com.jfmlc.demo.common.utils.SnowFlakeUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author fumei
 * @date 2018-11-21 15:00
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)//添加监听器
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "唯一标识 id")
    private String id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @CreatedDate
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @LastModifiedDate
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateDate;

    @CreatedBy
    @ApiModelProperty(value = "创建者")
    private String createdBy;

    @LastModifiedBy
    @ApiModelProperty(value = "更新者")
    private String updatedBy;

    @ApiModelProperty(value = "删除标志 默认正常状态 0")
    private Integer delFlag = Constants.DEL_NORMAL;
}
