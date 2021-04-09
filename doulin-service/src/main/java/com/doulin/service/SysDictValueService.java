package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysDictValue;
import com.doulin.entity.vo.VQuery;

/**
 * SysDictValueService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysDictValueService extends IService<SysDictValue> {

    IPage<SysDictValue> page(VQuery query);

}
