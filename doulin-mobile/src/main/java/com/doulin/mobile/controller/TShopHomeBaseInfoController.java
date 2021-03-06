package com.doulin.mobile.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

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
            "    \"companyClass\": \"公司类型 \",\n" +
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
            "    \"applyFlag\": \"申请是否通过 Y审核通过/Z审核中/N审核失败\",\n" +
            "    \"applyReturnMsg\": \"申请结果描述\",\n" +
            "    \"bankName\": \"银行名称\",\n" +
            "    \"bankChildName\": \"支行名称\",\n" +
            "    \"bankProvince\": \"银行省份\",\n" +
            "    \"bankCity\": \"银行城市\",\n" +
            "    \"shopAcceptanceLetterImg\": \"商户受理书图片  业务员上传\",\n" +
            "    \"shopSettlementBookImg\": \"结算账户指定书\",\n" +
            "    \"ashierPhoto\": \"收银台照\",\n" +
            "    \"communityName\": \"社区名称\",\n" +
            "    \"shopToUserMinMoney\": \"配送最低消费\",\n" +
            "    \"userGiveShopMoney\": \"配送费\",\n" +
            "    \"industryNo\": \"行业类别编码\",\n" +
            "    \"industryNoWeixin\": \"微信行业类别编码\",\n" +
            "    \"categoryNo\": \"经营类目\",\n" +
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
            tShopHomeBaseInfoService.updateInfoById(tsb,tsbio,SysContent.ADD);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("app/tbbf/add**********"+e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }

    }

    /**
     * 商家银行卡
     *
     * @param json
     */
    @ApiOperation(value = "商家银行卡", notes = "{\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"legalPersonBankCard\": \"银行卡卡号\",\n" +
            "    \"legalPersonBankCardL\": \"银行卡联号\",\n" +
            "    \"legalPersonBankImage\": \"银行卡图片\",\n" +
            "    \"legalPersonBankHandImage\": \"法人手持银行卡图片\",\n" +
            "    \"telePhone\": \"手机号\"\n" +
            "}")
    @PostMapping("/business/bankInfo")
    public Object bankInfo(String json) {
        try {
            Map<String,Object>  map= getRequestCk(json);
            TShopHomeBaseInfo tsb= BeanUtil.toBean(map,TShopHomeBaseInfo.class);
            TShopHomeBaseInfo shopHomeBaseInfo=tShopHomeBaseInfoService.getInfoByLoginNo(tsb.getLoginNo());
            shopHomeBaseInfo.setApplyDate(new Date());
            shopHomeBaseInfo.setEditDt(new Date());
            shopHomeBaseInfo.setLegalPersonBankCard(tsb.getLegalPersonBankCard());
            shopHomeBaseInfo.setLegalPersonBankCardL(tsb.getLegalPersonBankCardL());
            shopHomeBaseInfo.setLegalPersonBankImage(tsb.getLegalPersonBankImage());
            shopHomeBaseInfo.setLegalPersonBankHandImage(tsb.getLegalPersonBankHandImage());
            shopHomeBaseInfo.setTelePhone(tsb.getTelePhone());
            tShopHomeBaseInfoService.updateInfoById(tsb,shopHomeBaseInfo,SysContent.UPDATE);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
          log.error("/business/bankInfo*****"+e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }

    }
    /**
     *
     * @param json
     */
    @ApiOperation(value = "店铺设置", notes = "{\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"shopHomeName\": \"店铺名称\",\n" +
            "    \"shopAddress\": \"商家位置\",\n" +
            "    \"doorToDoor\": \"是否支持上门  Y/N\",\n" +
            "    \"shopOpenBusinessTime\": \"商家上班时间 如：8:00\",\n" +
            "    \"shopCloseBusinessTime\": \"商家下班时间 如: 20:00\",\n" +
            "    \"shopToUserMinMoney\": \"配送标准：如：19.9\",\n" +
            "    \"userGiveShopMoney\": \"配送费用：如：3\",\n" +
            "    \"shopGetOrderAutoFlag\": \"商家是否自动接单 Y/N\",\n" +
            "    \"orderCancelMaxtime\": \"接单后允许订单取消最大时间\",\n" +
            "    \"shopPaywaterPrefix\": \"商家流水前缀\",\n" +
            "    \"restTimeStart\": \"休息时间开始  2020-05-01 18:00\",\n" +
            "    \"restTimeEnd\": \"休息时间开始  2020-05-05 18:00\"\n" +
            "}")
    @PostMapping("/setShop")
    public Object setShop(String json) {
        try {
            Map<String,Object> map = getRequestCk(json);
            TShopHomeBaseInfo tsb= BeanUtil.toBean(map,TShopHomeBaseInfo.class);
            TShopHomeBaseInfo shopHomeBaseInfo=tShopHomeBaseInfoService.getInfoByLoginNo(tsb.getLoginNo());
            shopHomeBaseInfo.setShopHomeName(tsb.getShopHomeName());
            shopHomeBaseInfo.setEditDt(new Date());
            shopHomeBaseInfo.setShopAddress(tsb.getShopAddress());
            shopHomeBaseInfo.setDoorToDoor(tsb.getDoorToDoor());
            shopHomeBaseInfo.setShopToUserMinMoney(tsb.getShopToUserMinMoney());
            shopHomeBaseInfo.setUserGiveShopMoney(tsb.getUserGiveShopMoney());
            shopHomeBaseInfo.setShopGetOrderAutoFlag(tsb.getShopGetOrderAutoFlag());
            shopHomeBaseInfo.setShopPaywaterPrefix(tsb.getShopPaywaterPrefix());
            shopHomeBaseInfo.setShopOpenBusinessTime(tsb.getShopOpenBusinessTime());
            shopHomeBaseInfo.setShopCloseBusinessTime(tsb.getShopCloseBusinessTime());
            shopHomeBaseInfo.setRestTimeStart(tsb.getRestTimeStart());
            shopHomeBaseInfo.setRestTimeEnd(tsb.getRestTimeEnd());
            shopHomeBaseInfo.setOrderCancelMaxtime(tsb.getOrderCancelMaxtime());
            tShopHomeBaseInfoService.updateInfoById(shopHomeBaseInfo,shopHomeBaseInfo,SysContent.ADD);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("app/tbbf/setShop*****"+e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }

    /**
     * 商家编辑图片
     *
     * @param
     */
    @ApiOperation(value = "商家店内图片 编辑/删除", notes = "file:文件 添加时必传  ；loginNo：必传登录商家号    oper:add/添加del/删除 必传;  url:删除时必传图片路径")
    @PostMapping(value ="/updateInShopImg",headers = "content-type=multipart/form-data")
    public Object updateImg(@RequestParam("file") MultipartFile[] file, String loginNo,String oper,String url) {
        try {
            TShopHomeBaseInfo shopHomeBaseInfo = tShopHomeBaseInfoService.getInfoByLoginNo(loginNo);
            if (null != shopHomeBaseInfo) {
                String inDoor = shopHomeBaseInfo.getShopIndoorPhoto();
                if (SysContent.OPER_ADD.equals(oper)) {
                    List<String> fileUrl = utilService.uploadImg(file, SysContent.INTGER_1.toString());
                    if (StrUtil.isEmpty(inDoor)) {
                        inDoor = String.join(SysContent.EN_D, fileUrl);
                    } else {
                        inDoor = inDoor + SysContent.EN_D + String.join(SysContent.EN_D, fileUrl);
                    }
                } else {
                    //删除
                    if (StrUtil.isEmpty(url)) {
                        throw new Exception(SysContent.ERROR_PARAM);
                    }

                    String[] urls = inDoor.split(SysContent.EN_D);
                    List<String> lsitU = Arrays.asList(urls);
                    List<String> up=new ArrayList<>();
                    for (String s : lsitU) {
                        if(s.equals(url)) {
                            continue;
                        }
                        up.add(s);
                    }

                    String[] deleteUrl = {url};
                    utilService.deleteImag(deleteUrl);
                    inDoor = String.join(",", up);
                }
                shopHomeBaseInfo.setShopIndoorPhoto(inDoor);
                tShopHomeBaseInfoService.updateById(shopHomeBaseInfo);
                return responseAppNoMi(R.ok(SysContent.OK_OPER));
            } else {
                return responseAppNoMi(R.failed("商家异常"));
            }
        } catch (Exception e) {
            log.error("app/tbbf/updateInShopImg*****" + e.getMessage());
            return responseAppNoMi(R.failed(e.getMessage()));
        }
    }

    /**
     * 详情
     *
     * @param json
     * @return
     */
    @ApiOperation(value = "获取商家详情", notes = "{\n" +
            "    \"loginNo\": \"商家登录的手机号\"\n" +
            "}")
    @PostMapping("/detail")
    public String detail(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String loginNo = map.get(SysContent.LOGINNO_STR).toString();
            TShopHomeBaseInfo e = tShopHomeBaseInfoService.getInfoByLoginNo(loginNo);
            JSONObject jsonObject = JSONUtil.parseObj(e);
            return responseAppRes(ResJson.Ok(jsonObject));
        } catch (Exception e) {
            log.error("商家获取详情失败***" + e.getMessage());
            return responseAppRes(ResJson.Ok(e));
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