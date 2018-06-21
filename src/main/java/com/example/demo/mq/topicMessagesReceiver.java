package com.example.demo.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 16:17 2018/6/19
 */
@Component
@RabbitListener(queues = "topic.messages")
public class topicMessagesReceiver {
    @RabbitHandler
    public void process(String msg, Channel channel, Message message) {
//        System.out.println("topicMessagesReceiver  : " +msg);

        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//            System.out.println("receiver success");
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
//            System.out.println("receiver fail");
        }
    }
}
