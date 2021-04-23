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
 * SysDictType Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "SysDictType Entity", description = "字典key表")
@Data
@TableName("sys_dict_type")
public class SysDictType implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    @TableField(exist = false)
    private Integer item;

    /**
     * 字典类型编码
     */
    @ApiModelProperty(value = "字典类型编码")
    @TableField("type_code")
    private String typeCode;

    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称")
    @TableField("type_name")
    private String typeName;

    /**
     * 字典描述
     */
    @ApiModelProperty(value = "字典描述")
    @TableField("remark")
    private String remark;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

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

    @TableField("add_dt")
    private Date addDt;

    @TableField("edit_by")
    private String editBy;

    @TableField("edit_dt")
    private Date editDt;
    /**
     * 关联的值
     */
    @TableField(exist = false)
    List<SysDictValue> chidlist;

}
