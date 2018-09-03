package com.greentrust.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Job {

    // 这样就启动了一个定时的同步任务
    @Scheduled(cron = "0 0/1 * * * ?")
    public void timerToNow() throws  Exception {
        Thread.sleep(1000);
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /*
    *
    *fixedRate: 上一次 启动时间点之后 X秒执行一次
    *fixedDelay：上一次 结束时间点之后 每X秒执行一次
    *initialDelay：第一次延迟 X秒执行，之后按照fixedRate的规则每X秒执行
    * */

    @Scheduled(fixedRate=1000)
    public void testJob() throws Exception{
        Thread.sleep(1000);
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"------------fixedRate-----------");
    }
    @Scheduled(fixedDelay =1000)
    public void testJob2(){
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"------------fixedDelay -----------");
    }

    @Scheduled(initialDelay = 1000,fixedRate = 2000)
    public void testJob3(){
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"------------initialDelay = 50000,fixedRate = 6000 -----------");
    }
}
