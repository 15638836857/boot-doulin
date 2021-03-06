package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.common.MyException;
import com.doulin.entity.SysSalesman;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
 * SysSalesmanService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysSalesmanService extends IService<SysSalesman> {

    IPage<SysSalesman> page(VQuery query);

    /**
     * 获取业务员的编码
     * @return
     */
    String getYwyCodeNum(String phone);

    void addAndUpdateParam(String oper,SysSalesman sysSalesman) throws MyException;

    SysSalesman  getOneByPhone(String phone);

    /**
     * 根据凑得 业务员是否 有效 或不存字在
     * @param code
     * @return
     */
    SysSalesman getOneByCode(String code);

    /**
     * 根据id删除 业务员
     * @param ids
     */
    void deleteByIds(String loginUserId,List<String> ids);

    /**
     * 分页获取业务员信息
     * @param vmap
     * @return
     */
    IPage<SysSalesman> pageInfo(Map<String, Object> vmap);
}
