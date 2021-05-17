package com.doulin.mobile.controller.shophd;

import cn.hutool.core.bean.BeanUtil;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopMakeMeter;
import com.doulin.entity.common.ResJson;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.TShopMakeMeterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
* TShopMakeMeterController
* @Author malinging
* @Date 2021-05-04
**/
@Api(tags = "App物料下载")
@RestController
@CrossOrigin
@RequestMapping("app/tsmm")
@Slf4j
public class TShopMakeMeterAppController extends BaseAppController {

    @Autowired
    private TShopMakeMeterService tShopMakeMeterService;

    /**
    * 新增
    *
    * @param json
    */
    @ApiOperation(value = "add", notes = "{\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"shopHomeCode\": \"商家编码\",\n" +
            "    \"num\": \"定制份数\",\n" +
            "    \"dzType\": \"定制类型\",\n" +
            "    \"wifiPassword\": \"wifi密码\",\n" +
            "    \"wifiName\": \"wifi名称\",\n" +
            "    \"showFlag\": \"是否显示 wifi密码  Y/N \",\n" +
            "    \"telePhone\": \"联系电话 默认为登录号\"\n" +
            "}")
    @PostMapping("/add")
    public Object add(String json) {
        try {
            TShopMakeMeter tShopMakeMeter = BeanUtil.toBean(getRequestCk(json), TShopMakeMeter.class);
            tShopMakeMeter.setAddBy((getRequestCk(json).get(SysContent.LOGINNO_STR).toString()));
            tShopMakeMeter.setAddDt(new Date());
            TShopMakeMeter tsmm=tShopMakeMeterService.getInfoByShopHomeCodeAndTypeId(tShopMakeMeter.getShopHomeCode(),tShopMakeMeter.getDzType());
            if(null!=tsmm){
                tShopMakeMeter.setId(tsmm.getId());
                tShopMakeMeterService.saveAndUpdate(SysContent.OPER_EDIT, tShopMakeMeter);
            }else {
                tShopMakeMeterService.saveAndUpdate(SysContent.OPER_ADD, tShopMakeMeter);
            }
            return responseAppRes(ResJson.Ok(tShopMakeMeter));
        } catch (Exception e) {
            log.error("app/tsmm/add***********" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
  /**
    * 新增
    *
    * @param json
    */
    @ApiOperation(value = "详情", notes = "{\n" +
            "    \"shopHomeCode\": \"商家编码\",\n" +
            "    \"dzType\": \"定制类型\"\n" +
            "}")
    @PostMapping("/detail")
    public Object detail(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String shopHomeCode = map.get("shopHomeCode").toString();
            String type = map.get("dzType").toString();
            TShopMakeMeter tsmm = tShopMakeMeterService.getInfoByShopHomeCodeAndTypeId(shopHomeCode, type);
            if(SysContent.MYCODE.equals(type)||SysContent.SHOPORDERCODE.equals(type)){
                 if(null==tsmm){
                     tsmm=new TShopMakeMeter();
                     tsmm.setDzType(type);
                     tsmm.setShopHomeCode(shopHomeCode);
                     tShopMakeMeterService.saveAndUpdate(SysContent.OPER_ADD, tsmm);
                 }
            }
            return responseAppRes(ResJson.Ok(tsmm));
        } catch (Exception e) {
            log.error("app/tsmm/detail***********" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }

    /**
    * 删除
    *
    * @param ids
    */
//    @ApiOperation(value = "delete", notes = "")
//    @GetMapping("/delete")
//    public void delete(@RequestParam("ids") Long... ids) {
//        tShopMakeMeterService.removeByIds(Arrays.asList(ids));
//    }

//    /**
//    * 更新
//    *
//    * @param json
//    */
//    @ApiOperation(value = "更新", notes = "{\n" +
//            "    \"id\": \"数据id\",\n" +
//            "    \"loginNo\": \"登录号\",\n" +
//            "    \"shopHomeCode\": \"商家编码\",\n" +
//            "    \"num\": \"定制份数\",\n" +
//            "    \"type\": \"定制类型\",\n" +
//            "    \"wifiPassword\": \"wifi密码\",\n" +
//            "    \"showFlag\": \"是否显示 wifi密码  Y/N \",\n" +
//            "    \"telePhone\": \"联系电话 默认为登录号\"\n" +
//            "}")
//    @PostMapping("/update")
//    public String update(String json) {
//        try {
//            TShopMakeMeter tShopMakeMeter = BeanUtil.toBean(getRequestCk(json), TShopMakeMeter.class);
//            tShopMakeMeter.setAddBy((getRequestCk(json).get(SysContent.LOGINNO_STR).toString()));
//            tShopMakeMeter.setAddDt(new Date());
//            tShopMakeMeterService.saveAndUpdate(SysContent.OPER_EDIT, tShopMakeMeter);
//            return responseAppRes(ResJson.Ok(tShopMakeMeter));
//        } catch (Exception e) {
//            log.error("app/tsmm/update***********" + e.getMessage());
//            return responseAppRes(ResJson.error(e.getMessage()));
//        }
//    }


    /**
    * 分页
    *
    * @param query
    * @return
    */
//    @ApiOperation(value = "page", notes = "")
//    @PostMapping("/page")
//    public IPage<TShopMakeMeter> userList(@RequestBody(required = false) VQuery query) {
//        return tShopMakeMeterService.page(query);
//    }

}