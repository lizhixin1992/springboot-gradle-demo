package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 15:22 2018/6/15
 */
@RequestMapping("test")
@Controller
public class TestController {

    @RequestMapping("/")
    public String test(){
        return "hello world";
    }
}
