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
 * TOrder Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "TOrder Entity", description = "订单表")
@Data
@TableName("t_order")
public class TOrder implements Serializable {


    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    @TableField("order_code")
    private String orderCode;

    @TableField("order_money")
    private BigDecimal orderMoney;

    /**
     * 订单类型 来源于 字典
     */
    @ApiModelProperty(value = "订单类型 来源于 字典")
    @TableField("order_type")
    private Integer orderType;

    /**
     * 用户订单状态 来源于字典
     */
    @ApiModelProperty(value = "用户订单状态 来源于字典")
    @TableField("order_user_state")
    private Integer orderUserState;

    /**
     * 商家订单状态
     */
    @ApiModelProperty(value = "商家订单状态")
    @TableField("order_shop_state")
    private Integer orderShopState;

    /**
     * 订单用户备注
     */
    @ApiModelProperty(value = "订单用户备注")
    @TableField("order_user_remark")
    private String orderUserRemark;

    /**
     * 商家编号
     */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;

    /**
     * 支付方式 来源于字典
     */
    @ApiModelProperty(value = "支付方式 来源于字典")
    @TableField("order_pay_type")
    private Integer orderPayType;

    /**
     * 配送费用
     */
    @ApiModelProperty(value = "配送费用")
    @TableField("to_user_home_money")
    private BigDecimal toUserHomeMoney;

    /**
     * 配送方式 来源于字典
     */
    @ApiModelProperty(value = "配送方式 来源于字典")
    @TableField("to_user_home_type")
    private Integer toUserHomeType;

    /**
     * 用户订单字符二维码  base64 字符串
     */
    @ApiModelProperty(value = "用户订单字符二维码  base64 字符串")
    @TableField("order_pay_qrcode")
    private String orderPayQrcode;

    /**
     * 支付流水号
     */
    @ApiModelProperty(value = "支付流水号")
    @TableField("order_warter_no")
    private String orderWarterNo;

    /**
     * 查看订单详情二维码
     */
    @ApiModelProperty(value = "查看订单详情二维码")
    @TableField("order_qrcode")
    private String orderQrcode;

    /**
     * 商家是否接单  Y/N
     */
    @ApiModelProperty(value = "商家是否接单  Y/N")
    @TableField("shop_git_order_flag")
    private String shopGitOrderFlag;

    /**
     * 商家接单时间
     */
    @ApiModelProperty(value = "商家接单时间")
    @TableField("shop_git_order_time")
    private Date shopGitOrderTime;

    /**
     * 订单取消类型 来源于字典
     */
    @ApiModelProperty(value = "订单取消类型 来源于字典")
    @TableField("order_cancel_type_id")
    private Integer orderCancelTypeId;

    /**
     * 取消原因 来源于字典value
     */
    @ApiModelProperty(value = "取消原因 来源于字典value")
    @TableField("order_cancel_cause_id")
    private Integer orderCancelCauseId;

    /**
     * 取消描述
     */
    @ApiModelProperty(value = "取消描述")
    @TableField("order_cancel_remark")
    private String orderCancelRemark;

    /**
     * 商家是否同意 退款 Y/N
     */
    @ApiModelProperty(value = "商家是否同意 退款 Y/N")
    @TableField("shop_refund_flag")
    private String shopRefundFlag;

    /**
     * 商家是否同意取消
     */
    @ApiModelProperty(value = "商家是否同意取消")
    @TableField("shop_agree_cancel")
    private String shopAgreeCancel;

    /**
     * 订单取消申请是否提交 Y/N
     */
    @ApiModelProperty(value = "订单取消申请是否提交 Y/N")
    @TableField("order_cancelapply_flag")
    private String orderCancelapplyFlag;

    /**
     * 用户是否申请售后 Y/N
     */
    @ApiModelProperty(value = "用户是否申请售后 Y/N")
    @TableField("order_aftersale_apply_flag")
    private String orderAftersaleApplyFlag;

    /**
     * 用户售后申请次数
     */
    @ApiModelProperty(value = "用户售后申请次数")
    @TableField("order_aftersale_apply_count")
    private Integer orderAftersaleApplyCount;

    /**
     * 最后一次申请售后的时间
     */
    @ApiModelProperty(value = "最后一次申请售后的时间")
    @TableField("order_aftersale_apply_last_time")
    private Date orderAftersaleApplyLastTime;

    /**
     * 删除标识 0/1
     */
    @ApiModelProperty(value = "删除标识 0/1")
    @TableField("del_flag")
    private Integer delFlag;

    @TableField("add_time")
    private Date addTime;

    @TableField("edit_time")
    private Date editTime;

    @TableField("edit_by")
    private String editBy;

}
