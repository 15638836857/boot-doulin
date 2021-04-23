package com.doulin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * SysSalesman Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "业务推广业务员", description = "业务员表")
@Data
@TableName("sys_salesman")
public class SysSalesman implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    @TableField(exist = false)
    private Integer item;

    @TableField("name")
    private String name;

    /**
     * 平台业务员电话
     */
    @ApiModelProperty(value = "平台业务员电话")
    @TableField("phone")
    private String phone;

    /**
     * 推广码
     */
    @ApiModelProperty(value = "推广码")
    @TableField("code")
    private String code;

    /**
     * 业务员 是否禁用
     */
    @ApiModelProperty(value = "业务员 是否禁用 Y/N")
    @TableField("status")
    private String status;

    /**
     * 是否删除  0/1
     */
    @ApiModelProperty(value = "是否删除  0/1")
    @TableField("del_flag")
    private Integer delFlag;

    @TableField("add_by")
    private String addBy;

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    @TableField("add_dt")
    private Date addDt;

    /**
     * 编辑人
     */
    @ApiModelProperty(value = "编辑人")
    @TableField("edit_by")
    private String editBy;

    /**
     * 编辑时间
     */
    @ApiModelProperty(value = "编辑时间")
    @TableField("edit_dt")
    private Date editDt;
    /**
     * 上次推广时间
     */
    @ApiModelProperty(value = "上次推广时间")
    @TableField("extension_dt")
    private Date extensionDt;

    /**
     * 推广数
     */
    @ApiModelProperty(value = "推广数")
    @TableField(exist = false)
    private Integer extensionCount;

    @TableField(exist = false)
    private String statusStr;
    public String getStatusStr(){
        return "Y".equals(status)?"禁用中":"正常";
    }
}
