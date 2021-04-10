package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.entity.SysLog;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysLogMapper;
import com.doulin.service.SysLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


/**
 * SysLogServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Override
    public IPage<SysLog> page(VQuery query) {
        IPage<SysLog> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void initSchedule() {
        // 这里获取任务信息数据
//        List<TaskDO> jobList = taskScheduleJobMapper.list(new HashMap<String, Object>(16));
//        for (TaskDO scheduleJob : jobList) {
//            if ("1".equals(scheduleJob.getJobStatus())) {
//                ScheduleJob job = ScheduleJobUtils.entityToData(scheduleJob);
//                quartzManager.addJob(job);
//            }
//
//        }
    }

}