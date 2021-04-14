package com.doulin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
* SysUserRole Entity
* @Author: malinging
* @Date: 2021-04-14
*/
@ApiModel(value="用户角色关联表", description="")
@Data
@TableName("sys_user_role")
public class SysUserRole implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
    * 用户id
    */
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;

    @TableField(exist = false)
    private String  userName;
    /**
    * 角色id
    */
    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private Integer roleId;

    @TableField(exist = false)
    private String  roleName;


}
