package com.doulin.mobile.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.vo.VQuery;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.TShopHomeBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * TShopHomeBaseInfoController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "商家基本信息控制器类")
@RestController
@RequestMapping("app/tbbf")
public class TShopHomeBaseInfoController  extends BaseAppController {

    @Autowired
    private TShopHomeBaseInfoService tShopHomeBaseInfoService;



    /**
     * 新增
     *
     * @param tShopHomeBaseInfo
     */
    @ApiOperation(value = "商家密码设置", notes = "")
    @PostMapping("/addPassword")
    public void addPassword(@RequestBody TShopHomeBaseInfo tShopHomeBaseInfo) {
        tShopHomeBaseInfoService.save(tShopHomeBaseInfo);
    }
    /**
     * 新增
     *
     * @param data
     */
    @ApiOperation(value = "入驻", notes = "{\n" +
            "    \"loginNo\": \"登录人 手机号\",\n" +
            "    \"shopHomeName\": \"商家名称\",\n" +
            "    \"shopGropCode\": \"商家分类编码\",\n" +
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
            "    \"shopTitleImage\": \"店面门头照片 base64字串\",\n" +
            "    \"shopLogo\": \"商家店面logo base64字串\",\n" +
            "    \"shopIndoorPhoto\": \"店铺内部照 多个路劲 使用英文逗号间隔\",\n" +
            "    \"shopGetOrderAutoFlag\": \"商家是否自动接单 Y/N\",\n" +
            "    \"shopPaywaterPrefix\": \"商家流水前缀\",\n" +
            "    \"orderCancelTimeUnit\": \"接单后允许订单取消最大时间单位\",\n" +
            "    \"orderCancelMaxtime\": \"接单后允许订单取消最大时间\",\n" +
            "    \"businessLicenseImage\": \"营业执照 base64字串\",\n" +
            "    \"socialCreditCode\": \"社会信用代码\",\n" +
            "    \"companyName\": \"单位名称\",\n" +
            "    \"foundDt\": \"创办成立时间\",\n" +
            "    \"periodOfValidity\": \"有效期yyyymmdd-yyyymmdd\",\n" +
            "    \"companyClass\": \"商户类型 字典表\",\n" +
            "    \"businessScope\": \"经营范围\",\n" +
            "    \"businessClass\": \"经营类型 字典表\",\n" +
            "    \"telePhone\": \"联系方式\",\n" +
            "    \"companyEmail\": \"公司邮箱\",\n" +
            "    \"legalPersonCardName\": \"法人身份证上名字\",\n" +
            "    \"legalPersonCardNum\": \"法人身份证号\",\n" +
            "    \"legalPersonCardTime\": \"法人身份证有效期\",\n" +
            "    \"legalPersonCardZ\": \"身份证正面图片base64字符串\",\n" +
            "    \"legalPersonCardF\": \"身份证反面图片base64字符串\",\n" +
            "    \"legalPersonBankCard\": \"银行卡号\",\n" +
            "    \"legalPersonCardP\": \"法人手持身份证图 base64 字符串\",\n" +
            "    \"legalPersonBankCardL\": \"银行卡联号\",\n" +
            "    \"legalPersonBankImage\": \"银行卡图片存base64图片\",\n" +
            "    \"legalPersonBankHandImage\": \"法人手持银行卡图片存base64字符串\",\n" +
            "    \"ywqCode\": \"平台业务员编码\",\n" +
            "    \"applyState\": \"商家申请状态 字典表\",\n" +
            "    \"applyFlag\": \"申请是否通过 Y/N\",\n" +
            "    \"applyReturnMsg\": \"申请结果描述\",\n" +
            "    \"shopHomeCode\": \"商家 后台生成的编码\"\n" +
            "}")
    @PostMapping("/add")
    public void add(@RequestBody String data) {
        try {
            Map<String,Object>  map=getRequestCk(data);
            TShopHomeBaseInfo tShopHomeBaseInfo= BeanUtil.toBean(map,TShopHomeBaseInfo.class);

        } catch (Exception e) {
            e.printStackTrace();
        }


//        tShopHomeBaseInfoService.save(tShopHomeBaseInfo);
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
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TShopHomeBaseInfo detail(@RequestParam("id") Long id) {
        return tShopHomeBaseInfoService.getById(id);
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