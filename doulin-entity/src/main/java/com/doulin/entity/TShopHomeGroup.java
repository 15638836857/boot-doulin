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
 * TShopHomeGroup Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "TShopHomeGroup Entity", description = "商家分类表")
@Data
@TableName("t_shop_home_group")
public class TShopHomeGroup implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(exist = false)
    private Integer item;

    /**
     * 分类图标
     */
    @ApiModelProperty(value = "分类图标 base64编码")
    @TableField("group_img")
    private String groupImg;

    /**
     *
     */
    @ApiModelProperty(value = "分类图标 是否启用 Y/N")
    @TableField("group_img_status")
    private String groupImgStatus;


    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    @TableField("group_name")
    private String groupName;

    /**
     * 分类编码
     */
    @ApiModelProperty(value = "分类编码")
    @TableField("group_code")
    private String groupCode;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "商品图标 是否被禁用 Y/N")
    @TableField("goods_img_status")
    private String  goodsImgStatus;

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
     * 删除标识  0、正常   1、删除
     */
    @ApiModelProperty(value = "删除标识  0、正常   1、删除")
    @TableField("del_flag")
    private Integer delFlag;

    /**
     * 商品分类数
     */
    @ApiModelProperty(value = "商品分类数")
    @TableField(exist = false)
    private Integer goodsCategoryCount;
    /**
     * 商品分类的详情
     */
    @TableField(exist = false)
    private List<TCategory> goodsCategoryList;

}
