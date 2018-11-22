package com.example.demo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

/**
 * @Auther: liujiong <liu.jiong@chinaott.net>
 * @Date: 2018/10/30
 * @Description:
 */
public class JsonUtil {

    /**
     * Gson gson = new GsonBuilder()
     *          .excludeFieldsWithoutExposeAnnotation() //不对没有用@Expose注解的属性进行操作
     *          .enableComplexMapKeySerialization() //当Map的key为复杂对象时,需要开启该方法
     *          .serializeNulls() //当字段值为空或null时，依然对该字段进行转换
     *          .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS") //时间转化为特定格式
     *          .setPrettyPrinting() //对结果进行格式化，增加换行
     *          .disableHtmlEscaping() //防止特殊字符出现乱码
     *          .create();
     */

    /**
     * 转化为jJsonElement
     *
     * @param jsonString
     * @return
     */
    public static JsonElement fromJson(String jsonString) {
        Gson gson = new GsonBuilder().create();
        JsonElement jsonElement = gson.fromJson(jsonString, JsonElement.class);
        return jsonElement;
    }

    /**
     * 转化为对象
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String jsonString,Class<T> clazz) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString,clazz);
    }

    /**
     * 转化为json字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        String jsonString = "";
        if(object != null) {
            Gson gson = new GsonBuilder().create();
            jsonString = gson.toJson(object);
        }
        return jsonString;
    }

}
