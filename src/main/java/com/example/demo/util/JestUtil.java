package com.example.demo.util;


import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.searchbox.action.Action;
import io.searchbox.client.*;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.*;
import io.searchbox.indices.ClearCache;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.ForceMerge;
import io.searchbox.indices.aliases.AddAliasMapping;
import io.searchbox.indices.aliases.GetAliases;
import io.searchbox.indices.aliases.ModifyAliases;
import io.searchbox.indices.aliases.RemoveAliasMapping;
import io.searchbox.indices.mapping.GetMapping;
import io.searchbox.indices.mapping.PutMapping;
import io.searchbox.indices.settings.GetSettings;
import io.searchbox.indices.settings.UpdateSettings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;import io.searchbox.client.JestClient;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: liujiong <liu.jiong@chinaott.net>
 * @Date: 2018/10/23
 * @Description: es 6.4.2相关文档 https://www.elastic.co/guide/en/elasticsearch/reference/6.4/index.html
 */
@Slf4j
public class JestUtil {

    private static JestClient jestClient;
    private static String type = "_doc"; //索引类型

    private Logger logger = LoggerFactory.getLogger(JestUtil.class);

    static {
        JestClientFactory jestClientFactory = new JestClientFactory();
        jestClientFactory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .gson(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss").create())
                .connTimeout(3000)
                .readTimeout(3000)
                .multiThreaded(true)
                .build());
        jestClient = jestClientFactory.getObject();
    }

    /*********************** indices 相关操作*************************************/
    /**
     * 创建索引
     *
     * @param index
     * @param settings {"max_result_window":"10001","number_of_shards":"3"}
     * @param mappings {
     *                 "field1" : { "type" : "text" }
     *                 }
     * @return
     */
    public static boolean createIndex(String index, String settings, String mappings) {
        CreateIndex.Builder builder = new CreateIndex.Builder(index);

        JsonElement jsonElement = null;
        JsonObject settingsJson = new JsonObject();
        JsonObject mappingsJson = new JsonObject();
        //settings
        if (StringUtils.isNotBlank(settings)) {
            jsonElement = JsonUtil.fromJson(settings);
            settingsJson.add("index", jsonElement);
            builder.settings(settingsJson.toString());
        }

        //mappings
        if (StringUtils.isNotBlank(mappings)) {
            jsonElement = JsonUtil.fromJson(mappings);
            JsonObject propertiesJson = new JsonObject();
            propertiesJson.add("properties", jsonElement);
            mappingsJson.add(type, propertiesJson);
            builder.mappings(mappingsJson.toString());
        }

        CreateIndex createIndex = builder.build();
        try {
            JestResult jestResult = jestClient.execute(createIndex);
            log.info("createIndex index->" + index + " type->" + type + " settings->" + settingsJson.toString() + " mappings->" + mappingsJson.toString() + " result->{}", jestResult.getJsonString());
            return jestResult.isSucceeded();
        } catch (IOException e) {
            log.error("createIndex index->" + index + " type->" + type + " settings->" + settingsJson.toString() + " mappings->" + mappingsJson.toString() + " 失败", e);
            return false;
        }
    }

    /**
     * 删除索引
     *
     * @param index
     * @return
     */
    public static boolean deleteIndex(String index) {
        DeleteIndex deleteIndex = new DeleteIndex.Builder(index).build();
        try {
            JestResult jestResult = jestClient.execute(deleteIndex);
            log.info("deleteIndex index->" + index + " result->{}", jestResult.getJsonString());
            return jestResult.isSucceeded();
        } catch (IOException e) {
            log.error("deleteIndex index->" + index + " 失败", e);
            return false;
        }
    }

    /**
     * 设置索引mapping
     *
     * @param index
     * @param mapping 为拼接好的json格式的mapping串
     *                {
     *                "age":{
     *                "type": "text",
     *                "fields": {
     *                "keyword":{
     *                "type":"keyword"
     *                }
     *                }
     *                }
     *                }
     */
    public static boolean createIndexMapping(String index, String mapping) {
        JsonElement jsonElement = JsonUtil.fromJson(mapping);
        JsonObject propertiesJson = new JsonObject();
        propertiesJson.add("properties", jsonElement);

        PutMapping putMapping = new PutMapping.Builder(index, type, propertiesJson.toString()).build();
        try {
            JestResult jestResult = jestClient.execute(putMapping);
            log.info("createIndexMapping index->" + index + " type->" + type + " mapping->" + propertiesJson.toString() + " result->" + jestResult.getJsonString());
            return jestResult.isSucceeded();
        } catch (IOException e) {
            log.error("createIndexMapping index->" + index + " type->" + type + " mapping->" + propertiesJson.toString() + " 失败", e);
            return false;
        }
    }

