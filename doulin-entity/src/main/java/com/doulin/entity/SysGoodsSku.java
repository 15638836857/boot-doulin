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
* SysGoodsSku Entity
* @Author: malinging
* @Date: 2021-04-27
*/
@ApiModel(value="SysGoodsSku Entity", description="")
@Data
@TableName("sys_goods_sku")
public class SysGoodsSku implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 规格
    */
    @ApiModelProperty(value = "规格")
    @TableField("sku")
    private String sku;

    @TableField("prices")
    private BigDecimal prices;

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
    * 修改人
    */
    @ApiModelProperty(value = "修改人")
    @TableField("edit_by")
    private String editBy;

    /**
    * 修改时间
    */
    @ApiModelProperty(value = "修改时间")
    @TableField("edit_dt")
    private Date editDt;

    /**
    * 删除标识 0 正常  1删除
    */
    @ApiModelProperty(value = "删除标识 0 正常  1删除")
    @TableField("del_flag")
    private Integer delFlag;

    /**
    * 系统商品id
    */
    @ApiModelProperty(value = "系统商品id")
    @TableField("sys_goods_id")
    private Integer sysGoodsId;


}
