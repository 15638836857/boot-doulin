package com.doulin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* TShopToucanHd Entity
* @Author: malinging
* @Date: 2021-05-14
*/
@ApiModel(value="TShopToucanHd Entity", description="商家套餐活动  复购套餐/第二件N折/加价购")
@Data
@TableName("t_shop_toucan_hd")
public class TShopToucanHd implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 活动名称
    */
    @ApiModelProperty(value = "活动名称")
    @TableField("name")
    private String name;

    /**
    * 商家编号
    */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;

    /**
    * 是否开启  Y/N
    */
    @ApiModelProperty(value = "是否开启  Y/N")
    @TableField("open_flag")
    private String openFlag;

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
     * 活动类别
     */
    @ApiModelProperty(value = "活动类别   FGTC:复购套餐/  DEJNZ:第二件N折/ JJG加价购")
    @TableField("order_type")
    private String  orderType;
    /**
     * 套餐 数据
     */
    @TableField(exist = false)
    List<TShopToucanHdGoods> taoCanList=new ArrayList<>();



}