    /**
     * 获取Mapping
     *
     * @param index
     * @return
     */
    public static JsonObject getMapping(String index) {
        JsonObject jsonObject = null;
        GetMapping getMapping = new GetMapping.Builder().addIndex(index).addType(type).build();
        try {
            JestResult jestResult = jestClient.execute(getMapping);
            if (jestResult != null && jestResult.isSucceeded()) {
                log.info("getMapping index->" + index + " type->" + type + " mapping->{}", jestResult.getJsonString());
                jsonObject = jestResult.getJsonObject();
            }
        } catch (IOException e) {
            log.error("getMapping index->" + index + " 失败", e);
        }
        return jsonObject;
    }

    /**
     * 索引settings
     *
     * @param index
     * @return
     */
    public static JsonObject getIndexSettings(String index) {
        JsonObject jsonObject = null;
        try {
            JestResult jestResult = jestClient.execute(new GetSettings.Builder().addIndex(index).build());
            if (jestResult != null && jestResult.isSucceeded()) {
                log.info("getIndexSettings index->" + index + " settings->{}", jestResult.getJsonString());
                jsonObject = jestResult.getJsonObject();
            }
        } catch (IOException e) {
            log.error("getIndexSettings index—>" + index + " 失败", e);
        }
        return jsonObject;
    }

    /**
     * 更新索引设置
     *
     * @param index
     * @param settings json格式字符串
     *                 {"max_result_window":"10001","number_of_replicas":"3"}
     * @return
     */
    public static boolean updateIndexSettings(String index, String settings) {
        JsonElement jsonElement = JsonUtil.fromJson(settings);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("index", jsonElement);
        try {
            JestResult jestResult = jestClient.execute(new UpdateSettings.Builder(jsonObject.toString()).addIndex(index).build());
            log.info("updateIndexSettings index->" + index + " source->" + jsonObject.toString() + " result->{}", jestResult.getJsonString());
            return jestResult.isSucceeded();
        } catch (IOException e) {
            log.error("updateIndexSettings index->" + index + " source->" + jsonObject.toString() + " 失败", e);
            return false;
        }
    }

    /**
     * 获取索引别名
     *
     * @param index
     * @return
     */
    public static JsonObject getIndexAliases(String index) {
        JsonObject jsonObject = null;
        GetAliases getAliases = new GetAliases.Builder().addIndex(index).build();
        try {
            JestResult jestResult = jestClient.execute(getAliases);
            if (jestResult != null && jestResult.isSucceeded()) {
                log.info("getIndexAliases index->" + index + " result->{}", jestResult.getJsonString());
                jsonObject = jestResult.getJsonObject();
            }
        } catch (IOException e) {
            log.error("getIndexAliases index->" + index + " 失败", e);
        }
        return jsonObject;
    }

    /**
     * 创建索引别名
     *
     * @param index
     * @param alias
     * @param filter { "term" : { "user" : "kimchy" } }
     * @return
     */
    public static boolean addAlias(String index, String alias, Map<String, Object> filter) {
        AddAliasMapping.Builder builder = new AddAliasMapping.Builder(index, alias);
        if (filter != null && filter.size() > 0) {
            builder.setFilter(filter);
        }
        try {
            JestResult jestResult = jestClient.execute(new ModifyAliases.Builder(builder.build()).build());
            log.info("addAlias index->" + index + " alias->" + alias + " filter->" + JsonUtil.toJson(filter) + " result->{}", jestResult.getJsonString());
            return jestResult.isSucceeded();
        } catch (IOException e) {
            log.error("addAlias index->" + index + " alias->" + alias + " filter->" + JsonUtil.toJson(filter), e);
            return false;
        }
    }

    /**
     * 删除索引别名
     *
     * @param index
     * @param alias
     * @return
     */
    public static boolean removeAlias(String index, String alias) {
        RemoveAliasMapping.Builder builder = new RemoveAliasMapping.Builder(index, alias);
        try {
            JestResult jestResult = jestClient.execute(new ModifyAliases.Builder(builder.build()).build());
            log.info("removeAlias index->" + index + " alias->" + alias + " result->{}", jestResult.getJsonString());
            return jestResult.isSucceeded();
        } catch (IOException e) {
            log.error("removeAlias index->" + index + " alias->" + alias, e);
            return false;
        }
    }


