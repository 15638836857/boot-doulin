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
* TCommunity Entity
* @Author: malinging
* @Date: 2021-04-15
*/
@ApiModel(value="TCommunity Entity", description="社区表")
@Data
@TableName("t_community")
public class TCommunity implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(exist = false)
    private Integer item;
    /**
    * 社区名称
    */
    @ApiModelProperty(value = "社区名称")
    @TableField("community_name")
    private String communityName;

    /**
    * 社区编码
    */
    @ApiModelProperty(value = "社区编码")
    @TableField("community_code")
    private String communityCode;

    /**
    * 社区地址
    */
    @ApiModelProperty(value = "社区地址")
    @TableField("community_address")
    private String communityAddress;

    /**
    * 社区logo  base64字符串
    */
    @ApiModelProperty(value = "社区logo  base64字符串")
    @TableField("community_logo")
    private String communityLogo;

    /**
    * 省份
    */
    @ApiModelProperty(value = "省份")
    @TableField("province_id")
    private Integer provinceId;

    @TableField(exist = false)
    private String provinceName;

    /**
    * 城市
    */
    @ApiModelProperty(value = "城市")
    @TableField("city_id")
    private Integer cityId;

    @TableField(exist = false)
    private String cityName;

    /**
    * 县区
    */
    @ApiModelProperty(value = "县区id")
    @TableField("district_id")
    private Integer districtId;
    @TableField(exist = false)
    private String districtName;

    /**
    * 是否禁用 Y/N
    */
    @ApiModelProperty(value = "是否禁用 Y/N")
    @TableField("community_state")
    private String communityState;

    /**
    * 是否删除  0/1
    */
    @ApiModelProperty(value = "是否删除  0/1")
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
