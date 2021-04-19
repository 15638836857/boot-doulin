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
* TCommunnityToken Entity
* @Author: malinging
* @Date: 2021-04-19
*/
@ApiModel(value="TCommunnityToken Entity", description="")
@Data
@TableName("t_communnity_token")
public class TCommunnityToken implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField("token")
    private String token;

    @TableField("shop_id")
    private Integer shopId;

    @TableField("adtime")
    private Date adtime;

    /**
    * 删除标记
    */
    @ApiModelProperty(value = "删除标记")
    @TableField("del_flag")
    private String delFlag;

}
