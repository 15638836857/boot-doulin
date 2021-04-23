package com.doulin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
* TBankInfo Entity
* @Author: malinging
* @Date: 2021-04-22
*/
@ApiModel(value="TBankInfo Entity", description="")
@Data
@TableName("t_bank_info")
public class TBankInfo implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 银联号
    */
    @ApiModelProperty(value = "银联号")
    @TableField("bank_num")
    private String bankNum;

    /**
    * 银行名称
    */
    @ApiModelProperty(value = "银行名称")
    @TableField("bank_name")
    private String bankName;

    /**
    * 银行支行
    */
    @ApiModelProperty(value = "银行支行")
    @TableField("bank_child")
    private String bankChild;

    /**
    * 城市
    */
    @ApiModelProperty(value = "城市")
    @TableField("city")
    private String city;

    @TableField("province")
    private String province;

}
