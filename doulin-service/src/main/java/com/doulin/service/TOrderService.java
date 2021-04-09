package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TOrder;
import com.doulin.entity.vo.VQuery;

/**
 * TOrderService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TOrderService extends IService<TOrder> {

    IPage<TOrder> page(VQuery query);

}
