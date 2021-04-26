package com.doulin.mobile.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.common.ResJson;
import com.doulin.entity.vo.VQuery;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.TShopHomeBaseInfoService;
import com.doulin.service.UtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * TShopHomeBaseInfoController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "商家基本信息控制器类")
@CrossOrigin
@RestController
@RequestMapping("app/tbbf")
@Slf4j
public class TShopHomeBaseInfoController  extends BaseAppController {

    @Autowired
    private TShopHomeBaseInfoService tShopHomeBaseInfoService;
    @Autowired
    private UtilService utilService;

    /**
     * 新增
     *
     * @param json
     */
    @ApiOperation(value = "入驻", notes = "{\n" +
            "    \"loginNo\": \"登录人 手机号必传\",\n" +
            "    \"loginName\": \"登录人 名称\",\n" +
            "    \"shopHomeName\": \"商家名称\",\n" +
            "    \"shopGroupCode\": \"商家分类编码\",\n" +
            "    \"shopGroupCodeName\": \"商家分类编码名称\",\n" +
            "    \"shopUserId\": \"商家和用户关联id\",\n" +
            "    \"communityCode\": \"社区编码\",\n" +
            "    \"shopProvinceId\": \"省份Id\",\n" +
            "    \"shopCityId\": \"商家所在的城市\",\n" +
            "    \"shopDistrictId\": \"县区\",\n" +
            "    \"shopAddress\": \"商家详细地址\",\n" +
            "    \"shopFlag\": \"商家营业状态 Y/正常营业   N/暂停营业    T/整顿中\",\n" +
            "    \"shopOpenBusinessTime\": \"商家上班时间 如：8:00\",\n" +
            "    \"shopCloseBusinessTime\": \"商家下班时间 如: 20:00\",\n" +
            "    \"shopBalance\": \"商家余额\",\n" +
            "    \"shopTitleImage\": \"店面门头照片 \",\n" +
            "    \"shopLogo\": \"商家店面Logo\",\n" +
            "    \"shopIndoorPhoto\": \"店铺内部环境照 多个路劲 使用英文逗号间隔\",\n" +
            "    \"shopGetOrderAutoFlag\": \"商家是否自动接单 Y/N\",\n" +
            "    \"shopPaywaterPrefix\": \"商家流水前缀\",\n" +
            "    \"orderCancelTimeUnit\": \"接单后允许订单取消最大时间单位\",\n" +
            "    \"orderCancelMaxtime\": \"接单后允许订单取消最大时间\",\n" +
            "    \"businessLicenseImage\": \"营业执照 base64字串\",\n" +
            "    \"socialCreditCode\": \"社会信用代码\",\n" +
            "    \"companyName\": \"公司单位名称\",\n" +
            "    \"foundDt\": \"创办成立时间\",\n" +
            "    \"periodOfValidity\": \"有效期yyyymmdd-yyyymmdd\",\n" +
            "    \"companyClass\": \"公司类型 字典表\",\n" +
            "    \"businessScope\": \"经营范围\",\n" +
            "    \"businessClass\": \"经营类型\",\n" +
            "    \"telePhone\": \"联系方式\",\n" +
            "    \"companyEmail\": \"公司邮箱\",\n" +
            "    \"legalPersonCardName\": \"法人身份证上名字\",\n" +
            "    \"legalPersonCardNum\": \"法人身份证号\",\n" +
            "    \"legalPersonCardTime\": \"法人身份证有效期\",\n" +
            "    \"legalPersonCardZ\": \"身份证正面图\",\n" +
            "    \"legalPersonCardF\": \"身份证反面图\",\n" +
            "    \"legalPersonBankCard\": \"银行卡号\",\n" +
            "    \"legalPersonCardP\": \"法人手持身份证图 \",\n" +
            "    \"legalPersonBankCardL\": \"银行卡联号\",\n" +
            "    \"legalPersonBankImage\": \"银行卡图片\",\n" +
            "    \"legalPersonBankHandImage\": \"法人手持银行卡图片\",\n" +
            "    \"ywqCode\": \"平台业务员编码\",\n" +
            "    \"applyState\": \"商家申请状态 设置完密码商家入驻状态 0:未入驻、 1:已填写基本资料 2:待业务上门开店、3:待支付三方审核 4:开户失败需更改资料 5：成功入驻  ，6：未注册\",\n" +
            "    \"applyFlag\": \"申请是否通过 Y/N\",\n" +
            "    \"applyReturnMsg\": \"申请结果描述\",\n" +
            "    \"bankName\": \"银行名称\",\n" +
            "    \"bankChildName\": \"支行名称\",\n" +
            "    \"bankProvince\": \"银行省份\",\n" +
            "    \"bankCity\": \"银行城市\",\n" +
            "    \"shopAcceptanceLetterImg\": \"商户受理书图片  业务员上传\",\n" +
            "    \"shopSettlementBookImg\": \"结算账户指定书\",\n" +
            "    \"ashierPhoto\": \"收银台照\",\n" +
            "    \"communityName\": \"社区名称\",\n" +
            "    \"shopHomeCode\": \"商家 后台生成的编码\"\n" +
            "}")
    @PostMapping("/add")
    public String add(String json) {
        try {
            Map<String,Object>  map=getRequestCk(json);
            TShopHomeBaseInfo tsb= BeanUtil.toBean(map,TShopHomeBaseInfo.class);
            TShopHomeBaseInfo tsbio=tShopHomeBaseInfoService.getInfoByLoginNo(tsb.getLoginNo());
            if(null==tsbio){
               return responseAppRes(ResJson.error(SysContent.ERROR_PHONE));
            }
            //验证业务码是否有效
            if(!StrUtil.isEmpty(tsb.getYwqCode())){
                ResJson resJson=utilService.getYwyByCode(tsb.getYwqCode());
                if(SysContent.INTGER_1.toString().equals(resJson.getResult())){
                    throw new Exception(resJson.getResultNote());
                }
            }
            tsb.setDelFlag(SysContent.INTGER_0);
            tsb.setEditDt(new Date());
            tsb.setId(tsbio.getId());
            tShopHomeBaseInfoService.updateInfoById(tsb);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("app/tbbf/add**********"+e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }

    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tShopHomeBaseInfoService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tShopHomeBaseInfo
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TShopHomeBaseInfo tShopHomeBaseInfo) {
        tShopHomeBaseInfoService.updateById(tShopHomeBaseInfo);
    }

    /**
     * 详情
     *
     * @param json
     * @return
     */
    @ApiOperation(value = "detail", notes = "{\n" +
            "    \"loginNo\": \"商家登录的手机号\"\n" +
            "}")
    @PostMapping("/detail")
    public String detail(String json) {
        try {
            Map<String,Object>  map=getRequestCk(json);
            String loginNo=map.get(SysContent.LOGINNO_STR).toString();
            TShopHomeBaseInfo e=  tShopHomeBaseInfoService.getInfoByLoginNo(loginNo);
         return   responseAppRes( ResJson.Ok(e));
        } catch (Exception e) {
            log.error("商家获取详情失败***"+e.getMessage());
            return   responseAppRes( ResJson.Ok(e));
        }
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TShopHomeBaseInfo> userList(@RequestBody(required = false) VQuery query) {
        return tShopHomeBaseInfoService.page(query);
    }

}