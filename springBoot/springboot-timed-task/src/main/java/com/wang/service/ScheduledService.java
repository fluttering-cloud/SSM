package com.wang.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //在一个特定的时间执行此任务

    //cron 表达式
    //秒 分 时 日 月 周几
    //cron = "* * * * * *"
    /*
      cron="0 0/5 9,18 * * *" : 每天10点和18点，每隔5分钟执行一次
       cron="0 5 9 * * 1-6" : 每个月的周一到周六的9点5分0秒执行一次
     */
    //cron表达式可以在百度上生成

    @Scheduled(cron="0 18 9 * * *") //每天9点18分0秒执行
    public void hello(){
       System.out.println("HelloScheduled");
   }

}
