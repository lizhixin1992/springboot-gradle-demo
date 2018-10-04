package com.example.demo.redisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RedisTest
 * @Description TODO
 * @Date 2018/10/3 下午5:24
 **/
@RestController
@RequestMapping("/redis")
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/setString", method = RequestMethod.GET)
    public void setString() throws Exception {
        redisUtils.set("redisUtil", "test");
    }

    @RequestMapping(value = "/getString", method = RequestMethod.GET)
    public void getString() throws Exception {
        System.out.println(redisUtils.get("redisUtil"));
    }
}