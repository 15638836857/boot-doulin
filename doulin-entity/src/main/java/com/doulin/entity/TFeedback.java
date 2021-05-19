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
* TFeedback Entity
* @Author: malinging
* @Date: 2021-05-19
*/
@ApiModel(value="TFeedback Entity", description="意见反馈")
@Data
@TableName("t_feedback")
public class TFeedback implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 用户ID
    */
    @ApiModelProperty(value = "用户ID")
    @TableField("uid")
    private Integer uid;

    /**
    * 用户昵称
    */
    @ApiModelProperty(value = "用户昵称")
    @TableField("nickname")
    private String nickname;

    /**
    * 用户电话
    */
    @ApiModelProperty(value = "用户电话")
    @TableField("phone")
    private String phone;

    /**
    * 反馈内容
    */
    @ApiModelProperty(value = "反馈内容")
    @TableField("content")
    private String content;

    /**
    * 图1
    */
    @ApiModelProperty(value = "图1")
    @TableField("img1")
    private String img1;

    /**
    * 图2
    */
    @ApiModelProperty(value = "图2")
    @TableField("img2")
    private String img2;

    /**
    * 图3
    */
    @ApiModelProperty(value = "图3")
    @TableField("img3")
    private String img3;

    /**
    * 图4
    */
    @ApiModelProperty(value = "图4")
    @TableField("img4")
    private String img4;

    /**
    * 0 用户端 1商家端
    */
    @ApiModelProperty(value = "0 用户端 1商家端")
    @TableField("type")
    private String type;

    /**
    * 反馈日期
    */
    @ApiModelProperty(value = "反馈日期")
    @TableField("adtime")
    private Date adtime;

}
