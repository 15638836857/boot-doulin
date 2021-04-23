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
 * SysDept Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "部门实体类", description = "部门表")
@Data
@TableName("sys_dept")
public class SysDept implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    @TableField("name")
    private String name;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @TableField("sort_num")
    private Integer sortNum;

    /**
     * 删除标识  0/1
     */
    @ApiModelProperty(value = "删除标识  0/1")
    @TableField("del_flag")
    private Integer delFlag;

    @TableField("add_by")
    private String addBy;
 /**
     * 删除标识  0/1
     */
    @ApiModelProperty(value = "是否正常  0/1")
    @TableField("status")
    private Integer status;

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
