package com.example.demo.mq;

import com.example.demo.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 15:28 2018/6/19
 */
@Component
@RabbitListener(queues = "user")
public class UserReceiver {
    @RabbitHandler
    public void process(User user) {
        System.out.println("user receive  : " + user.getName()+"/"+user.getPass());
    }
}
