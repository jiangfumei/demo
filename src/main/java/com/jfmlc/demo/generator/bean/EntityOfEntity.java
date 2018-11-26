package com.jfmlc.demo.generator.bean;

import lombok.Data;

/**
 * @author fumei
 * @date 2018-11-26 11:42
 */
@Data
public class EntityOfEntity {

    private String domainPackage;

    private String daoPackage;

    private String servicePackage;

    private String serviceImplPackage;

    private String controllerPackage;

    private String author;

    private String className;

    private String classNameLowerCase;

    private String tableName;

    private String description;

    private String primaryKeyType;

}
