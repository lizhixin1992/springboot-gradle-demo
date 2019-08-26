package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.globalException.BaseException;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/delete")
    public String delete(){
        esService.delete();
        return "delete";
    }

    @RequestMapping("/callBack")
    public void callBack(@RequestBody String data){
        System.out.println(data);
    }

//    @RequestMapping("/query")
//    public ResponseEntity query(){
//
//        List<Map<String, Object>> list = new ArrayList<>();
//        JSONObject jsonObject = new JSONObject();
//        SearchResponse searchResponse = esService.pageQueryRequest("故事","中国","2018-10-01 00:00:00","2018-10-31 00:00:00",0,1000);
//        SearchHits hits= searchResponse.getHits();
//        for (SearchHit searchHit : hits) {
//            Map<String, Object> source = searchHit.getSourceAsMap();
//            String strings = searchHit.getSourceAsString();
//            list.add(source);
//        }
//        jsonObject.put("data",list);
//        jsonObject.put("size",list.size());
//        return new ResponseEntity(jsonObject, HttpStatus.OK);
//    }


    @GetMapping("/exce")
    public String showInfo(){
        try {
            String info ="你好";
            int a = 1/0;
            return info;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException.customerException("fail", 10001, "/test/exce 异常,异常信息:" + e.getMessage());
        }
    }
}
