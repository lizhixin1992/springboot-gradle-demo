package com.example.demo.mq;

import com.example.demo.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 15:27 2018/6/19
 */
@Component
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        User user=new User();
        user.setName("hzb");
        user.setPass("123456789");
        System.out.println("user send : " + user.getName()+"/"+user.getPass());
        this.rabbitTemplate.convertAndSend("user", user);
    }
}
