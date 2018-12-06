package com.jfmlc.demo.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fumei
 * @date 2018-12-05 15:33
 */
@Data
public class EsInfo implements Serializable {

    private String clus_name;

    private String status;

    private String number_of_nodes;

    private Integer count;
}
