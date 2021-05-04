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
import java.util.List;

/**
* SysGoods Entity
* @Author: malinging
* @Date: 2021-04-27
*/
@ApiModel(value="SysGoods Entity", description="逗邻系统商品")
@Data
@TableName("sys_goods")
public class SysGoods implements Serializable {


    /**
    * 主键id
    */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(exist = false)
    private Integer item;

    /**
    * 系统商品名称
    */
    @ApiModelProperty(value = "系统商品名称")
    @TableField("goods_name")
    private String goodsName;

    /**
    * 商品图片
    */
    @ApiModelProperty(value = "商品图片")
    @TableField("goods_img")
    private String goodsImg;
    @ApiModelProperty(value = "商品图片")
    @TableField("category_id")
    private Integer categoryId;

    /**
    * 删除标识  0正常   1删除
    */
    @ApiModelProperty(value = "删除标识  0正常   1删除")
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
    /**
     * 商品规格
     */
    @TableField(exist = false)
    private String sku;
    /**
     * 商品价格
     */
    @TableField(exist = false)
    private String prices;
    /**
     * 商家数
     */
    @TableField(exist = false)
    private String shopCount;
    @TableField(exist = false)
    private List<SysGoodsSku> skuList;

}
