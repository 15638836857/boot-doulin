package com.doulin.entity.edo;

import lombok.Data;

import java.io.Serializable;

/**
 * 列的属性
 */
@Data
public class ColumnDO implements Serializable {
    // 列名
    private String columnName;
    // 列名类型
    private String dataType;
    // 列名备注
    private String comments;

    // 属性名称(第一个字母大写)，如：user_name => UserName
    private String attrName;
    // 属性名称(第一个字母小写)，如：user_name => userName
    private String attrname;
    // 属性类型
    private String attrType;
    // auto_increment
    private String extra;

    @Override
    public String toString() {
        return "ColumnDO{" +
                "columnName='" + columnName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", comments='" + comments + '\'' +
                ", attrName='" + attrName + '\'' +
                ", attrname='" + attrname + '\'' +
                ", attrType='" + attrType + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
