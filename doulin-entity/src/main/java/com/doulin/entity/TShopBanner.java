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
* TShopBanner Entity
* @Author: malinging
* @Date: 2021-05-18
*/
@ApiModel(value="TShopBanner Entity", description="店铺banner 轮播图")
@Data
@TableName("t_shop_banner")
public class TShopBanner implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 商家编号
    */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;

    /**
    * 图片url
    */
    @ApiModelProperty(value = "图片url")
    @TableField("url")
    private String url;
    /**
    * 点击量
    */
    @ApiModelProperty(value = "点击量")
    @TableField("click_count")
    private Integer clickCount;
    /**
    * 排序
    */
    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    /**
    * 0/1  删除标识
    */
    @ApiModelProperty(value = "0/1  删除标识")
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

    @TableField("add_by")
    private String addBy;
    @ApiModelProperty(value = "编辑人")
    @TableField("edit_by")
    private String editBy;

    @ApiModelProperty(value = "是否有效 Y/N")
    @TableField("status")
    private String status;
    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

}
