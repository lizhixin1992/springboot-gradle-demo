package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 15:22 2018/6/15
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ESService esService;

    @RequestMapping("/save")
    public String save(){

        esService.save();
        return "save";
    }

    @RequestMapping("/query")
    public String query(){

        esService.pageQueryRequest("测试","","2018-10-01 00:00:00","2018-10-31 00:00:00",0,10);
        return "query";
    }
}
