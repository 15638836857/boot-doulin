package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TCar;
import com.doulin.entity.vo.VQuery;

/**
 * TCarService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TCarService extends IService<TCar> {

    IPage<TCar> page(VQuery query);

}
