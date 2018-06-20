package com.example.demo.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 14:45 2018/6/19
 */

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender2 helloSender2;
    @Autowired
    private UserSender userSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private CallBackSender callBackSender;

    @RequestMapping("/hello")
    public void hello() {
        helloSender1.send();
    }

    /**
     * 单生产者-多消费者
     */
    @RequestMapping("/oneToMany")
    public void oneToMany() {
        for(int i=0;i<10;i++){
            helloSender1.send("hellomsg:"+i);
        }
    }

    /**
     * 多生产者-多消费者
     */
    @RequestMapping("/manyToMany")
    public void manyToMany() {
        for(int i=0;i<10;i++){
            helloSender1.send("hellomsg:"+i);
            helloSender2.send("hellomsg:"+i);
        }
    }

    /**
     * 实体类传输测试
     */
    @RequestMapping("/userTest")
    public void userTest() {
        userSender.send();
    }

    /**
     * topic exchange类型rabbitmq测试
     */
    @RequestMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }

    /**
     * fanout exchange类型rabbitmq测试
     */
    @RequestMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }

    /**
     * publisher-confirms: true
     * 这个设置是对于exchange，当到达exchange后会返回ack=true，如果有标志的话会同时返回
     * 如果消息没有到exchange,则confirm回调,ack=false
     * 如果消息到达exchange,则confirm回调,ack=true
     */
    @RequestMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }
}
