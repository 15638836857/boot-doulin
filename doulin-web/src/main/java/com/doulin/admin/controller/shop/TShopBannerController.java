package com.doulin.admin.controller.shop;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopBanner;
import com.doulin.service.TShopBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
* TShopBannerController
* @Author malinging
* @Date 2021-05-18
**/
@Api(tags = "商家banner轮播图")
@RestController
@RequestMapping("/tsb")
@CrossOrigin
@Slf4j
public class TShopBannerController extends BaseWebController {
    private final static String api_host="tsb";

    @Autowired
    private  TShopBannerService tShopBannerService;

    /**
    * 新增
    *
    * @param map
    */
    @ApiOperation(value = "添加/编辑/删除", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"oper\": \"add/edit/del\",\n" +
            "        \"id\": \"编辑时/删除时 必传\",\n" +
            "        \"shopHomeCode\": \"商家编号\",\n" +
            "        \"url\": \"bannner图片url \",\n" +
            "        \"sort\": \"排序 \",\n" +
            "        \"title\": \"标题 \",\n" +
            "        \"status\": \"是否有效  Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/addOrUpdate")
    public Object add(@RequestBody Map<String,Object> map) {
        try {
            Map<String, Object> v = getVvalue(map);
            TShopBanner tShopBanner = BeanUtil.toBean(v, TShopBanner.class);
            String oper = v.get(SysContent.OPER_STR).toString();
            Date update = new Date();
            if (SysContent.OPER_DELETE.equals(oper)) {
                tShopBanner.setDelFlag(SysContent.INTGER_1);
                tShopBanner.setEditDt(update);
                tShopBanner.setEditBy(getSvalue(map).get(SysContent.LOGIN_USERID).toString());
            } else {
                tShopBanner.setDelFlag(SysContent.INTGER_0);
                tShopBanner.setAddDt(update);
                tShopBanner.setAddBy(getSvalue(map).get(SysContent.LOGIN_USERID).toString());
            }
            if(SysContent.OPER_EDIT.equals(oper) || SysContent.OPER_DELETE.equals(oper)){
                if(null==tShopBanner.getId()){
                    throw new Exception(SysContent.ERROR_ID);
                }
            }
            if (SysContent.OPER_ADD.equals(oper) || SysContent.OPER_EDIT.equals(oper)) {
                if (StrUtil.isEmpty(tShopBanner.getTitle())) {
                    throw new Exception("标题不能为空");
                } else if (null == tShopBanner.getSort()) {
                    throw new Exception("排序不能为空");
                } else if (StrUtil.isEmpty(tShopBanner.getShopHomeCode())) {
                    throw new Exception("商家编码不能为空");
                } else if (StrUtil.isEmpty(tShopBanner.getUrl())) {
                    throw new Exception("banner图不能为空");
                } else if (StrUtil.isEmpty(tShopBanner.getStatus())) {
                    throw new Exception("是否有效不能为空");
                }
            }
            tShopBannerService.saveOrUpdate(tShopBanner);
            return R.ok();
        } catch (Exception e) {
            log.error(api_host + "addOrUpdate**" + e.getMessage());
            return R.error(e.getMessage());
        }
    }



    /**
    * 详情
    *
    * @param map
    * @return
    */
    @ApiOperation(value = "获取详情", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"必传\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/detail")
    public Object detail(@RequestBody Map<String,Object> map) {
        try {
            Map<String, Object> v = getVvalue(map);
            Integer id=Integer.valueOf(v.get(SysContent.ID_STR).toString());
            return R.ok(tShopBannerService.getById(id));
        } catch (NumberFormatException e) {
            log.error(api_host + "detail**" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
    * 分页
    *
    * @param map
    * @return
    */
    @ApiOperation(value = "分页数据", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"value\": \"商家名称\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object userList(@RequestBody Map<String,Object> map) {
        Map<String,Object> pageMap=getPageParm(map);
        IPage<TShopBanner> page=tShopBannerService.getPageInfo(pageMap);
        return R.ok(page);
    }

}