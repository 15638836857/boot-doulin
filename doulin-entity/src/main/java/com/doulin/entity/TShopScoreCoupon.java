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
* TShopScoreCoupon Entity
* @Author: malinging
* @Date: 2021-05-13
*/
@ApiModel(value="TShopScoreCoupon Entity", description="积分兑换优惠券")
@Data
@TableName("t_shop_score_coupon")
public class TShopScoreCoupon implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 商家编号
    */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;

    /**
    * 优惠券名称
    */
    @ApiModelProperty(value = "优惠券名称")
    @TableField("name")
    private String name;

    /**
    * 优惠券金额
    */
    @ApiModelProperty(value = "优惠券金额")
    @TableField("coupon_amount")
    private BigDecimal couponAmount;

    /**
    * 使用门槛 多少积分
    */
    @ApiModelProperty(value = "使用门槛 多少积分")
    @TableField("demand_score")
    private Integer demandScore;

    /**
    * 兑换积分
    */
    @ApiModelProperty(value = "兑换积分")
    @TableField("to_score")
    private Integer toScore;

    /**
    * 删除标识  0/1
    */
    @ApiModelProperty(value = "删除标识  0/1")
    @TableField("del_flag")
    private Integer delFlag;

    /**
    * 是否生效  Y/N
    */
    @ApiModelProperty(value = "是否生效  Y/N")
    @TableField("valid_flag")
    private String validFlag;

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
