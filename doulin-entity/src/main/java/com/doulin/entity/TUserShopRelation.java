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
* TUserShopRelation Entity
* @Author: malinging
* @Date: 2021-05-17
*/
@ApiModel(value="TUserShopRelation Entity", description="用户关联的商家信息")
@Data
@TableName("t_user_shop_relation")
public class TUserShopRelation implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    /**
    * 商家编码
    */
    @ApiModelProperty(value = "商家编码")
    @TableField("shop_home_code")
    private String shopHomeCode;

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

    /**
    * 默认 关联的商家  Y/N
    */
    @ApiModelProperty(value = "默认 关联的商家  Y/N")
    @TableField("default_flag")
    private String defaultFlag;

}
