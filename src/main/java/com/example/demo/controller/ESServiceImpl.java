package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.ContentMapper;
import com.example.demo.model.Content;
import com.example.demo.model.ContentModel;
import com.example.demo.util.CalendarUtil;
import com.example.demo.util.OkHttpUtil;
import okhttp3.Response;
import com.example.demo.util.JestUtil;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName
 * @Description TODO
 * @Date 2018/11/2 2:17 PM
 **/
@Service
public class ESServiceImpl implements ESService{

//    @Autowired
//    private ESRepository esRepository;

    @Autowired
    private ContentMapper contentMapper;

//    @Override
//    public Object get() {
//        BoolQueryBuilder builder = QueryBuilders.boolQuery();
//
//        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
//
//        nativeSearchQueryBuilder.withQuery(builder);
//
//        NativeSearchQuery query = nativeSearchQueryBuilder.build();
//        Page<ContentModel> page = esRepository.search(query);
//        return page;
//    }

    @Override
    public void save() {
        List<ContentModel> list = contentMapper.selectAllModel();
        System.out.println(list.size());

        for (ContentModel contentModel : list) {
            Content esContent = new Content(contentModel);

//            try {
//                Response response = OkHttpUtil.postJson("http://localhost:8080/test/save", JSONObject.toJSONString(esContent));
//                System.out.println(response.toString());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }


            try {
                JestUtil.indexDoc("content.test", esContent, UUID.randomUUID().toString().replaceAll("-",""));
            } catch (Exception e) {
                e.printStackTrace();
//                continue;
            }
        }
    }

//    @Override
//    public SearchResponse pageQueryRequest(String keyword1, String keyword2, String startDate, String endDate,
//                                           int start, int size){
//        RestHighLevelClient client = RestClientFactory.getHighLevelClient();
//
//        // 这个sourcebuilder就类似于查询语句中最外层的部分。包括查询分页的起始，
//        // 查询语句的核心，查询结果的排序，查询结果截取部分返回等一系列配置
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        // 结果开始处
//        sourceBuilder.from(start);
//        // 查询结果终止处
//        sourceBuilder.size(size);
//        // 查询的等待时间
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//        MatchQueryBuilder matchbuilder;
//        //在field为name的中查询
//        matchbuilder = QueryBuilders.matchQuery("title", keyword1+" "+keyword2);
////        matchbuilder = QueryBuilders.matchQuery("title", keyword1);
//        // 同时满足两个关键字
//        matchbuilder.operator(Operator.AND);
//        // 查询在时间区间范围内的结果
//        RangeQueryBuilder rangbuilder = QueryBuilders.rangeQuery("createDate");
//        if(!"".equals(startDate)){
//            rangbuilder.gte(CalendarUtil.parseCalendar(startDate).getTimeInMillis());
//        }
//        if(!"".equals(endDate)){
//            rangbuilder.lte(CalendarUtil.parseCalendar(endDate).getTimeInMillis());
//        }
//        // 等同于bool，将两个查询合并
//        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
//        boolBuilder.must(matchbuilder);
//        boolBuilder.must(rangbuilder);
//        // 排序
//        FieldSortBuilder fsb = SortBuilders.fieldSort("createDate");
//        fsb.order(SortOrder.DESC);
//        sourceBuilder.sort(fsb);
//        sourceBuilder.query(boolBuilder);
//        //System.out.println(sourceBuilder);
//        SearchRequest searchRequest = new SearchRequest("icms.data");
//        searchRequest.types("content");
//        searchRequest.source(sourceBuilder);
//        SearchResponse response = null;
//        try {
//            response = client.search(searchRequest);
//            SearchHits hits= response.getHits();
//            int totalRecordNum= (int) hits.getTotalHits();
//            for (SearchHit searchHit : hits) {
//                Map<String, Object> source = searchHit.getSourceAsMap();
//                String strings = searchHit.getSourceAsString();
//                System.out.println(source);
//                System.out.println(strings);
//            }
//            return response;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
////            client.close();
//        }
//
//        return response;
//    }
}