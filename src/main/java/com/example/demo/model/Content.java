package com.example.demo.model;

import com.alibaba.fastjson.JSONObject;
import io.searchbox.annotations.JestId;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @ClassName   Content
 * @Description 内容表
 * @Date 2018/11/14 7:22 PM
 **/
public class Content {

    @JestId
    private String id;

    private String title;

    private String subTitle;

    private String contentType;

    private String tags;

    private Long createDate;

    private String description;

    private Long duration;

    private Integer movieLevel;

    private String actors;

    private String year;

    private String area;

    private String director;

    private Object apps;

    public Content() {
        super();
    }

    public Content(ContentModel contentModel){
//        id = java.util.UUID.randomUUID().toString().replaceAll("-","");


        if(StringUtils.isNotEmpty(contentModel.getTitle())){
            title = contentModel.getTitle();
        }else{
            title = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getSubTitle())){
            subTitle = contentModel.getSubTitle();
        }else{
            subTitle = "";
        }

        contentType = "1001";

        if(StringUtils.isNotEmpty(contentModel.getTags())){
            tags = contentModel.getTags();
        }else{
            tags = "";
        }

        createDate = System.currentTimeMillis();

        if(StringUtils.isNotEmpty(contentModel.getDescription())){
            description = contentModel.getDescription();
        }else{
            description = "";
        }

        if(contentModel.getDuration() != null){
            duration = Long.getLong(contentModel.getDuration().toString());
        }else{
            duration = 0L;
        }

        if(contentModel.getMovieLevel() != null){
            movieLevel = contentModel.getMovieLevel();
        }else{
            movieLevel = 0;
        }


        if(StringUtils.isNotEmpty(contentModel.getActors())){
            actors = contentModel.getActors();
        }else{
            actors = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getAirtime())){
            year = contentModel.getAirtime();
        }else{
            year = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getArea())){
            area = contentModel.getArea();
        }else{
            area = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getDirector())){
            director = contentModel.getDirector();
        }else{
            director = "";
        }

        String category = "";
        switch (contentModel.getVideoType()){
            case "电影":
                category = "1000001";
                break;
            case "电视剧":
                category = "1000002";
                break;
            case "综艺":
                category = "1000004";
                break;
            case "体育":
                category = "1000006";
                break;
            case "资讯":
                category = "1000027";
                break;
            case "财经":
                category = "1000023";
                break;
            case "少儿":
                category = "1000024";
                break;
            case "教育":
                category = "1000007";
                break;
            case "动漫":
                category = "1000003";
                break;
            case "纪录片":
                category = "1000009";
                break;
            case "音乐":
                category = "1000005";
                break;
            case "汽车":
                category = "1000026";
                break;
            default:
                category = "1000013";
                break;
        }

        List<Object> appsList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appId", "com.newtv.cboxtv");
        jsonObject.put("contentId",contentModel.getContentId().toString());
        jsonObject.put("source", "newtv");
//        jsonObject.put("contentType", contentModel.getContentType() != null ? contentModel.getContentType() : "");
        jsonObject.put("definition", contentModel.getDefinition() != null ? contentModel.getDefinition() : 0L);
        jsonObject.put("grade", contentModel.getGrade());
        jsonObject.put("hImage", contentModel.gethImage() != null ? contentModel.gethImage() : "");
        jsonObject.put("vImage", contentModel.getvImage() != null ? contentModel.getvImage() : "");
        jsonObject.put("publishDate", contentModel.getPublishDate() != null ? contentModel.getPublishDate().getTime() : System.currentTimeMillis());
        jsonObject.put("copyRight", contentModel.getCopyright() != null ? contentModel.getCopyright() : "");
        jsonObject.put("copyRightId", contentModel.getCopyrightId() != null ? contentModel.getCopyrightId() : "");
        jsonObject.put("language", contentModel.getLanguage() != null ? contentModel.getLanguage() : "");
        jsonObject.put("vipFlag", contentModel.getMainVipFlag()==null?"":contentModel.getMainVipFlag());
        jsonObject.put("category", category);
        appsList.add(jsonObject);
        apps = appsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getMovieLevel() {
        return movieLevel;
    }

    public void setMovieLevel(Integer movieLevel) {
        this.movieLevel = movieLevel;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Object getApps() {
        return apps;
    }

    public void setApps(Object apps) {
        this.apps = apps;
    }
}