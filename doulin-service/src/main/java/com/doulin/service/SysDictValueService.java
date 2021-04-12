package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysDictValue;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
 * SysDictValueService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysDictValueService extends IService<SysDictValue> {

    IPage<SysDictValue> page(VQuery query);

    /**
     * 根据类型code获取值
     * @param typeCodes
     * @return
     */
    List<SysDictValue> getByTypeCods(List<String> typeCodes);

}
