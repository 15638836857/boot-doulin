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
* TShopMakeMeter Entity
* @Author: malinging
* @Date: 2021-05-04
*/
@ApiModel(value="TShopMakeMeter Entity", description="商家物料设置")
@Data
@TableName("t_shop_make_meter")
public class TShopMakeMeter implements Serializable {


    /**
    * 物料id
    */
    @ApiModelProperty(value = "物料id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 收款二维码路径
    */
    @ApiModelProperty(value = "收款二维码路径")
    @TableField("qrcode")
    private String qrcode;

    /**
    * 商店编码
    */
    @ApiModelProperty(value = "商店编码")
    @TableField("shop_home_code")
    private String shopHomeCode;

    /**
    * 定制份数
    */
    @ApiModelProperty(value = "定制份数")
    @TableField("num")
    private Integer num;

    /**
    * 定制类型id 字典维护
    */
    @ApiModelProperty(value = "定制类型")
    @TableField("type")
    private String dzType;

    /**
    * wifi密码
    */
    @ApiModelProperty(value = "wifi密码")
    @TableField("wifi_password")
    private String wifiPassword;
    /**
    * wifi名称
    */
    @ApiModelProperty(value = "wifi名称")
    @TableField("wifi_name")
    private String wifiName;

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
    * 是否显示 wifi  密码  Y/N
    */
    @ApiModelProperty(value = "是否显示 wifi  密码  Y/N")
    @TableField("show_flag")
    private String showFlag;

    /**
    * 联系电话 默认为登录号
    */
    @ApiModelProperty(value = "联系电话 默认为登录号")
    @TableField("tele_phone")
    private String telePhone;
    @ApiModelProperty(value = "商云客二维码id")
    @TableField("qrcode_ids")
    private String qrcodeIds;

    @ApiModelProperty(value ="商家名称")
    @TableField(exist = false)
    private String shopHomeName;

}
