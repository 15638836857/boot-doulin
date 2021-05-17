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
* TShopScoreSetting Entity
* @Author: malinging
* @Date: 2021-05-13
*/
@ApiModel(value="TShopScoreSetting Entity", description="商家设置积分活动规则")
@Data
@TableName("t_shop_score_setting")
public class TShopScoreSetting implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 规则名称
    */
    @ApiModelProperty(value = "规则名称")
    @TableField("name")
    private String name;

    /**
    * 是否开启  Y/N
    */
    @ApiModelProperty(value = "是否开启  Y/N")
    @TableField("open_flag")
    private String openFlag;

    /**
    * 商家编号
    */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;

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
    * 积分规则  多少钱送一个积分
    */
    @ApiModelProperty(value = "积分规则  多少钱送一个积分")
    @TableField("money_to_one_score")
    private BigDecimal moneyToOneScore;
    /**
    * 编辑时间
    */
    @ApiModelProperty(value = "商家积分兑换规则")
    @TableField(exist = false)
    private List<TShopScoreCoupon> scoreCouponList=new ArrayList<>();
    @ApiModelProperty(value = "商家积分兑换规则ids")
    @TableField(exist = false)
    private String ids;



}
