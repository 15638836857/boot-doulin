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
* TShopOrderCoupon Entity
* @Author: malinging
* @Date: 2021-05-13
*/
@ApiModel(value="TShopOrderCoupon Entity", description="商家订单消费券/订单返券/新人进店领券/进店领券/满减活动")
@Data
@TableName("t_shop_order_coupon")
public class TShopOrderCoupon implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 优惠券名称
    */
    @ApiModelProperty(value = "优惠券名称")
    @TableField("name")
    private String name;

    /**
    * 返券门槛
    */
    @ApiModelProperty(value = "返券门槛")
    @TableField("order_to_money")
    private BigDecimal orderToMoney;

    /**
    * 优惠金额
    */
    @ApiModelProperty(value = "优惠金额/满减活动消费满多少金额减多少金额")
    @TableField("to_money_send")
    private BigDecimal toMoneySend;

    /**
    * 使用门槛
    */
    @ApiModelProperty(value = "使用门槛/满减活动消费满多少金额")
    @TableField("consume_money")
    private BigDecimal consumeMoney;

    /**
    * 有效期多少天
    */
    @ApiModelProperty(value = "有效期多少天")
    @TableField("time_day")
    private Integer timeDay;

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

    /**
    * 商家编号
    */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;
    /**
    * DDFQ/订单返券,XNJDLQ/新人进店领券，JDLQ/进店领券
    */
    @ApiModelProperty(value = "DDFQ/订单返券,XNJDLQ/新人进店领券，JDLQ/进店领券 ，MJHD/满减活动")
    @TableField("order_type")
    private String orderType;
    /**
     * 是否生效  Y/N
     */
    @ApiModelProperty(value = "是否生效  Y/N")
    @TableField("valid_flag")
    private String validFlag;
    /**
     * 是否开启  Y/N
     */
    @ApiModelProperty(value = "是否开启  Y/N")
    @TableField("open_flag")
    private String openFlag;





    @ApiModelProperty(value = "设置有效ids")
    @TableField(exist = false)
    private String ids;


}
