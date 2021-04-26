package com.doulin.admin.controller.common;

import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.service.ShopToTreeService;
import com.doulin.service.TShopHomeBaseInfoService;
import com.doulin.service.UtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @className CommonWebController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/23 15:30
 * @Version 1.0
 */
@Api(tags = "公共接口类")
@CrossOrigin
@RestController
@RequestMapping("/tool")
@Slf4j
public class CommonWebController extends BaseWebController {

    @Autowired
    private UtilService utilService;
    @Autowired
    private ShopToTreeService shopToTreeService;
    @Autowired
    private TShopHomeBaseInfoService shopHomeBaseInfoService;

    @ApiOperation(value = "上传图片",notes = "file:文件  type:1 商家  ，2/用户")
    @PostMapping(value = "/addimgs")
    public Object addimgs(HttpServletRequest request, @RequestParam("file") MultipartFile[] file, String type) {
        try {
            List<String> fileUrl = utilService.uploadImg(file, type);
            return R.ok(fileUrl);
        } catch (Exception e) {
            log.error("请求处理异常" + e.getMessage());
            return R.error("请求处理异常");
        }
    }
    @ApiOperation(value ="删除图片" ,notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"url\": \"文件路径\"\n" +
            "    }\n" +
            "}")
    @PostMapping(value = "/deleteImg")
    public Object addimgs(  @RequestBody Map<String,Object> requestMap) {
        try {
            Map<String, Object> map = getVvalue(requestMap);
            String url = map.get(SysContent.URL_STR).toString();
            utilService.deleteImag(url);
            return R.ok(SysContent.OK_OPER);
        } catch (Exception e) {
            log.error("请求处理异常" + e.getMessage());
            return R.error(SysContent.ERROR_REQUEST);
        }
    }
    @ApiOperation(value ="商家信息上传" ,notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"phone\": \"文件路径\"\n" +
            "    }\n" +
            "}")
    @PostMapping(value = "/shopImpot")
    public Object shopImpot( String pone) {
        try {
            TShopHomeBaseInfo st=shopHomeBaseInfoService.getInfoByLoginNo(pone);
            return R.ok(shopToTreeService.operToSykAddOrUpdate(st,"Mchinlet","Add"));
        } catch (Exception e) {
            log.error("请求处理异常" + e.getMessage());
            return R.error(SysContent.ERROR_REQUEST);
        }
    }
}
