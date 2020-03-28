package com.example.cj.quartz;

import org.quartz.*;

import java.util.Date;

public class MyJob implements Job {

    public MyJob() {
        System.out.println("new job instance");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
//        JobDataMap jobDataMap1 = context.getTrigger().getJobDataMap();
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        String jobSays = mergedJobDataMap.getString("jobSays");
        float myFloatValue = mergedJobDataMap.getFloat("myFloatValue");
        JobKey key = context.getJobDetail().getKey();
        System.out.println("instance: " + key + " says: " + jobSays + " and value is " + myFloatValue + ". " + new Date());
    }
}
