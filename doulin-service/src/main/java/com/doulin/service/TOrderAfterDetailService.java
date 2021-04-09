package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TOrderAfterDetail;
import com.doulin.entity.vo.VQuery;

/**
 * TOrderAfterDetailService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TOrderAfterDetailService extends IService<TOrderAfterDetail> {

    IPage<TOrderAfterDetail> page(VQuery query);

}
