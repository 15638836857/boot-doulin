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

/**
* TShopVipConsumerCoupon Entity
* @Author: malinging
* @Date: 2021-05-07
*/
@ApiModel(value="TShopVipConsumerCoupon Entity", description="会员消费券 满多少送多少 信息表")
@Data
@TableName("t_shop_vip_consumer_coupon")
public class TShopVipConsumerCoupon implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 规则名称
    */
    @ApiModelProperty(value = "规则名称")
    @TableField("name")
    private String name;

    /**
    * 会员权益基础资料id
    */
    @ApiModelProperty(value = "会员权益基础资料id")
    @TableField("shop_vip_base_id")
    private Integer shopVipBaseId;

    /**
    * 有效期多少天
    */
    @ApiModelProperty(value = "有效期多少天")
    @TableField("time_day")
    private Integer timeDay;

    /**
    * 消费多少钱
    */
    @ApiModelProperty(value = "消费多少钱")
    @TableField("consume_money")
    private BigDecimal consumeMoney;

    /**
    * 根据消费多少钱判断赠送的钱
    */
    @ApiModelProperty(value = "根据消费多少钱判断赠送的钱")
    @TableField("to_money_send")
    private BigDecimal toMoneySend;
    /**
    * 删除标识 0/1
    */
    @ApiModelProperty(value = "删除标识 0/1")
    @TableField("del_flag")
    private Integer delFlag;
    /**
    * 商家编号
    */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;
    /**
    * 商家编号
    */
    @ApiModelProperty(value = "是否绑定会员权益卡 Y/N")
    @TableField(exist = false)
    private String isBand;

    public String getIsBand(){
        if(null!=shopVipBaseId){
            return "Y";
        }else {
            return "N";
        }
    }

}
