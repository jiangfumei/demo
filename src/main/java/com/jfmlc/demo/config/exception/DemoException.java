package com.jfmlc.demo.config.exception;

import lombok.Data;

/**
 * @author fumei
 * @date 2018-12-05 16:35
 */
@Data
public class DemoException  extends RuntimeException{

    private String msg;

    public DemoException(String msg){
        super(msg);
        this.msg = msg;
    }


}
