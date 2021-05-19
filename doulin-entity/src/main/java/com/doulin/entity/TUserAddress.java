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
 * TUserAddress Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "TUserAddress Entity", description = "用户地址表")
@Data
@TableName("t_user_address")
public class TUserAddress implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;

    /**
     * 社区编码
     */
    @ApiModelProperty(value = "社区编码")
    @TableField("community_code")
    private String communityCode;

    @TableField("address")
    private String address;

    /**
     * 是否默认 Y/N
     */
    @ApiModelProperty(value = "是否默认 Y/N")
    @TableField("default_flag")
    private String defaultFlag;

    /**
     * 删除标识  0/1
     */
    @ApiModelProperty(value = "删除标识  0/1")
    @TableField("del_flag")
    private Integer delFlag;

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
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    @TableField("tele_phone")
    private String telePhone;

}
