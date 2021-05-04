package com.doulin.entity;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.doulin.entity.shop.ApplyFlagUtil;
import com.doulin.entity.shop.ShopApplicyStatus;
import com.doulin.entity.util.EntityDateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

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
@ToString(callSuper = true)
public class TShopHomeBaseInfo implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(exist = false)
    private Integer item;

    /**
     * 商家编号
     */
    @ApiModelProperty(value = "商家编号")
    @TableField("shop_home_code")
    private String shopHomeCode;

    @ApiModelProperty(value = "登录号  目前指定手机号")
    @TableField("login_no")
    private String loginNo;
    private String loginName;

    private String token;
    private String ryToken;            // rytoken
    private String password;
    /**
     * 合作方ID (由商云客平台分配)
     */
    @TableField("plat_id")
    private String platId;


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
    @TableField("shop_group_code")
    private String shopGroupCode;
    @TableField(exist = false)
    private String shopGroupCodeName;

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
    private String shopCloseBusinessTime;

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
     * 配送标准 多少起送
     */
    @TableField("shop_to_user_min_money")
    private BigDecimal shopToUserMinMoney;
    /**
     * 配送费用
     */
    @TableField("user_give_shop_money")
    private BigDecimal userGiveShopMoney;

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
    private String foundDt;

    /**
     * 有效期yyyymmdd-yyyymmdd
     */
    @ApiModelProperty(value = "有效期yyyymmdd-yyyymmdd")
    @TableField("period_of_validity")
    private String periodOfValidity;

    /**
     * 商户类型
     */
    @ApiModelProperty(value = "商户类型 ")
    @TableField("company_class")
    private Integer companyClass;

    /**
     * 经营范围
     */
    @ApiModelProperty(value = "经营范围")
    @TableField("business_scope")
    private String businessScope;

    /**
     * 经营类型
     */
    @ApiModelProperty(value = "经营类型")
    @TableField("business_class")
    private String businessClass;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    @TableField("tele_phone")
    private String telePhone;

    /**
     * 配
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
    @ApiModelProperty(value = "身份证正面图片")
    @TableField("legal_person_card_z")
    private String legalPersonCardZ;

    /**
     * 法人手持身份证图
     */
    @ApiModelProperty(value = "身份证图反面")
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
    @ApiModelProperty(value = "法人手持身份证图")
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
    @ApiModelProperty(value = "银行卡图片")
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
    @TableField(exist = false)
    private String ywqName;

    /**
     * 商家申请状态 字典表
     */
    @ApiModelProperty(value = "商家申请状态 字典表")
    @TableField("apply_state")
    private Integer applyState;

    /**
     * 申请是否通过 Y/N
     */
    @ApiModelProperty(value = "申请是否通过 Y/Z/N")
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
    /**
     * 银行名称
     */
    @TableField(exist = false)
    private String bankName;
    /**
     * 商户受理书图片  业务员上传
     */
    @TableField("shop_acceptance_letter_img")
    private String shopAcceptanceLetterImg;
    /**
     * 结算账户指定书
     */
    @TableField("shop_settlement_book_img")
    private String shopSettlementBookImg;
    /**
     * 收银台照
     */
    @TableField("cashier_photo")
    private String ashierPhoto;
    /**
     * 是否支持上门  Y/N
     */
    @TableField("door_to_door")
    private String doorToDoor;
    /**
     * 休息时间开始
     */
    @TableField("rest_time_start")
    private Date restTimeStart;
    /**
     * 休息时间结束
     */
    @TableField("rest_time_end")
    private Date restTimeEnd;


    /**
     * 银行支行名称
     */
    @TableField(exist = false)
    private String bankChildName;
    @TableField(exist = false)
    private String bankProvince;
    @TableField(exist = false)
    private String bankCity;
    /**
     * 社区名称
     */
    @TableField(exist = false)
    private String communityName;
    @TableField(exist = false)
    private String shopProvinceName;
    /**
     * 商家所在的城市
     */
    @ApiModelProperty(value = "商家所在的城市")
    @TableField(exist = false)
    private String shopCityName;
    /**
     * 申请时间
     */
    @TableField("apply_date")
    private Date applyDate;
    /**
     * 县区
     */
    @ApiModelProperty(value = "县区")
    @TableField(exist = false)
    private String shopDistrictName;

    @ApiModelProperty(value = "营业状态")
    @TableField(exist = false)
    private String businessStatus;

    public String getBusinessStatus() {

        if (ApplyFlagUtil.STATUS_Y.getCode().equals(applyFlag)) {

            if (null != restTimeStart && null != restTimeEnd) {
                Date date=new Date();
                boolean flag = date.after(restTimeStart);
                boolean flag2 = date.before(restTimeEnd);
                if (flag && flag2) {
                    return "休息中";
                }
            }


            String timeopen;
            String timeclose;
            if (!StrUtil.isEmpty(shopOpenBusinessTime) && !StrUtil.isEmpty(shopCloseBusinessTime)) {
                timeopen = shopOpenBusinessTime;
                timeclose = shopCloseBusinessTime;
                boolean flag = EntityDateUtil.isTimeRange(timeopen, timeclose);
                if (!flag) {
                    return "休息中";
                }
            }
            return "营业中";
        } else if (ApplyFlagUtil.STATUS_Z.getCode().equals(applyFlag)) {
            return ApplyFlagUtil.STATUS_Z.getName();
        } else {
            return ShopApplicyStatus.getNameByCode(applyState);
        }
    }

}
