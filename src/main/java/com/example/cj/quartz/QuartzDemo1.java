package com.example.cj.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo1 {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
//        System.out.println(scheduler.getSchedulerName());
//        System.out.println(scheduler.getMetaData().getJobStoreClass());
//        System.out.println(scheduler.getMetaData().getThreadPoolSize());
        JobDetail jobDetail1 = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        JobDetail jobDetail2 = JobBuilder.newJob(MyJob2.class)
                .withIdentity("job2", "group1")
                .usingJobData("name", "david")
                .usingJobData("age", 18)
                .build();

        Trigger trigger1 = TriggerBuilder.newTrigger().startNow().build();

        Trigger trigger2 = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(3)
                                .withRepeatCount(2))
                .build();

        scheduler.scheduleJob(jobDetail1, trigger1);
        scheduler.scheduleJob(jobDetail2, trigger2);
        Thread.sleep(10000);
        scheduler.shutdown();
    }
}
