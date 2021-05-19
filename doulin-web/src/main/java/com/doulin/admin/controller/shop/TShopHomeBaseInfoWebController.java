package com.doulin.admin.controller.shop;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.service.TShopHomeBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/tshopHomeBaseInfo")
@Slf4j
public class TShopHomeBaseInfoWebController extends BaseWebController {

    @Autowired
    private TShopHomeBaseInfoService tShopHomeBaseInfoService;


    /**
     * 详情
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "查看详情", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"userNo\": \"商家账号\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/detail")
    public Object detail(@RequestBody Map<String,Object> requestMap) {
        String userNo = getVvalue(requestMap).get("userNo").toString();
        TShopHomeBaseInfo shopHomeBaseInfo = tShopHomeBaseInfoService.getInfoAndAnyCommunityByLoginNo(userNo);
        return R.ok(shopHomeBaseInfo);
    }
   @ApiOperation(value = "编辑对应多个社区", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\",\n" +
            "        \"anyCommunityCode\": \"商家关联其它社区的code 多个逗号间隔\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
       Map<String, Object> v = getVvalue(requestMap);
       TShopHomeBaseInfo shopHomeBaseInfo = BeanUtil.toBean(v, TShopHomeBaseInfo.class);
       try {
           String userNo = getSvalue(requestMap).get("loginUserId").toString();
           if (null == shopHomeBaseInfo.getId()) {
               throw new Exception(SysContent.ERROR_PARAM);
           } else if (StrUtil.isEmpty(shopHomeBaseInfo.getAnyCommunityCode())) {
               throw new Exception(SysContent.ERROR_PARAM);
           } else {
               shopHomeBaseInfo.setEditBy(userNo);
               shopHomeBaseInfo.setEditDt(new Date());
               tShopHomeBaseInfoService.updateById(shopHomeBaseInfo);
           }
       } catch (Exception e) {
           log.error("tshopHomeBaseInfo/update****" + e.getMessage());
           return R.error(e.getMessage());
       }
       return R.ok();
   }


    /**
     * 分页
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "商家信息分页列表", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"applyState\": \"0:未入驻、 1:已填写基本资料 2:待业务上门开店、3:待支付三方审核 4:开户失败需更改资料 5：成功入驻\",\n" +
            "        \"applyFlag\": \"申请通过 Y  \"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object userList(@RequestBody Map<String,Object> requestMap) {
        IPage<TShopHomeBaseInfo> page=tShopHomeBaseInfoService.getPageInfo(getPageParm(requestMap));

        return R.ok(page);
    }

}