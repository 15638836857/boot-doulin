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
 * SysRoleMenu Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "角色和菜单的框架", description = "系统角色菜单表")
@Data
@TableName("sys_role_menu")
public class SysRoleMenu implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private String roleId;

    @TableField(exist = false)
    private String roleName;

    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    @TableField("menu_id")
    private String menuId;

    @TableField(exist = false)
    private String menuName;
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

}