    /**
     * @param index
     * @param maxNumSegments     合并后分段个数
     * @param onlyExpungeDeletes 只对分段中已删除数据进行优化
     */
    public static void forceMerge(String index, Number maxNumSegments, boolean onlyExpungeDeletes) {
        ForceMerge.Builder builder = new ForceMerge.Builder();
        builder.addIndex(index);
        if (maxNumSegments != null) {
            builder.maxNumSegments(maxNumSegments);
        }
        if (onlyExpungeDeletes) {
            builder.onlyExpungeDeletes(onlyExpungeDeletes);
        }
        ForceMerge forceMerge = builder.build();
        jestClient.executeAsync(forceMerge, new JestResultHandler<JestResult>() {
            @Override
            public void completed(JestResult jestResult) {
                log.info("forcemerge index->" + index + " max_num_segments->" + maxNumSegments + " only_expunge_deletes->" + onlyExpungeDeletes + " result->{}", jestResult.getJsonString());
            }

            @Override
            public void failed(Exception e) {
                log.error("forcemerge index->" + index + " max_num_segments->" + maxNumSegments + " only_expunge_deletes->" + onlyExpungeDeletes, e);
            }
        });
    }

    /**
     * 清除缓存
     *
     * @param index
     * @return
     */
    public static boolean clearCache(String index) {
        ClearCache.Builder builder = new ClearCache.Builder();
        builder.addIndex(index);
        try {
            JestResult jestResult = jestClient.execute(builder.build());
            log.info("clearCache index->" + index + " result->{}", jestResult.getJsonString());
            return jestResult.isSucceeded();
        } catch (IOException e) {
            log.error("clearCache index->" + index, e);
            return false;
        }
    }

    /*********************** document 相关操作*************************************/

    /**
     * jestclient 统一执行方法
     *
     * @param action     执行的操作
     * @param index      索引
     * @param data       数据
     * @param methodName 方法名
     * @param <T>
     * @return
     */
    private static <T extends JestResult> boolean jestExecute(Action<T> action, String index, String data, String methodName) {
        StringBuffer logMessage = new StringBuffer(methodName + " index->" + index + " type->" + type);
        if (StringUtils.isNotBlank(data)) {
            logMessage.append(" data->" + data);
        }
        try {
            JestResult jestResult = jestClient.execute(action);
            log.info(logMessage.toString() + " result->{}", jestResult.getJsonString());
            return jestResult.isSucceeded();
        } catch (IOException e) {
            log.error(logMessage.toString() + " 异常", e);
            return false;
        }
    }

    /**
     * 索引文档
     *
     * @param index
     * @param t     实体类对象 或 map
     * @return
     */
    public static <T> boolean indexDoc(String index, T t,String id) {
        //默认实体类
        Index.Builder builder = new Index.Builder(t).index(index).type(type).id(id);
//        if (t instanceof Map) { // map
//            Map<String, Object> map = (Map<String, Object>) t;
//            Object id = map.get("id");
//            if (id != null && StringUtils.isNotBlank(id.toString())) {
//                builder.id(id.toString());
//            }
//        } else if (t instanceof String) { // jsonString
//            JsonObject jsonObject = JsonUtil.fromJson((String) t, JsonObject.class);
//            JsonElement id = jsonObject.get("id");
//            if (id != null && StringUtils.isNotBlank(id.getAsString())) {
//                builder.id(id.getAsString());
//            }
//        }
        return jestExecute(builder.build(), index, JsonUtil.toJson(t), "indexDoc 单条索引文档");
    }

    /**
     * 批量索引文档
     *
     * @param index
     * @param dataList 数据
     * @param <T>      map 或实体类
     * @return
     */
    public static <T> boolean bulkIndexDoc(String index, List<T> dataList) {
        if (dataList != null && dataList.size() > 0) {
            List<Index> indexList = new ArrayList<>();
            dataList.stream().forEach(t -> {
                Index.Builder builder = new Index.Builder(t);
                if (t instanceof Map) {
                    Map<String, Object> map = (Map<String, Object>) t;
                    Object id = map.get("id");
                    if (id != null && StringUtils.isNotBlank(id.toString())) {
                        builder.id(id.toString());
                    }
                }
                indexList.add(builder.build());
            });
            Bulk.Builder bulkBuilder = new Bulk.Builder().defaultIndex(index).defaultType(type).addAction(indexList);
            return jestExecute(bulkBuilder.build(), index, JsonUtil.toJson(dataList), "bulkIndexDoc 批量索引文档");
        } else {
            log.info("bulkIndexDoc index->" + index + " type->" + type + " 批量索引文档为空");
        }
        return false;
    }

