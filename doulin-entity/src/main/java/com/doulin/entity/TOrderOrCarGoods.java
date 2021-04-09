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
 * TOrderOrCarGoods Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "TOrderOrCarGoods Entity", description = "订单商品或购物车商品表")
@Data
@TableName("t_order_or_car_goods")
public class TOrderOrCarGoods implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品sku id
     */
    @ApiModelProperty(value = "商品sku id")
    @TableField("goods_sku_id")
    private Long goodsSkuId;

    /**
     * 购物车id
     */
    @ApiModelProperty(value = "购物车id")
    @TableField("car_id")
    private Long carId;

    /**
     * 加入购物车价格
     */
    @ApiModelProperty(value = "加入购物车价格")
    @TableField("price")
    private BigDecimal price;

    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量")
    @TableField("total")
    private Integer total;

    /**
     * 是否生成 订单Y/N
     */
    @ApiModelProperty(value = "是否生成 订单Y/N")
    @TableField("create_order_flag")
    private String createOrderFlag;

    /**
     * 订单编码
     */
    @ApiModelProperty(value = "订单编码")
    @TableField("order_code")
    private String orderCode;

    /**
     * 删除标识 0/1
     */
    @ApiModelProperty(value = "删除标识 0/1")
    @TableField("del_flag")
    private Integer delFlag;

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    @TableField("add_dt")
    private Date addDt;

    /**
     * 编辑时间
     */
    @ApiModelProperty(value = "编辑时间")
    @TableField("edit_dt")
    private Date editDt;

}
