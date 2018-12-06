package com.jfmlc.demo.common.vo;

import lombok.Data;

import java.io.Serializable;

/** *
 * @author fumei
 * @date 2018-12-04 17:37
 */
@Data
public class SearchVo implements Serializable {

    private String startDate;

    private String endDate;
}
