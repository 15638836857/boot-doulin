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
 * SysUser Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "用户实体类", description = "系统用户表")
@Data
@TableName("sys_user")
public class SysUser implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    /**
     * 序号
     */
    @TableField(exist = false)
    private Integer item;

    /**
     * 手机号 登录号
     */
    @ApiModelProperty(value = "手机号")
    @TableField("tele_phone")
    private String telePhone;
    @ApiModelProperty(value = "联系方式")
    @TableField("login_no")
    private String login_no;
    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    @TableField("password")
    private String password;
    /**
     * 账户是否锁定  0 无  1是
     */
    @ApiModelProperty(value = "账户是否锁定")
    @TableField("status")
    private Integer status;

    /**
     * 真实名称
     */
    @ApiModelProperty(value = "真实名称")
    @TableField("real_name")
    private String realName;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    @TableField("dept_id")
    private Integer deptId;

    /**
     * 头像 base64 字符串
     */
    @ApiModelProperty(value = "头像 base64 字符串")
    @TableField("photo")
    private String photo;

    /**
     * 最后一次登录
     */
    @ApiModelProperty(value = "最后一次登录")
    @TableField("last_login_ip")
    private String lastLoginIp;

    /**
     * 最后登录的时间
     */
    @ApiModelProperty(value = "最后登录的时间")
    @TableField("last_login_date")
    private Date lastLoginDate;

    /**
     * 是否可以登录 Y/N
     */
    @ApiModelProperty(value = "是否可以登录 Y/N")
    @TableField("login_flag")
    private String loginFlag;

    /**
     * 删除状态 0/1
     */
    @ApiModelProperty(value = "删除状态 0/1")
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
     * 角色id 多个使用英文逗号间隔
     */
    @TableField(exist = false)
    private String roleId;

}
