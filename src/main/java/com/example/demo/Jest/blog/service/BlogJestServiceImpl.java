package com.example.demo.Jest.blog.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Jest.blog.domain.Blog;
import com.example.demo.Jest.blog.param.SearchParam;
import com.example.demo.Jest.blog.query.BlogSearchRequest;

import com.example.demo.Jest.core.base.AbstractJestDataBaseService;
import com.example.demo.Jest.core.result.SmartSearchResult;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("blogJestService")
public class BlogJestServiceImpl extends AbstractJestDataBaseService<Blog> implements BlogJestService {

    @Resource
    private BlogSearchRequest blogSearchRequest;

    @Override
    public String buildIndexMapping(String type) {
        String mapping = "";
        XContentBuilder mapBuilder = null;
        try {
            mapBuilder = XContentFactory.jsonBuilder();
            mapBuilder.startObject()
                    .startObject(type)
                    .startObject("properties")
                    .startObject("id").field("type", "long").field("store", "true").endObject()
//                    设置分词
                    .startObject("title").field("type", "text").field("analyzer", "ik_max_word").endObject()
                    .startObject("content").field("type", "text").field("analyzer", "ik_max_word").field("store", "true").endObject()
//                    不分词
                    .startObject("author").field("type", "text").field("index", "false").endObject()
                    .startObject("tags").field("type", "text").field("index", "false").endObject()
                    .startObject("categroy").field("type", "text").field("index", "false").endObject()
                    .startObject("createTime").field("type", "long").field("index", "false").endObject()
                    .startObject("lastUpdateTime").field("type", "date").field("format", "yyyy-MM-dd HH:mm:ss").endObject()
                    .endObject()
                    .endObject()
                    .endObject();
            mapping = Strings.toString(mapBuilder);
            System.out.println(mapping);
        } catch (IOException e) {
            log.error("buildIndexMapping error", e);
        }
        return mapping;
    }

    @Override
    public SmartSearchResult<Blog> queryBySearchParam(SearchParam searchParam) {
        return blogSearchRequest.buildSearchRequest(searchParam);
    }
}
