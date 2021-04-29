package com.doulin.admin.controller.shop;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.R;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.service.TShopHomeBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class TShopHomeBaseInfoWebController extends BaseWebController {

    @Autowired
    private TShopHomeBaseInfoService tShopHomeBaseInfoService;

    /**
     * 新增
     *
     * @param tShopHomeBaseInfo
     */
//    @ApiOperation(value = "add", notes = "")
//    @PostMapping("/add")
//    public void add(@RequestBody TShopHomeBaseInfo tShopHomeBaseInfo) {
//        tShopHomeBaseInfoService.save(tShopHomeBaseInfo);
//    }

    /**
     * 删除
     *
     * @param ids
     */
//    @ApiOperation(value = "delete", notes = "")
//    @GetMapping("/delete")
//    public void delete(@RequestParam("ids") Long... ids) {
//        tShopHomeBaseInfoService.removeByIds(Arrays.asList(ids));
//    }

    /**
     * 更新
     *
     * @param tShopHomeBaseInfo
     */
//    @ApiOperation(value = "update", notes = "")
//    @PostMapping("/update")
//    public void update(@RequestBody TShopHomeBaseInfo tShopHomeBaseInfo) {
//        tShopHomeBaseInfoService.updateById(tShopHomeBaseInfo);
//    }

    /**
     * 详情
     *
     * @param id
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
        TShopHomeBaseInfo shopHomeBaseInfo = tShopHomeBaseInfoService.getInfoByLoginNo(userNo);
        return R.ok(shopHomeBaseInfo);
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