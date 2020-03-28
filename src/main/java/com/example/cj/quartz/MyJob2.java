package com.example.cj.quartz;

import org.quartz.*;

import java.util.Date;

/*
告诉Quartz不要同时执行给定Job定义（指给定Job类）的多个实例
 */
@DisallowConcurrentExecution
/*
更新JobDetail的JobDataMap的存储副本，以便下次执行同一作业（ JobDetail）接收更新的值，而不是原始存储的值。
如果使用@PersistJobDataAfterExecution批注，则应强烈考虑也使用 @DisallowConcurrentExecution批注，
以避免在同时执行同一作业（JobDetail）的两个实例时剩余哪些数据的可能的混淆（竞争条件）。
 */
@PersistJobDataAfterExecution
public class MyJob2 implements Job {

    /*
    通过JobFactory将数据映射值“注入”到您的类上
     */
    private String name;
    private int age;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(context.getJobDetail().getKey() + ", name=" + name + ", age=" + age + " " + new Date());
        context.getJobDetail().getJobDataMap().put("age", age + 1);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
