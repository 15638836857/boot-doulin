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
import java.util.List;

/**
 * SysMenu Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "系统菜单实体类", description = "系统菜单表")
@Data
@TableName("sys_menu")
public class SysMenu implements Serializable {
    /**
     * 父级id
     */

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @ApiModelProperty(value = "父级id")
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    @TableField("name")
    private String name;
    /**
     * 菜单介绍
     */
    private String info;

    /**
     * 菜单类型 来源字典表
     */
    @ApiModelProperty(value = "菜单类型 来源字典表")
    @TableField("type")
    private Integer type;
    @TableField(exist = false)
    private String typeName;

    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标 ")
    @TableField("icon")
    private String icon;

    /**
     * 菜单排序
     */
    @ApiModelProperty(value = "菜单排序")
    @TableField("order_num")
    private Integer orderNum;

    /**
     * 删除标识 0/1
     */
    @ApiModelProperty(value = "删除标识 0/1")
    @TableField("del_flag")
    private Integer delFlag;

    /**
     * 添加人
     */
    @ApiModelProperty(value = "添加人")
    @TableField("add_by")
    private String addBy;
    private String perms;
    private String view;

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
     * 子集的信息
     */
    @TableField(exist = false)
    List<SysMenu> childList;

}
