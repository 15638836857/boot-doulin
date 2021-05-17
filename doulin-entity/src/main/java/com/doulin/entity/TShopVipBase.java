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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* TShopVipBase Entity
* @Author: malinging
* @Date: 2021-05-07
*/
@ApiModel(value="TShopVipBase Entity", description="商家给vip用户的权益基础信息表")
@Data
@TableName("t_shop_vip_base")
public class TShopVipBase implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 会员权益类型 1/积分翻倍  2/每月领券  3/储值多送 4/订单打折 5/配送打折 6/商品会员价
    */
    @ApiModelProperty(value = "会员权益类型 1/积分翻倍  2/每月领券  3/储值多送 4/订单打折 5/配送打折 6/商品会员价")
    @TableField("vip_type")
    private String vipType;

    /**
    * 商家编号
    */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;
    /**
    * 规则名称
    */
    @ApiModelProperty(value = "规则名称")
    @TableField("name")
    private String name;

    /**
    * 订单打折
    */
    @ApiModelProperty(value = "订单打折")
    @TableField("order_discount")
    private BigDecimal orderDiscount;

    /**
    * 配送打折
    */
    @ApiModelProperty(value = "配送打折")
    @TableField("to_send_discount")
    private BigDecimal toSendDiscount;

    /**
    * 积分翻倍
    */
    @ApiModelProperty(value = "积分翻倍")
    @TableField("score_times")
    private Integer scoreTimes;

    /**
    * 全场折扣
    */
    @ApiModelProperty(value = "全场折扣")
    @TableField("all_discount")
    private BigDecimal allDiscount;

    /**
    *
    */
    @ApiModelProperty(value = "全场是否折扣")
    @TableField("all_flag")
    private String  allFlag;

    /**
    * 会员计费类型  1/免费领取  2/月收费  3/季收费 4/年收费  5/月季年收费
    */
    @ApiModelProperty(value = "会员计费类型  1/免费领取  2/月收费  3/季收费 4/年收费  5/月季年收费")
    @TableField("vip_money_type")
    private String vipMoneyType;

    /**
    * 按月收费
    */
    @ApiModelProperty(value = "按月收费")
    @TableField("vip_month_money")
    private BigDecimal vipMonthMoney;

    /**
    * 按季收费
    */
    @ApiModelProperty(value = "按季收费")
    @TableField("vip_season_money")
    private BigDecimal vipSeasonMoney;

    /**
    * 按年收费
    */
    @ApiModelProperty(value = "按年收费")
    @TableField("vip_year_money")
    private BigDecimal vipYearMoney;

    /**
    * 添加时间
    */
    @ApiModelProperty(value = "添加时间")
    @TableField("add_dt")
    private Date addDt;

    /**
    * 添加人
    */
    @ApiModelProperty(value = "添加人")
    @TableField("add_by")
    private String addBy;

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
    * 是否开启 Y/N
    */
    @ApiModelProperty(value = "是否开启 Y/N")
    @TableField("open_flag")
    private String openFlag;

    @ApiModelProperty(value = "充值列表")
    @TableField(exist = false)
    private List<TShopVipRecharge> vipRecharges=new ArrayList<TShopVipRecharge>();
    /**
     * 绑定权益 充值列表ids
     */
    @TableField(exist = false)
    private String vipRechargeIds;
    @ApiModelProperty(value = "会员消费券")
    @TableField(exist = false)
    private List<TShopVipConsumerCoupon> vipConsumerCoupons=new ArrayList<TShopVipConsumerCoupon>();
    /**
     *  绑定权益 会员消费券列表ids
     */
    @TableField(exist = false)
    private String vipConsumerCouponIds;
}
