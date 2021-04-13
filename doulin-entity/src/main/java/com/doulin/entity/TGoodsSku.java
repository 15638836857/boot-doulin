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
 * TGoodsSku Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "TGoodsSku Entity", description = "商品 规格 对应的价格表")
@Data
@TableName("t_goods_sku")
public class TGoodsSku implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("goods_id")
    private Integer goodsId;

    @TableField("sku")
    private String sku;

    /**
     * 原价
     */
    @ApiModelProperty(value = "原价")
    @TableField("price")
    private BigDecimal price;

    /**
     * 促销价
     */
    @ApiModelProperty(value = "促销价")
    @TableField("cu_price")
    private BigDecimal cuPrice;

    @TableField("stock")
    private Integer stock;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    /**
     * 是否禁用  Y/N
     */
    @ApiModelProperty(value = "是否禁用  Y/N")
    @TableField("status")
    private String status;

    /**
     * 删除标识 0/1
     */
    @ApiModelProperty(value = "删除标识 0/1")
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

    @TableField("edit_dt")
    private Date editDt;

}
