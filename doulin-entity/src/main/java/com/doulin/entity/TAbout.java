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
* TAbout Entity
* @Author: malinging
* @Date: 2021-04-23
*/
@ApiModel(value="TAbout Entity", description="关于我们")
@Data
@TableName("t_about")
public class TAbout implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 类型
    */
    @ApiModelProperty(value = "类型")
    @TableField("type")
    private String type;

    /**
    * 内容
    */
    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    /**
    * URL
    */
    @ApiModelProperty(value = "URL")
    @TableField("url")
    private String url;

    /**
    * 时间
    */
    @ApiModelProperty(value = "时间")
    @TableField("adtime")
    private Date adtime;

    /**
    * 状态 0 正常   1禁用
    */
    @ApiModelProperty(value = "状态")
    @TableField("status")
    private String status;

}
