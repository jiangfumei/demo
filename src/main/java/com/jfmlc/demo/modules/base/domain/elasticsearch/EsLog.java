package com.jfmlc.demo.modules.base.domain.elasticsearch;

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
@Table(name = "t_es_log")
@TableName("t_es_log")
public class EsLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

}
