package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TBankInfo;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
* TBankInfoService
* @Author malinging
* @Date 2021-04-22
**/
public interface TBankInfoService extends IService<TBankInfo> {

    IPage<TBankInfo> page(VQuery query);

    List<TBankInfo> getInfoByType(Integer type, String province,String city,String bank);
}
