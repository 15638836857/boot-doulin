package com.doulin.admin.controller.system;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysSalesman;
import com.doulin.service.SysSalesmanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * SysSalesmanController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "业务员控制器类")
@CrossOrigin
@RestController
@RequestMapping("/ssman")
@Slf4j
public class SysSalesmanController extends BaseWebController {

    @Autowired
    private SysSalesmanService sysSalesmanService;

    /**
     * 新增
     *
     * @param requestMap
     */
    @ApiOperation(value = "店铺推广业务员添加", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"name\": \"业务员名称\",\n" +
            "        \"phone\": \"业务员电话\",\n" +
            "        \"status\":\"业务员 是否禁用 Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        SysSalesman sysSalesman= BeanUtil.toBean(getVvalue(requestMap),SysSalesman.class);
        try {
            sysSalesman.setAddBy(getLoginUserId(requestMap));
            sysSalesman.setAddDt(new Date());
            sysSalesman.setDelFlag(SysContent.INTGER_0);
            sysSalesmanService.addAndUpdateParam(SysContent.OPER_ADD,sysSalesman);
            sysSalesman.setCode(sysSalesmanService.getYwyCodeNum(sysSalesman.getPhone()));
            sysSalesmanService.save(sysSalesman);
        } catch (MyException e) {
            log.error("ssman/add"+e.getMessage());
            return R.error(e.getMessage());
        }
       return R.ok();
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
            "        \"id\": \"数据id多个使用英文逗号间隔\"\n" +
            "       \n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(@RequestBody Map<String,Object> requestMap) {
        try {
            String loginUserId = getLoginUserId(requestMap);
            String ids = getVvalue(requestMap).get(SysContent.ID_STR).toString();
            sysSalesmanService.deleteByIds(loginUserId, Arrays.asList(ids));
        } catch (MyException e) {
            log.error("ssman/delete" + e.getMessage());
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    /**
     * 更新

     */

    @ApiOperation(value = "店铺推广业务员修改", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\",\n" +
            "        \"status\":\"业务员 是否禁用 Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
       String status=getVvalue(requestMap).get(SysContent.STATUS).toString();
        try {
            SysSalesman sysSalesman=new SysSalesman();
            sysSalesman.setId(Integer.valueOf(getVvalue(requestMap).get(SysContent.ID_STR).toString()));
            sysSalesman.setEditBy(getLoginUserId(requestMap));
            sysSalesman.setEditDt(new Date());
            sysSalesman.setStatus(status);
            sysSalesmanService.updateById(sysSalesman);
        } catch (MyException e) {
            log.error("ssman/update"+e.getMessage());
            return R.error(e.getMessage());
        }
        return R.ok();
    }
    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysSalesman detail(@RequestParam("id") Long id) {
        return sysSalesmanService.getById(id);
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
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"value\": \"姓名或手机号\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object userList(@RequestBody Map<String,Object> requestMap) {
        Map<String,Object> smap=getSvalue(requestMap);
        Map<String,Object> vmap=getVvalue(requestMap);
        vmap.putAll(smap);
        IPage<SysSalesman> page=sysSalesmanService.pageInfo(vmap);
        if(page.getRecords().size()>0){
            return R.ok(page);
        }
        return R.error(SysContent.ERROR_EMPTY);
    }

}