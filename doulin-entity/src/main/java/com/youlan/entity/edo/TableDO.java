package com.youlan.entity.edo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * 表数据
 */
@Slf4j
@Data
public class TableDO implements Serializable {
    //表的名称
    private String tableName;
    //表的备注
    private String comments;
    //表的主键
    private ColumnDO pk;
    //表的列名(不包含主键)
    private List<ColumnDO> columns;

    //类名(第一个字母大写)，如：sys_user => SysUser
    private String className;
    //类名(第一个字母小写)，如：sys_user => sysUser
    private String classname;


    @Override
    public String toString() {
        return "TableDO{" +
                "tableName='" + tableName + '\'' +
                ", comments='" + comments + '\'' +
                ", pk=" + pk +
                ", columns=" + columns +
                ", className='" + className + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}
