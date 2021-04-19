package com.doulin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
* ProvinceCityDistrict Entity
* @Author: malinging
* @Date: 2021-04-15
*/
@ApiModel(value="ProvinceCityDistrict Entity", description="省市县数据表")
@Data
@TableName("province_city_district")
public class ProvinceCityDistrict implements Serializable {


    /**
    * 地区代码
    */
    @ApiModelProperty(value = "地区代码")
    @TableId("id")
    private Integer id;

    /**
    * 当前地区的上一级地区代码
    */
    @ApiModelProperty(value = "当前地区的上一级地区代码")
    @TableField("pid")
    private Integer pid;

    /**
    * 地区名称
    */
    @ApiModelProperty(value = "地区名称")
    @TableField("name")
    private String name;

}
