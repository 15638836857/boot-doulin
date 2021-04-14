package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.common.MyException;
import com.doulin.entity.SysSalesman;
import com.doulin.entity.vo.VQuery;

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
}
