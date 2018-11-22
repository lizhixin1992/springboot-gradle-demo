//package com.example.demo.util;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.demo.controller.RestClientFactory;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.common.unit.Fuzziness;
//import org.elasticsearch.common.unit.TimeValue;
//import org.elasticsearch.index.query.*;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.SearchHits;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.elasticsearch.search.sort.FieldSortBuilder;
//import org.elasticsearch.search.sort.SortBuilders;
//import org.elasticsearch.search.sort.SortOrder;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
///**
// * @ClassName
// * @Description TODO
// * @Date 2018/11/5 5:32 PM
// **/
//public class ESSearchUtil {
//
//    private static RestHighLevelClient client = RestClientFactory.getHighLevelClient();
//
//
//
//    /**
//     * @Description //TODO
//     * @Date 5:36 PM 2018/11/5
//     **/
//    public static SearchResponse pageQueryRequest(String keyword1, String keyword2, String startDate, String endDate,
//                                           int start, int size){
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
//
//
//
//    /**
//     * @Description 单个匹配（不分词查询 参数1： 字段名，参数2：字段查询值，因为不分词，所以汉字只能查询一个字，英语是一个单词.）
//     * @Date 5:47 PM 2018/11/5
//     **/
//    public static SearchResponse searchByTermQuery(String index, String type, String sortKey, String sortOrder, int start, int size,String fieldName, String keyword) throws Exception{
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.from(start);
//        sourceBuilder.size(size);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery(fieldName, keyword);
//        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
//        boolBuilder.must(termQueryBuilder);
//
//        sourceBuilder.sort(new FieldSortBuilder(sortKey).order(SortOrder.DESC));
//        sourceBuilder.query(boolBuilder);
//
//        SearchRequest searchRequest = new SearchRequest(index);
//        searchRequest.types(type);
//        searchRequest.source(sourceBuilder);
//        SearchResponse response = null;
//
//        response = client.search(searchRequest);
//        return response;
//    }
//
//
//    /**
//     * @Description 多个匹配（不分词查询 参数1： 字段名，参数2：字段查询值，因为不分词，所以汉字只能查询一个字，英语是一个单词.）
//     * @Date 6:27 PM 2018/11/5
//     **/
//    public static SearchResponse searchByTermQueryMore(String index, String type, String sortKey, String sortOrder, int start, int size,String fieldName, String... keyword) throws Exception{
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.from(start);
//        sourceBuilder.size(size);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery(fieldName, keyword);
//        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
//        boolBuilder.must(termsQueryBuilder);
//
//        sourceBuilder.sort(new FieldSortBuilder(sortKey).order(SortOrder.DESC));
//        sourceBuilder.query(boolBuilder);
//
//        SearchRequest searchRequest = new SearchRequest(index);
//        searchRequest.types(type);
//        searchRequest.source(sourceBuilder);
//        SearchResponse response = null;
//
//        response = client.search(searchRequest);
//        return response;
//    }
//
//
//    /**
//     * @Description 单个匹配（分词查询，采用默认分词器）
//     * @Date 8:56 AM 2018/11/6
//     **/
//    public static SearchResponse searchByMatchQuery(String index, String type, String sortKey, String sortOrder, int start, int size,String fieldName, String keyword) throws Exception{
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.from(start);
//        sourceBuilder.size(size);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(fieldName, keyword);
//        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
//        boolBuilder.must(matchQueryBuilder);
//
//        sourceBuilder.sort(new FieldSortBuilder(sortKey).order(SortOrder.DESC));
//        sourceBuilder.query(boolBuilder);
//
//        SearchRequest searchRequest = new SearchRequest(index);
//        searchRequest.types(type);
//        searchRequest.source(sourceBuilder);
//        SearchResponse response = null;
//
//        response = client.search(searchRequest);
//        return response;
//    }
//
//
//    /**
//     * @Description 多个fieldName匹配
//     * @Date 9:03 AM 2018/11/6
//     **/
//    public static SearchResponse searchByMultiMatchQuery(String index, String type, String sortKey, String sortOrder, int start, int size, String keyword,String... fieldName) throws Exception{
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.from(start);
//        sourceBuilder.size(size);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(keyword,fieldName);
//        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
//        boolBuilder.must(multiMatchQueryBuilder);
//
//        sourceBuilder.sort(new FieldSortBuilder(sortKey).order(SortOrder.DESC));
//        sourceBuilder.query(boolBuilder);
//
//        SearchRequest searchRequest = new SearchRequest(index);
//        searchRequest.types(type);
//        searchRequest.source(sourceBuilder);
//        SearchResponse response = null;
//
//        response = client.search(searchRequest);
//        return response;
//    }
//
//
//    /**
//     * @Description 匹配所有文件，相当于就没有设置查询条件
//     * @Date 9:12 AM 2018/11/6
//     **/
//    public static SearchResponse searchByMatchAllQuery(String index, String type, String sortKey, String sortOrder, int start, int size) throws Exception{
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.from(start);
//        sourceBuilder.size(size);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
//        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
//        boolBuilder.must(matchAllQueryBuilder);
//
//        sourceBuilder.sort(new FieldSortBuilder(sortKey).order(SortOrder.DESC));
//        sourceBuilder.query(boolBuilder);
//
//        SearchRequest searchRequest = new SearchRequest(index);
//        searchRequest.types(type);
//        searchRequest.source(sourceBuilder);
//        SearchResponse response = null;
//
//        response = client.search(searchRequest);
//        return response;
//    }
//
//
//    /**
//     * @Description 模糊查询
//     * @Date 9:19 AM 2018/11/6
//     **/
//    public static SearchResponse searchByFuzzyQuery(String index, String type, String sortKey, String sortOrder, int start, int size,String keyword,String fieldName) throws Exception{
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.from(start);
//        sourceBuilder.size(size);
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        //不能实现
////        QueryStringQueryBuilder queryStringQueryBuilder = QueryBuilders.queryStringQuery(keyword).field(fieldName);
//        //不能实现
////        MoreLikeThisQueryBuilder moreLikeThisQueryBuilder = QueryBuilders.moreLikeThisQuery(new String[]{"tags"},keyword,null);
//        //有问题，汉字一个以上查询不到数据，并且一个汉字的话，查询出来的数据也不是前缀匹配
////        PrefixQueryBuilder prefixQueryBuilder = QueryBuilders.prefixQuery(fieldName,keyword);
//        //有问题，汉字一个以上查询不到数据，并且一个汉字的话，可以查询出来数据
////        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery(fieldName,keyword);
//        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery(fieldName,keyword);
//
//        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
//        boolBuilder.must(wildcardQueryBuilder);
//
//
//
//
//        sourceBuilder.sort(new FieldSortBuilder(sortKey).order(SortOrder.DESC));
//        sourceBuilder.query(boolBuilder);
//
//        SearchRequest searchRequest = new SearchRequest(index);
//        searchRequest.types(type);
//        searchRequest.source(sourceBuilder);
//        SearchResponse response = null;
//
//        response = client.search(searchRequest);
//        return response;
//    }
//
//
//    public static void main(String[] args) {
//        try {
////            SearchResponse searchResponse = searchByTermQuery("icms.data","content","createDate","",0,100,"title","中");
////            SearchResponse searchResponse = searchByTermQueryMore("icms.data","content","createDate","",0,100,"title","中","故");
//            //多关键字分词查询
////            SearchResponse searchResponse = pageQueryRequest("故事","中国","2018-10-01 00:00:00","2018-10-31 00:00:00",0,1000);
////            SearchResponse searchResponse = searchByMatchQuery("icms.data","content","createDate","",0,100,"title","中");
////            SearchResponse searchResponse = searchByMultiMatchQuery("icms.data","content","createDate","",0,100,"美","title","tags","description");
////            SearchResponse searchResponse = searchByMatchAllQuery("icms.data","content","createDate","",0,100);
////            SearchResponse searchResponse = searchByFuzzyQuery("icms.data","content","createDate","",0,10,new String[]{"武警"});
////            SearchResponse searchResponse = searchByFuzzyQuery("icms.data","content","createDate","",0,10,"民歌","title");
////            SearchResponse searchResponse = searchByFuzzyQuery("icms.data","content","createDate","",0,10,"民歌","title");
//            SearchResponse searchResponse = searchByFuzzyQuery("icms.data","content","createDate","",0,10,"PG*","contentType");
//
//
//
//            List<Map<String, Object>> list = new ArrayList<>();
//            JSONObject jsonObject = new JSONObject();
//            SearchHits hits= searchResponse.getHits();
//            for (SearchHit searchHit : hits) {
//                Map<String, Object> source = searchHit.getSourceAsMap();
//                String strings = searchHit.getSourceAsString();
//                list.add(source);
//            }
//            jsonObject.put("data",list);
//            jsonObject.put("size",list.size());
//            System.out.println(jsonObject.toJSONString());
//            client.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}