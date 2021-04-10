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
 * SysLog Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "SysLog Entity", description = "系统访问日志表")
@Data
@TableName("sys_log")
public class SysLog implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型 ")
    @TableField("user_type")
    private String userType;
    /**
     * 操作
     */
    @ApiModelProperty(value = "操作")
    @TableField("operation")
    private String operation;

    /**
     * 响应时间
     */
    @ApiModelProperty(value = "响应时间")
    @TableField("time")
    private Integer time;

    /**
     * 请求方式
     */
    @ApiModelProperty(value = "请求方式")
    @TableField("method")
    private String method;

    /**
     * 请求参数
     */
    @ApiModelProperty(value = "请求参数")
    @TableField("params")
    private String params;

    /**
     * 请求ip
     */
    @ApiModelProperty(value = "请求ip")
    @TableField("ip")
    private String ip;

    /**
     * 0/1 删除标识
     */
    @ApiModelProperty(value = "0/1 删除标识")
    @TableField("del_flag")
    private Integer delFlag;

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    @TableField("add_dt")
    private Date addDt;

}
