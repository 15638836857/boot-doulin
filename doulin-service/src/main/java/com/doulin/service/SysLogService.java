package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysLog;
import com.doulin.entity.vo.VQuery;

/**
 * SysLogService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysLogService extends IService<SysLog> {

    IPage<SysLog> page(VQuery query);

    void initSchedule();
}
