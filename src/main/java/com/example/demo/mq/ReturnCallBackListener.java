//package com.example.demo.mq;
//
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
///**
// * @description:
// * @email:
// * @author: lizhixin
// * @createDate: 10:26 2018/6/20
// */
//@Component
//public class ReturnCallBackListener implements RabbitTemplate.ReturnCallback {
//    @Override
//    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//        System.out.println("收到回调");
//        System.out.println("return--message:" + new String(message.getBody()) + ",replyCode:" + replyCode + ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
//    }
//}
