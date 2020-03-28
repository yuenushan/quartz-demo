package com.example.cj.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo1 {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(3)
                                .repeatForever())
                .build();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
        Thread.sleep(10000);
        scheduler.shutdown();
    }
}
