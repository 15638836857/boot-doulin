package com.doulin.admin.controller.shop;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TCategory;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * TCategoryController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "商品分类控制器类")
@CrossOrigin
@RestController
@RequestMapping("/tcategory")
@Slf4j
public class TCategoryController extends BaseWebController {

    @Autowired
    private TCategoryService tCategoryService;

    /**
     * 新增
     *
     * @param requestMap
     */
    @ApiOperation(value = "商品分类添加", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"name\": \"分类名称\",\n" +
            "        \"shopGroupId\": \"商家分类id\",\n" +
            "        \"image\": \"分类的图片图标  base64 字符串\",\n" +
            "        \"sort\": \"排序\",\n" +
            "        \"status\": \"是否禁用 Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        TCategory tCategory = BeanUtil.toBean(getVvalue(requestMap), TCategory.class);
        try {
            tCategory.setAddBy(getLoginUserId(requestMap));
            tCategory.setDelFlag(SysContent.INTGER_0);
            tCategory.setAddDt(new Date());
            TCategory tt = tCategoryService.getOneByName(tCategory.getName());
            if (null != tt) {
                throw new MyException(SysContent.ERROR_EXISIS);
            }
            tCategoryService.save(tCategory);
            return R.ok();
        } catch (MyException e) {
            log.error("添加商品分类异常***" + e.getMessage());
            return R.error(e.getMessage());
        }
    }
    /**
     * 修改
     *
     * @param requestMap
     */
    @ApiOperation(value = "商品分类修改", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\",\n" +
            "        \"name\": \"分类名称\",\n" +
            "        \"shopGroupId\": \"商家分类id\",\n" +
            "        \"image\": \"分类的图片图标  base64 字符串\",\n" +
            "        \"sort\": \"排序\",\n" +
            "        \"status\": \"是否禁用 Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
        TCategory tCategory = BeanUtil.toBean(getVvalue(requestMap), TCategory.class);
        try {
            if(tCategory.getId()==null){
                throw new MyException(SysContent.ERROR_PARAM_ID);
            }
            tCategory.setEditBy(getLoginUserId(requestMap));
            tCategory.setEditDt(new Date());
            TCategory tt = tCategoryService.getOneByName(tCategory.getName());
            if (null != tt && !tt.getId().equals(tCategory.getId())) {
                throw new MyException(SysContent.ERROR_EXISIS);
            }
            tCategoryService.save(tCategory);
            return R.ok();
        } catch (MyException e) {
            log.error("修改商品分类异常***" + e.getMessage());
            return R.error(e.getMessage());
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
        tCategoryService.removeByIds(Arrays.asList(ids));
    }



    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TCategory detail(@RequestParam("id") Long id) {
        return tCategoryService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TCategory> userList(@RequestBody(required = false) VQuery query) {
        return tCategoryService.page(query);
    }

}