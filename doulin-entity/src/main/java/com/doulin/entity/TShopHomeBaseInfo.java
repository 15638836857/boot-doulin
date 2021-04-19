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
 * TShopHomeBaseInfo Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "TShopHomeBaseInfo Entity", description = "商家基本信息表")
@Data
@TableName("t_shop_home_base_info")
public class TShopHomeBaseInfo implements Serializable {


    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 商家编号
     */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;

    @ApiModelProperty(value = "登录号  目前指定手机号")
    @TableField("login_no")
    private String loginNo;

    private String token;
    private String ryToken;			// rytoken
    private String password;


    /**
     * 商家名称
     */
    @ApiModelProperty(value = "商家名称")
    @TableField("shop_home_name")
    private String shopHomeName;

    /**
     * 商家分类编码
     */
    @ApiModelProperty(value = "商家分类编码")
    @TableField("shop_grop_code")
    private String shopGropCode;

    /**
     * 商家和用户关联id
     */
    @ApiModelProperty(value = "商家和用户关联id")
    @TableField("shop_user_id")
    private Integer shopUserId;

    /**
     * 社区编码
     */
    @ApiModelProperty(value = "社区编码")
    @TableField("community_code")
    private String communityCode;

    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    @TableField("shop_province_id")
    private Integer shopProvinceId;

    /**
     * 商家所在的城市
     */
    @ApiModelProperty(value = "商家所在的城市")
    @TableField("shop_city_id")
    private String shopCityId;

    /**
     * 县区
     */
    @ApiModelProperty(value = "县区")
    @TableField("shop_district_id")
    private String shopDistrictId;

    /**
     * 商家详细地址
     */
    @ApiModelProperty(value = "商家详细地址")
    @TableField("shop_address")
    private String shopAddress;

    /**
     * 商家营业状态
     */
    @ApiModelProperty(value = "商家营业状态")
    @TableField("shop_flag")
    private String shopFlag;

    /**
     * 商家上班时间
     */
    @ApiModelProperty(value = "商家上班时间")
    @TableField("shop_open_business_time")
    private String shopOpenBusinessTime;

    /**
     * 商家下班时间
     */
    @ApiModelProperty(value = "商家下班时间")
    @TableField("shop_close_business_time")
    private String  shopCloseBusinessTime;

    /**
     * 商家余额
     */
    @ApiModelProperty(value = "商家余额")
    @TableField("shop_balance")
    private BigDecimal shopBalance;

    /**
     * 店面门头照片
     */
    @ApiModelProperty(value = "店面门头照片")
    @TableField("shop_title_image")
    private String shopTitleImage;

    /**
     * 商家店面logo
     */
    @ApiModelProperty(value = "商家店面logo")
    @TableField("shop_logo")
    private String shopLogo;

    /**
     * 店铺内部照 多个路劲 使用英文逗号间隔
     */
    @ApiModelProperty(value = "店铺内部照 多个路劲 使用英文逗号间隔")
    @TableField("shop_indoor_photo")
    private String shopIndoorPhoto;

    /**
     * 商家店铺二维码存base64字符串
     */
    @ApiModelProperty(value = "商家店铺二维码存base64字符串")
    @TableField("shop_qrcode")
    private String shopQrcode;

    /**
     * 商家是否自动接单 Y/N
     */
    @ApiModelProperty(value = "商家是否自动接单 Y/N")
    @TableField("shop_get_order_auto_flag")
    private String shopGetOrderAutoFlag;

    /**
     * 商家流水前缀
     */
    @ApiModelProperty(value = "商家流水前缀")
    @TableField("shop_paywater_prefix")
    private String shopPaywaterPrefix;

    /**
     * 接单后允许订单取消最大时间单位
     */
    @ApiModelProperty(value = "接单后允许订单取消最大时间单位")
    @TableField("order_cancel_time_unit")
    private String orderCancelTimeUnit;

    /**
     * 接单后允许订单取消最大时间
     */
    @ApiModelProperty(value = "接单后允许订单取消最大时间")
    @TableField("order_cancel_maxtime")
    private Integer orderCancelMaxtime;

    /**
     * 营业执照
     */
    @ApiModelProperty(value = "营业执照")
    @TableField("business_license_image")
    private String businessLicenseImage;

