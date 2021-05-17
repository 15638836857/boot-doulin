package com.doulin.mobile.controller;

import com.doulin.entity.common.ResJson;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.TBankInfoService;
import com.doulin.service.UtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* TBankInfoController
* @Author malinging
* @Date 2021-04-22
**/
@Api(tags = "用户银行卡管理")
@RestController
@CrossOrigin
@RequestMapping("app/tBankInfo")
@Slf4j
public class TBankInfoAppController extends BaseAppController {

    @Autowired
    private TBankInfoService tBankInfoService;
    @Autowired
    private UtilService utilService;



    /**
    * 新增
    *
    * @param json
    */
    @ApiOperation(value = "根据银行卡号获取银行logo", notes = "{\n" +
            "    \"cardNo\": \"银行卡号\"\n" +
            "}")
    @PostMapping("/getBanKLogoByCardNo")
    public Object add(String json) {
        try {
            String cardNo = getRequestCk(json).get("cardNo").toString();
            Object url = utilService.getBankLogoByCardNo(cardNo);
            return responseAppRes(ResJson.Ok(url));
        } catch (Exception e) {
            log.error("根据银行卡号获取银行logo***" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
//    /**
//    * 新增
//    *
//    * @param tBankInfo
//    */
//    @ApiOperation(value = "add", notes = "")
//    @PostMapping("/add")
//    public void add(@RequestBody TBankInfo tBankInfo) {
//        tBankInfoService.save(tBankInfo);
//    }

//    /**
//    * 删除
//    *
//    * @param ids
//    */
//    @ApiOperation(value = "delete", notes = "")
//    @GetMapping("/delete")
//    public void delete(@RequestParam("ids") Long... ids) {
//        tBankInfoService.removeByIds(Arrays.asList(ids));
//    }
//
//    /**
//    * 更新
//    *
//    * @param tBankInfo
//    */
//    @ApiOperation(value = "update", notes = "")
//    @PostMapping("/update")
//    public void update(@RequestBody TBankInfo tBankInfo) {
//        tBankInfoService.updateById(tBankInfo);
//    }
//
//    /**
//    * 详情
//    *
//    * @param id
//    * @return
//    */
//    @ApiOperation(value = "detail", notes = "")
//    @GetMapping("/detail")
//    public TBankInfo detail(@RequestParam("id") Long id) {
//        return tBankInfoService.getById(id);
//    }
//
//    /**
//    * 分页
//    *
//    * @param query
//    * @return
//    */
//    @ApiOperation(value = "page", notes = "")
//    @PostMapping("/page")
//    public IPage<TBankInfo> userList(@RequestBody(required = false) VQuery query) {
//        return tBankInfoService.page(query);
//    }

}