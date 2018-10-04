package com.example.demo.redisUtil;

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


    @RequestMapping(value = "/setString", method = RequestMethod.GET)
    public void setString() throws Exception {
        CacheUtils.set("redisUtil", "test",ExpireTime.NONE);
    }

    @RequestMapping(value = "/getString", method = RequestMethod.GET)
    public void getString() throws Exception {
        System.out.println(CacheUtils.getStr("redisUtil"));
    }
}