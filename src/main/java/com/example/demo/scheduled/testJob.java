package com.example.demo.scheduled;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 10:19 2018/6/19
 */
@Component
public class testJob {
    private Logger _log = LoggerFactory.getLogger(testJob.class);

//    @Scheduled(cron = "*/1 * * * * *")
    public void test1(){
        _log.info("进入 test1 job------------------------");
//        while (true){
//            Integer a = 1;
//            if(a == 2){
//                break;
//            }
//        }
        _log.info("test1 - " + System.currentTimeMillis());
        _log.info("离开 test1 job------------------------");
    }

//    @Scheduled(cron = "*/1 * * * * *")
//    public void test2(){
//        _log.info("test2 - " + System.currentTimeMillis());
//    }
//
//    @Scheduled(cron = "*/1 * * * * *")
//    public void test3(){
//        _log.info("test3 - " + System.currentTimeMillis());
//    }
//
//    @Scheduled(cron = "*/1 * * * * *")
//    public void test4(){
//        _log.info("test4 - " + System.currentTimeMillis());
//    }
//
//    @Scheduled(cron = "*/1 * * * * *")
//    public void test5(){
//        _log.info("test5 - " + System.currentTimeMillis());
//    }
//
//    @Scheduled(cron = "*/1 * * * * *")
//    public void test6(){
//        _log.info("test6 - " + System.currentTimeMillis());
//    }
//
//    @Scheduled(cron = "*/1 * * * * *")
//    public void test7(){
//        _log.info("test7 - " + System.currentTimeMillis());
//    }
//
//    @Scheduled(cron = "*/1 * * * * *")
//    public void test8(){
//        _log.info("test8 - " + System.currentTimeMillis());
//    }

}
