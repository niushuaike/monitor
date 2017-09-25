package com.micropower.manager.service;

import jxl.write.DateTime;
import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by niushuaike on 2017/9/19.
 */
@Service
public class ScheduleTask {

    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;

    public void bTask() {
        threadPoolTaskScheduler.schedule(new Runnable() {
            @Override
            public void run() {
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(sdf.format(new Date()) + "*********B任务每5秒执行一次进入测试");

            }
        }, new org.springframework.scheduling.support.CronTrigger("0/5 * *  * * ?"));
    }

}
