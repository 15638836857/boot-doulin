package com.doulin.admin.listenner;

import com.doulin.admin.config.quartz.utils.QuartzManager;
import com.doulin.entity.SysLog;
import com.doulin.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
@Slf4j
public class ScheduleJobInitListener implements CommandLineRunner {

	@Autowired
	SysLogService scheduleJobService;

	@Autowired
	QuartzManager quartzManager;

	@Override
	public void run(String... arg0) throws Exception {
		try {
			scheduleJobService.initSchedule();
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

}