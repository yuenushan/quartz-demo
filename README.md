## 项目介绍
quartz的学习

## 内容
### 关键API (摘自官方github)
1. Scheduler - the main API for interacting with the scheduler.
2. Job - an interface to be implemented by components that you wish to have executed by the scheduler.
3. JobDetail - used to define instances of Jobs.
4. Trigger - a component that defines the schedule upon which a given Job will be executed.
5. JobBuilder - used to define/build JobDetail instances, which define instances of Jobs.
6. TriggerBuilder - used to define/build Trigger instances.

### 其他重要API
1. JobDataMap - 如何在两次执行之间跟踪作业的状态
    * context.getJobDetail().getJobDataMap();
    * context.getTrigger().getJobDataMap();
    * context.getMergedJobDataMap(); 上述两个JobDataMap的合并，后者的值会覆盖前者的值。
2. ScheduleBuilder
3. Calendar
4. TriggerListener
5. JobListener - scheduler.getListenerManager().addJobListener(myJobListener, KeyMatcher.jobKeyEquals(new JobKey("myJobName", "myJobGroup")));
6. SchedulerListener    
7. JobStore - RAMJobStore, JDBCJobStore, TerracottaJobStore。后两种支持集群
8. SchedulerPlugin
    
### 常用注解
1. @DisallowConcurrentExecution
2. @PersistJobDataAfterExecution

### 触发器重要属性
1. Priority。- 当同一时刻，需要触发执行的job，多于工作线程时，优先级的优先执行。
2. Misfire Instructions

### 设计模式
显然JobDetail和Trigger和构建都是使用了建造者模式，可以看下源码看看quartz的建造者模式是怎么写的。
