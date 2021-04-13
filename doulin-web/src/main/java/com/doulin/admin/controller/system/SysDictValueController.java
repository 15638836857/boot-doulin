package com.doulin.admin.controller.system;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysDictType;
import com.doulin.entity.SysDictValue;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysDictValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * SysDictValueController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "字典值控制器类")
@RestController
@RequestMapping("/sysDictValue")
@Slf4j
public class SysDictValueController extends BaseWebController {

    @Autowired
    private SysDictValueService sysDictValueService;

    /**
     * 新增
     *
     * @param requestMap
     */
    @ApiOperation(value = "字典类型值添加", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"typeCode\": \"类型编码\",\n" +
            "        \"label\": \"字典关联的值名称\",\n" +
            "        \"value\": \"字典关联的值\",\n" +
            "        \"sort\": 0,\n" +
            "        \"remark\": \"字典描述\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        SysDictValue sysDictValue = BeanUtil.toBean(getVvalue(requestMap), SysDictValue.class);
        try {
            String loginUserid = getLoginUserId(requestMap);
            sysDictValue.setAddBy(loginUserid);
            sysDictValue.setAddDt(new Date());
            sysDictValue.setDelFlag(SysContent.INTGER_0);
            boolean flag = sysDictValueService.addAndUpdate(SysContent.OPER_ADD, sysDictValue);
            if (flag) {
                return R.ok();
            } else {
                return R.error(SysContent.ERROR_ADD);
            }
        } catch (MyException e) {
            log.error("sysDictValue/add" + e.getMessage());
            return R.error(e.getMessage());
        }
    }
    /**
     * 更新
     * @param requestMap
     */
    @ApiOperation(value = "字典类型值编辑", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "    \t\"id\":123213,\n" +
            "        \"typeCode\": \"类型编码\",\n" +
            "        \"label\": \"字典关联的值名称\",\n" +
            "        \"value\": \"字典关联的值\",\n" +
            "        \"sort\": 0,\n" +
            "        \"remark\": \"字典描述\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody  Map<String,Object> requestMap) {
        SysDictValue sysDictValue = BeanUtil.toBean(getVvalue(requestMap), SysDictValue.class);
        try {
            String loginUserid = getLoginUserId(requestMap);
            sysDictValue.setEditBy(loginUserid);
            sysDictValue.setEditDt(new Date());
            boolean flag = sysDictValueService.addAndUpdate(SysContent.OPER_EDIT, sysDictValue);
            if (flag) {
                return R.ok();
            } else {
                return R.error(SysContent.ERROR_EDIT);
            }
        } catch (MyException e) {
            log.error("sysDictValue/update" + e.getMessage());
            return R.error(e.getMessage());
        }

    }

    /**
     * 删除
     *
     * @param requestMap id
     */
    @ApiOperation(value = "字典删除", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "    \t\"id\":123213\n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(@RequestBody  Map<String,Object> requestMap) {
        try {
            Map<String,Object> vmap=getVvalue(requestMap);
            if(null!=vmap.get(SysContent.ID_STR)){
                Integer id=Integer.valueOf(vmap.get(SysContent.ID_STR).toString());
                SysDictValue sysDictValue = new SysDictValue();
                String loginUserid = getLoginUserId(requestMap);
                sysDictValue.setEditBy(loginUserid);
                sysDictValue.setEditDt(new Date());
                sysDictValue.setDelFlag(SysContent.INTGER_1);
                sysDictValue.setId(id);
                boolean flag = sysDictValueService.updateById(sysDictValue);
                if (flag) {
                    return R.ok();
                } else {
                    return R.error();
                }
            }else{
                throw new MyException(SysContent.ERROR_ID);
            }
        } catch (MyException e) {
            log.error("sysDictValue/delete" + e.getMessage());
            return R.error(e.getMessage());
        }
    }


    /**
     * 详情
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "根据id获取详情", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "    \t\"id\":123213\n" +
            "    }\n" +
            "}")
    @GetMapping("/detail")
    public Object detail(@RequestBody  Map<String,Object> requestMap) {
        try {
            Map<String,Object> vmap=getVvalue(requestMap);
            if(null!=vmap.get(SysContent.ID_STR)){
                Integer id=Integer.valueOf(vmap.get(SysContent.ID_STR).toString());
                List<Integer> ids=new ArrayList<>();
                ids.add(id);
                return R.ok(BeanUtil.beanToMap(sysDictValueService.getListByIds(ids).get(0)));
            }else{
                throw new MyException(SysContent.ERROR_ID);
            }
        } catch (MyException e) {
            log.error("sysDictValue/detail" + e.getMessage());
            return R.error(e.getMessage());
        }

    }



}