package com.doulin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TOrderAfterDetail Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "TOrderAfterDetail Entity", description = "订单详情表")
@Data
@TableName("t_order_after_detail")
public class TOrderAfterDetail implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    @TableField("order_id")
    private Long orderId;

    /**
     * 售后处理 类型  来源字典value
     */
    @ApiModelProperty(value = "售后处理 类型  来源字典value")
    @TableField("type")
    private Integer type;

    /**
     * 客户id
     */
    @ApiModelProperty(value = "客户id")
    @TableField("user_id")
    private Long userId;

    /**
     * 售后处理描述
     */
    @ApiModelProperty(value = "售后处理描述")
    @TableField("oder_remark")
    private String oderRemark;

    /**
     * 上传凭证 图片url,  多个使用逗号间隔
     */
    @ApiModelProperty(value = "上传凭证 图片url,  多个使用逗号间隔")
    @TableField("image")
    private String image;

    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    @TableField("state")
    private Integer state;

    /**
     * 退回金额
     */
    @ApiModelProperty(value = "退回金额")
    @TableField("rt_parice")
    private BigDecimal rtParice;

    /**
     * 退回时间
     */
    @ApiModelProperty(value = "退回时间")
    @TableField("rt_time")
    private Date rtTime;

    /**
     * 删除 0/1
     */
    @ApiModelProperty(value = "删除 0/1")
    @TableField("del_flag")
    private Integer delFlag;

    @TableField("add_dt")
    private Date addDt;

    @TableField("edit_dt")
    private Date editDt;

    @TableField("edit_by")
    private String editBy;

}