    /**
     * 删除单条文档
     *
     * @param index
     * @param id
     * @return
     */
    public static boolean deleteDoc(String index, String id) {
        Delete.Builder builder = new Delete.Builder(id).index(index).type(type);
        return jestExecute(builder.build(), index, "{\"id\":" + id + "}", "deleteDoc 删除单条文档");
    }

    /**
     * 批量索引文档
     *
     * @param index
     * @param ids   数据
     * @return
     */
    public static boolean bulkDeleteDoc(String index, List<String> ids) {
        if (ids != null && ids.size() > 0) {
            List<Delete> deleteList = new ArrayList<>();
            ids.stream().forEach(id -> {
                Delete.Builder builder = new Delete.Builder(id);
                deleteList.add(builder.build());
            });
            Bulk.Builder bulkBuilder = new Bulk.Builder().defaultIndex(index).defaultType(type).addAction(deleteList);
            return jestExecute(bulkBuilder.build(), index, "ids==" + JsonUtil.toJson(ids), "bulkDeleteDoc 批量删除文档");
        } else {
            log.info("bulkDeleteDoc index->" + index + " type->" + type + " 批量删除文档为空");
        }
        return false;
    }

    /**
     * 通过查询条件删除
     *
     * @param index
     * @param query json 格式query 语句
     * @return
     */
    public static boolean deleteByQuery(String index, String query) {
        DeleteByQuery.Builder builder = new DeleteByQuery.Builder(query).addIndex(index).addType(type);
        return jestExecute(builder.build(), index, query, "deleteByQuery 通过查询条件删除");
    }

    /**
     * 更新单个文档
     *
     * @param index
     * @param id
     * @param json  格式数据
     *              {
     *              "doc" : {
     *              "name" : "new_name"
     *              }
     *              }
     *              或
     *              {
     *              "script" : "ctx._source.new_field = 'value_of_new_field'"
     *              }
     * @return
     */
    public static boolean updateDoc(String index, String id, String json) {
        Update.Builder builder = new Update.Builder(json).index(index).type(type).id(id);
        return jestExecute(builder.build(), index, "id==" + id + " json->" + json, "updateDoc 更新单个文档");
    }

    /**
     * 批量更新文档
     *
     * @param index
     * @param dataList map 或 json 格式string {"name" : "new_name"}
     * @param <T>
     * @return
     */
    public static <T> boolean bulkUpdateDoc(String index, List<T> dataList) {
        if (dataList != null && dataList.size() > 0) {
            List<Update> updateList = new ArrayList<>();
            dataList.stream().forEach(t -> {
                String jsonString = "";
                if (t instanceof Map) {
                    jsonString = JsonUtil.toJson(t);
                } else if (t instanceof String) {
                    jsonString = (String) t;
                } else {
                    log.error("bulkUpdateDoc index->" + index + " data->" + t.toString() + " 更新此文档失败，数据不是json格式字符串或map类型");
                }
                if (StringUtils.isNotBlank(jsonString)) {
                    JsonObject jsonObject = JsonUtil.fromJson(jsonString, JsonObject.class);
                    JsonElement id = jsonObject.get("id");
                    if (id == null || StringUtils.isBlank(id.getAsString())) {
                        log.info("bulkUpdateDoc index->" + index + " data->" + jsonString + " 更新此文档失败，id为空或不存在");
                    } else {
                        JsonObject docJson = new JsonObject();
                        docJson.add("doc", jsonObject);
                        Update.Builder builder = new Update.Builder(JsonUtil.toJson(docJson)).id(id.getAsString());
                        updateList.add(builder.build());
                    }
                }
            });
            Bulk.Builder builder = new Bulk.Builder().addAction(updateList).defaultIndex(index).defaultType(type);
            return jestExecute(builder.build(), index, JsonUtil.toJson(dataList), "bulkUpdateDoc 批量更新文档");
        }
        return false;
    }

