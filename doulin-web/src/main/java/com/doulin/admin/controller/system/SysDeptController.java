package com.doulin.admin.controller.system;

import cn.hutool.core.bean.BeanUtil;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysDept;
import com.doulin.entity.edo.Tree;
import com.doulin.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * SysDeptController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "部门控制器类")
@CrossOrigin
@RestController
@RequestMapping("/sdept")
@Slf4j
public class SysDeptController extends BaseWebController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 新增
     *
     * @param requestMap
     */
    @ApiOperation(value = "部门添加", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"parentId\": \"父级id 默认传0\",\n" +
            "        \"name\": \"部门名称\",\n" +
            "        \"status\": \"正常0  禁用1\",\n" +
            "        \"sortNum\": \"排序\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        SysDept sysDept= BeanUtil.toBean(getVvalue(requestMap),SysDept.class);
        try {
            sysDept.setAddBy(getLoginUserId(requestMap));
            sysDept.setAddDt(new Date());
            sysDept.setDelFlag(SysContent.INTGER_0);
            if(sysDeptService.save(sysDept)){
                return R.ok();
            }else{
                return R.error(SysContent.ERROR_ADD);
            }
        } catch (Exception e) {
            log.error("/sdept/add"+e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
     * 删除
     *
     * @param requestMap
     */
    @ApiOperation(value = "delete", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\"\n" +
            "       \n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(@RequestBody Map<String,Object> requestMap)  {

        try {
            Map<String, Object> map = getVvalue(requestMap);
            if (null != map.get(SysContent.ID_STR)) {
                String id = map.get(SysContent.ID_STR).toString();
                SysDept sysDept=sysDeptService.getById(id);
                sysDept.setEditDt(new Date());
                sysDept.setDelFlag(SysContent.INTGER_1);
                sysDept.setEditBy(getLoginUserId(requestMap));
                sysDeptService.updateById(sysDept);
            } else {
                throw new MyException(SysContent.ERROR_ID);
            }
        } catch (MyException e) {
            log.error("sysdept/delete***********异常信息" + e.getMessage());
            return R.error(SysContent.ERROR_EDIT);
        }
        return R.ok(SysContent.OK_OPER);
    }

    /**
     * 更新
     *
     * @param requestMap
     */
    @ApiOperation(value = "update", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\",\n" +
            "        \"parentId\": \"父级id 默认传0\",\n" +
            "        \"name\": \"部门名称\",\n" +
            "        \"status\": \"正常0  禁用1\",\n" +
            "        \"sortNum\": \"排序\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody  Map<String,Object> requestMap) {
        SysDept sysDept= BeanUtil.toBean(getVvalue(requestMap),SysDept.class);
        try {
            sysDept.setEditBy(getLoginUserId(requestMap));
            sysDept.setEditDt(new Date());
            if( sysDeptService.updateById(sysDept)){
                return R.ok();
            }else{
                return R.error(SysContent.ERROR_ADD);
            }
        } catch (Exception e) {
            log.error("/sdept/update"+e.getMessage());
            return R.error(e.getMessage());
        }

    }

    /**
     * 详情
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "detail", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\"\n" +
            "    }\n" +
            "}")
    @GetMapping("/detail")
    public Object detail(@RequestBody Map<String,Object> requestMap) {
        Object id=getVvalue(requestMap);
        SysDept sysDept=sysDeptService.getById(Integer.valueOf(id.toString()));
        return R.ok(sysDept);
    }

    /**
     * 分页
     *
     * @param
     * @return
     */
    @ApiOperation(value = "获取部门列表", notes = "无")
    @PostMapping("/getInfoList")
    public Object getList() {
        Tree<SysDept> tree =sysDeptService.getTree();
        return R.ok(tree) ;
    }

}