package com.highlight_spring4.scheduletask;

import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTaskService {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {

		System.out.println("每个5秒执行一次");
	}

	@Scheduled(cron = "0 51 13 ? * *")
	public void fixTimeExecution() {

		System.out.println("指定时间执行");
	}
}
