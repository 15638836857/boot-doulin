package com.doulin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TUser Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "TUser Entity", description = "用户基础资料表")
@Data
@TableName("t_user")
public class TUser implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    @TableField("user_name")
    private String userName;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    @TableField("nick_name")
    private String nickName;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码")
    @TableField("password")
    private String password;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @TableField("tele_phone")
    private String telePhone;

    /**
     * 是否是商家  Y/N
     */
    @ApiModelProperty(value = "是否是商家  Y/N")
    @TableField("shop_flag")
    private String shopFlag;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    /**
     * 用户logo base64字符串
     */
    @ApiModelProperty(value = "用户logo base64字符串")
    @TableField("user_logo")
    private String userLogo;

    /**
     * 用户余额
     */
    @ApiModelProperty(value = "用户余额")
    @TableField("balance")
    private BigDecimal balance;

    /**
     * 用户性别 0女  1男
     */
    @ApiModelProperty(value = "用户性别 0女  1男")
    @TableField("sex")
    private Integer sex;

    /**
     * 用户职业
     */
    @ApiModelProperty(value = "用户职业")
    @TableField("job")
    private String job;

    /**
     * 添加人
     */
    @ApiModelProperty(value = "添加人")
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

    @TableField("wx_operid")
    private String wxOperid;

    /**
     * 删除标识 0/1
     */
    @ApiModelProperty(value = "删除标识 0/1")
    @TableField("del_flag")
    private Integer delFlag;
    /**
     *  用户是否 禁用 0/1
     */
    @ApiModelProperty(value = "用户是否 禁用 0/1")
    @TableField("status")
    private Integer status;
    /**
     *   极光推送
     */
    @TableField("token")
    private String token;

}
