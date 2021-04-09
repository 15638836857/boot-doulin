package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysDictType;
import com.doulin.entity.vo.VQuery;

/**
 * SysDictTypeService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysDictTypeService extends IService<SysDictType> {

    IPage<SysDictType> page(VQuery query);

}