    /**
     * 社会信用代码
     */
    @ApiModelProperty(value = "社会信用代码")
    @TableField("social_credit_code")
    private String socialCreditCode;

    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    @TableField("company_name")
    private String companyName;

    /**
     * 创办成立时间
     */
    @ApiModelProperty(value = "创办成立时间")
    @TableField("found_dt")
    private Date foundDt;

    /**
     * 有效期yyyymmdd-yyyymmdd
     */
    @ApiModelProperty(value = "有效期yyyymmdd-yyyymmdd")
    @TableField("period_of_validity")
    private String periodOfValidity;

    /**
     * 商户类型 字典表
     */
    @ApiModelProperty(value = "商户类型 字典表")
    @TableField("company_class")
    private Integer companyClass;

    /**
     * 经营范围
     */
    @ApiModelProperty(value = "经营范围")
    @TableField("business_scope")
    private String businessScope;

    /**
     * 经营类型 字典表
     */
    @ApiModelProperty(value = "经营类型 字典表")
    @TableField("business_class")
    private Integer businessClass;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    @TableField("tele_phone")
    private String telePhone;

    /**
     * 公司邮箱
     */
    @ApiModelProperty(value = "公司邮箱")
    @TableField("company_email")
    private String companyEmail;

    /**
     * 法人身份证名称
     */
    @ApiModelProperty(value = "法人身份证名称")
    @TableField("legal_person_card_name")
    private String legalPersonCardName;

    /**
     * 法人身份证号
     */
    @ApiModelProperty(value = "法人身份证号")
    @TableField("legal_person_card_num")
    private String legalPersonCardNum;

    /**
     * 法人身份证有效期
     */
    @ApiModelProperty(value = "法人身份证有效期")
    @TableField("legal_person_card_time")
    private String legalPersonCardTime;

    /**
     * 身份证正面图片base64字符串
     */
    @ApiModelProperty(value = "身份证正面图片base64字符串")
    @TableField("legal_person_card_z")
    private String legalPersonCardZ;

    /**
     * 法人手持身份证图
     */
    @ApiModelProperty(value = "法人手持身份证图")
    @TableField("legal_person_card_f")
    private String legalPersonCardF;

    /**
     * 银行卡号
     */
    @ApiModelProperty(value = "银行卡号")
    @TableField("legal_person_bank_card")
    private String legalPersonBankCard;

    /**
     * 法人手持身份证图 base64 字符串
     */
    @ApiModelProperty(value = "法人手持身份证图 base64 字符串")
    @TableField("legal_person_card_p")
    private String legalPersonCardP;

    /**
     * 银行卡联号
     */
    @ApiModelProperty(value = "银行卡联号")
    @TableField("legal_person_bank_card_l")
    private String legalPersonBankCardL;

    /**
     * 银行卡图片存base64图片
     */
    @ApiModelProperty(value = "银行卡图片存base64图片")
    @TableField("legal_person_bank_image")
    private String legalPersonBankImage;

    /**
     * 法人手持银行卡图片存base64字符串
     */
    @ApiModelProperty(value = "法人手持银行卡图片存base64字符串")
    @TableField("legal_person_bank_hand_image")
    private String legalPersonBankHandImage;

    /**
     * 平台业务员编码
     */
    @ApiModelProperty(value = "平台业务员编码")
    @TableField("ywq_code")
    private String ywqCode;

    /**
     * 商家申请状态 字典表
     */
    @ApiModelProperty(value = "商家申请状态 字典表")
    @TableField("apply_state")
    private Integer applyState;

    /**
     * 申请是否通过 Y/N
     */
    @ApiModelProperty(value = "申请是否通过 Y/N")
    @TableField("apply_flag")
    private String applyFlag;

    /**
     * 申请结果描述
     */
    @ApiModelProperty(value = "申请结果描述")
    @TableField("apply_return_msg")
    private String applyReturnMsg;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @TableField("add_by")
    private String addBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
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

    /**
     * 删除标识  0、正常  1、删除
     */
    @ApiModelProperty(value = "删除标识  0、正常  1、删除")
    @TableField("del_flag")
    private Integer delFlag;
    /**
     * 有效状态 0/有效  1/无效
     */
    private Integer status;

}
