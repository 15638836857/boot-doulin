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
 * TCategory Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "TCategory Entity", description = "商品分类表")
@Data
@TableName("t_category")
public class TCategory implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    @TableField("name")
    private String name;

    /**
     * 商家分类id
     */
    @ApiModelProperty(value = "商家分类id")
    @TableField("shop_group_id")
    private Integer shopGroupId;
    /**
     * 父级id
     */
    @ApiModelProperty(value = "父级id")
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 分类的图片  base64 字符串
     */
    @ApiModelProperty(value = "分类的图片  base64 字符串")
    @TableField("image")
    private String image;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    /**
     * 是否禁用 Y/N
     */
    @ApiModelProperty(value = "是否禁用 Y/N")
    @TableField("status")
    private String status;

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

    @TableField("add_dt")
    private Date addDt;

    @TableField("edit_by")
    private String editBy;

    @TableField("edit_dt")
    private Date editDt;

}
