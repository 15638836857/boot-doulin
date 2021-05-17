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
* TShopToucanHdGoods Entity
* @Author: malinging
* @Date: 2021-05-14
*/
@ApiModel(value="TShopToucanHdGoods Entity", description="商家套餐指定的商品")
@Data
@TableName("t_shop_toucan_hd_goods")
public class TShopToucanHdGoods implements Serializable {


 @TableId(value = "id", type = IdType.AUTO)
 private Integer id;

 /**
  * 套餐名称
  */
 @ApiModelProperty(value = "套餐名称")
 @TableField("name")
 private String name;
 @ApiModelProperty(value = "商家编码")
 @TableField("shop_home_code")
 private String shopHomeCode;

 /**
  * 套餐一口价
  */
 @ApiModelProperty(value = "套餐一口价")
 @TableField("price")
 private BigDecimal price;

 /**
  * 套餐使用商品的数量
  */
 @ApiModelProperty(value = "套餐使用商品的数量")
 @TableField("goods_num")
 private Integer goodsNum;

 /**
  * 是否有效 Y/N
  */
 @ApiModelProperty(value = "是否有效 Y/N")
 @TableField("valid_flag")
 private String validFlag;

 /**
  * 套餐关联的商品id
  */
 @ApiModelProperty(value = "套餐关联的商品id")
 @TableField("shop_goods_id")
 private Integer shopGoodsId;
 @ApiModelProperty(value = "套餐关联的商品id")
 @TableField("shop_goods_sku_id")
 private Integer shopGoodsSkuId;

 /**
  * 删除标识  0/1
  */
 @ApiModelProperty(value = "删除标识  0/1")
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
 @ApiModelProperty(value = "活动类别   FGTC:复购套餐/  DEJNZ:第二件N折/ JJG加价购")
 @TableField("order_type")
 private String orderType;
 @ApiModelProperty(value = "第二件N折")
 @TableField("the_second_discount")
 private Double theSecondDiscount;
 @ApiModelProperty(value = "加价购 加的金额")
 @TableField("add_money")
 private BigDecimal addMoney;


 @TableField(exist = false)
 private String ids;
 /**
  * 商品信息
  */
 @TableField(exist = false)
 private TGoods goods;


}
