package com.doulin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* SysGoodsShopHome Entity
* @Author: malinging
* @Date: 2021-04-27
*/
@ApiModel(value="SysGoodsShopHome Entity", description="系统商品和商家关联的表")
@Data
@TableName("sys_goods_shop_home")
public class SysGoodsShopHome implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 商家编号
    */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;

    /**
    * 系统商品id
    */
    @ApiModelProperty(value = "系统商品id")
    @TableField("sys_goods_id")
    private Integer sysGoodsId;

    /**
    * 0正常  1禁用
    */
    @ApiModelProperty(value = "0正常  1禁用")
    @TableField("del_flag")
    private Integer delFlag;

    /**
    * 添加人
    */
    @ApiModelProperty(value = "添加人")
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

    /**
    * 编辑时间
    */
    @ApiModelProperty(value = "编辑时间")
    @TableField("edit_dt")
    private Date editDt;

}
