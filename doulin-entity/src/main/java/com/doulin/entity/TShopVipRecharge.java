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
* TShopVipRecharge Entity
* @Author: malinging
* @Date: 2021-05-07
*/
@ApiModel(value="TShopVipRecharge Entity", description="充值")
@Data
@TableName("t_shop_vip_recharge")
public class TShopVipRecharge implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 规则名称
    */
    @ApiModelProperty(value = "规则名称")
    @TableField("name")
    private String name;

   @ApiModelProperty(value = "送多少钱")
    @TableField("to_money")
    private BigDecimal toMoney;

    /**
    * 充值多少
    */
    @ApiModelProperty(value = "充值多少")
    @TableField("recharge_money")
    private BigDecimal rechargeMoney;

    /**
    * 会员权益id
    */
    @ApiModelProperty(value = "会员权益id")
    @TableField("shop_vip_base_id")
    private Integer shopVipBaseId;
    /**
     *  活动是否开启 Y/N
     */
    @ApiModelProperty(value = "活动是否开启 Y/N")
    @TableField("open_flag")
    private String openFlag;

    @ApiModelProperty(value = "活动是否开启后是否生效 Y/N")
    @TableField("valid_flag")
    private String validFlag;

    @ApiModelProperty(value = "是vip还是普通会员使用  Y/vip  N/普通会员 ")
    @TableField("vip_flag")
    private String vipFlag;

    @ApiModelProperty(value = "店铺编码")
    @TableField("shop_home_code")
    private String shopHomeCode;
    @ApiModelProperty(value = "删除标识  0正常  1删除")
    @TableField("del_flag")
    private Integer delFlag;
    @ApiModelProperty(value = "修改标识 ids")
    @TableField(exist = false)
    private String ids;
    @TableField("vip_to_money")
    private BigDecimal vipToMoney;






}
