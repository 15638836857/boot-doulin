package com.doulin.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysDictType;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * SysDictTypeController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "字典类型控制器")
@RestController
@RequestMapping("/sysDictType")
@Slf4j
public class SysDictTypeController extends BaseWebController {

    @Autowired
    private SysDictTypeService sysDictTypeService;

    /**
     * 新增
     *
     * @param requestMap
     */
    @ApiOperation(value = "添加字典类型接口", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"typeCode\": \"字典类型编码,唯一 建议使用英文大写字母\",\n" +
            "        \"typeName\": \"字典名称\",\n" +
            "        \"remark\": \"字典描述\",\n" +
            "        \"sort\": 0\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        SysDictType sysDictType = BeanUtil.toBean(getVvalue(requestMap), SysDictType.class);
        try {
            String loginUserid = getLoginUserId(requestMap);
            sysDictType.setAddBy(loginUserid);
            sysDictType.setAddDt(new Date());
            sysDictType.setDelFlag(SysContent.INTGER_0);
            sysDictTypeService.addOrUpdate(SysContent.OPER_ADD, sysDictType);
        } catch (MyException e) {
            log.error("sysDictType/add***********异常信息" + e.getMessage());
            return R.error(SysContent.ERROR_ADD);
        }
        return R.ok(SysContent.OK_OPER);
    }
    /**
     * 更新
     *
     * @param requestMap
     */
    @ApiOperation(value = "编辑字典类型接口", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "    \t\"id\":123,\n" +
            "        \"typeCode\": \"字典类型编码,唯一 建议使用英文大写字母\",\n" +
            "        \"typeName\": \"字典名称\",\n" +
            "        \"remark\": \"字典描述\",\n" +
            "        \"sort\": 0\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody  Map<String,Object> requestMap) {
        SysDictType sysDictType = BeanUtil.toBean(getVvalue(requestMap), SysDictType.class);
        try {
            if(null==sysDictType.getId()){
                throw new MyException(SysContent.ERROR_PARAM_ID);
            }
            String loginUserid = getLoginUserId(requestMap);
            sysDictType.setEditBy(loginUserid);
            sysDictType.setEditDt(new Date());
            sysDictType.setDelFlag(SysContent.INTGER_0);
            sysDictTypeService.addOrUpdate(SysContent.OPER_EDIT,sysDictType);
        } catch (MyException e) {
            log.error("sysDictType/update***********异常信息" + e.getMessage());
            return R.error(SysContent.ERROR_EDIT);
        }
        return R.ok(SysContent.OK_OPER);
    }

    /**
     * 删除
     *
     * @param requestMap
     */
    @ApiOperation(value = "删除字典类型接口", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "    \t\"id\":\"123,13,15\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(@RequestBody Map<String,Object> requestMap) {
        try {
            Map<String, Object> map = getVvalue(requestMap);
            if (null != map.get(SysContent.ID_STR)) {
                String ids = map.get(SysContent.ID_STR).toString();
                SysDictType sysDictType = new SysDictType();
                sysDictType.setTypeCode(ids);
                sysDictTypeService.addOrUpdate(SysContent.OPER_DELETE, sysDictType);
            } else {
                throw new MyException(SysContent.ERROR_ID);
            }
        } catch (MyException e) {
            log.error("sysDictType/delete***********异常信息" + e.getMessage());
            return R.error(SysContent.ERROR_EDIT);
        }
        return R.ok(SysContent.OK_OPER);
    }



    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "    \t\"id\":\"单个id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/detail")
    public Object detail(@RequestParam("id") Integer id) {
        Map<String,Object> result=BeanUtil.beanToMap(sysDictTypeService.getOneById(id));
        return R.ok(result);
    }

    /**
     * 分页
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "page", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "    \t\"typeCode\":\"字典类型code\",\n" +
            "    \t\"typeName\":\"字典类型名称 模糊后缀 查询\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public IPage<SysDictType> userList(@RequestBody Map<String,Object> requestMap) {
        Map<String, Object> smap = getVvalue(requestMap);
        Map<String, Object> vmap = getVvalue(requestMap);
        vmap.putAll(smap);
        List<SysDictType> list = sysDictTypeService.pageInfo(vmap);
        Integer count = sysDictTypeService.countByMap(vmap);
        IPage<SysDictType> pageInfo;
        Page<SysDictType> page = new Page<SysDictType>(Long.valueOf(smap.get(SysContent.PAGE).toString()),
                Long.valueOf(smap.get(SysContent.ROWS).toString()));
        page.setTotal(Long.valueOf(count.toString()));
        page.setRecords(list);
        return page;
    }

}