    /**
     * 通过查询更新文档
     *
     * @param index
     * @param query json格式
     *              {\n" +
     *              "  \"script\": {\n" +
     *              "    \"source\": \"ctx._source.age += params.count\",\n" +
     *              "    \"lang\": \"painless\",\n" +
     *              "    \"params\": {\n" +
     *              "      \"count\":4\n" +
     *              "    }\n" +
     *              "  },\n" +
     *              "  \"query\": {\n" +
     *              "    \"term\": {\n" +
     *              "      \"user\": \"kimchy1\"\n" +
     *              "    }\n" +
     *              "  }\n" +
     *              "}
     * @return
     */
    public static boolean updateByQuery(String index, String query) {
        UpdateByQuery.Builder builder = new UpdateByQuery.Builder(query).addIndex(index).addType(type);
        return jestExecute(builder.build(), index, query, "updateByQuery 通过查询更新文档");
    }

    /**
     * 获取单个文档
     *
     * @param index
     * @param id
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getDoc(String index, String id, Class<T> clazz) {
        Get.Builder builder = new Get.Builder(index, id).type(type);
        try {
            JestResult jestResult = jestClient.execute(builder.build());
            log.info("getDoc index->" + index + " id->" + id + " result->{}", jestResult.getJsonString());
            return jestResult.getSourceAsObject(clazz);
        } catch (IOException e) {
            log.error("getDoc index->" + index + " id->" + id, e);
            return null;
        }
    }

    /**
     * 查询所有数据
     *
     * @param index
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> searchAll(String index, Class<T> clazz) {
        List<T> resultList = new ArrayList<>();

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        Search.Builder builder = new Search.Builder(searchSourceBuilder.toString()).addIndex(index).addType(type);
        try {
            SearchResult searchResult = jestClient.execute(builder.build());
            log.info("searchAll index->" + index + " type->" + type + " query->" + searchSourceBuilder.toString() + " total->" + searchResult.getTotal());
            resultList = searchResult.getSourceAsObjectList(clazz, false);
        } catch (IOException e) {
            log.error("searchAll index->" + index + " type->" + type + " query->" + searchSourceBuilder.toString());
        }
        return resultList;
    }

    /**
     * 通过query 语句查询
     *
     * @param index
     * @param query json格式query语句
     *              {\n" +
     *              "  \"query\": {\n" +
     *              "    \"term\": {\n" +
     *              "      \"user\": \"update7\"\n" +
     *              "    }\n" +
     *              "  }\n" +
     *              "}
     */
    public static <T> List<T> searchByQueryString(String index, String query, Class<T> clazz) {
        List<T> resultList = new ArrayList<>();

        Search.Builder builder = new Search.Builder(query).addIndex(index).addType(type);
        try {
            SearchResult searchResult = jestClient.execute(builder.build());
            log.info("searchByQueryString index->" + index + " type->" + type + " query->" + query + " total->" + searchResult.getTotal());
            resultList = searchResult.getSourceAsObjectList(clazz, false);
        } catch (IOException e) {
            log.error("searchByQueryString index->" + index + " type->" + type + " query->" + query, e);
        }
        return resultList;
    }

//    /**
//     * 分页查询
//     *
//     * @param index
//     * @param query json格式查询语句
//     *              {"query":
//     *              {\n" +
//     *              "    \"term\": {\n" +
//     *              "      \"user\": \"update7\"\n" +
//     *              "    }\n" +
//     *              "}
//     *              }
//     * @param <T>
//     * @return
//     */
//    public static <T> PageUtil<T> pageSearch(String index, String query, PageUtil<T> pageUtil,Class<T> clazz) {
//        if (pageUtil == null) {
//            log.info("pageSearch index->" + index + " type->" + type + " query->" + query + " 分页参数为空");
//            return null;
//        }
////        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
////        searchSourceBuilder.query(query);
////        searchSourceBuilder.from(pageUtil.start());
////        searchSourceBuilder.size(pageUtil.getSize());
////        searchSourceBuilder.sort(sortName, sortOrder);
//
//        Search.Builder builder = new Search.Builder(query).addIndex(index).addType(type);
//
//        try {
//            SearchResult searchResult = jestClient.execute(builder.build());
//            log.info("pageSearch index->" + index + " type->" + type + " query->" + query + " total->" + searchResult.getTotal());
//
//            pageUtil.setTotal(searchResult.getTotal());
//            pageUtil.setList(searchResult.getSourceAsObjectList(clazz,false));
//        } catch (IOException e) {
//            log.error("pageSearch index->" + index + " type->" + type + " query->" + query + " 分页查询失败",e);
//        }
//
//        return pageUtil;
//    }


    public static void main(String[] args) throws Exception {
    }
}
