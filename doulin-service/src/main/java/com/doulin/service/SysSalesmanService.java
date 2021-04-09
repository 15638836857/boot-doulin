package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
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

}
