package com.example.demo.model;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.CalendarUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @ClassName   Content
 * @Description 内容表
 * @Date 2018/11/14 7:22 PM
 **/
public class Content {

    private String id;

    private String title;

    private String subTitle;

    private String pinyin;

    private String tags;

    private String contentType;

    private String videoType;

    private String videoClass;

    private Long createDate;

    private Integer status;

    private String definition;

    private String description;

    private Long duration;

    private Float grade;

    private String hImage;

    private Integer movieLevel;

    private Long publishDate;

    private String vImage;

    private String copyRight;

    private String copyRightId;

    private String actors;

    private String airtime;

    private String area;

    private String director;

    private Integer seriesSum;

    private String language;

    private Integer recentNum;

    private Integer isFinish;

    private String vipFlag;

    private Object apps;

    public Content() {
        super();
    }

    public Content(ContentModel contentModel){
        id = java.util.UUID.randomUUID().toString().replaceAll("-","");


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

        if(StringUtils.isNotEmpty(contentModel.getPinyin())){
            pinyin = contentModel.getPinyin();
        }else{
            pinyin = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getTags())){
            tags = contentModel.getTags();
        }else{
            tags = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getContentType())){
            contentType = contentModel.getContentType();
        }else{
            contentType = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getVideoType())){
            videoType = contentModel.getVideoType();
        }else{
            videoType = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getVideoClass())){
            videoClass = contentModel.getVideoClass();
        }else{
            videoClass = "";
        }

        createDate = CalendarUtil.currentTimestamp().getTime();

        status = 1;

        if(StringUtils.isNotEmpty(contentModel.getDefinition())){
            definition = contentModel.getDefinition();
        }else{
            definition = "";
        }

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

        if(contentModel.getGrade() != null){
            grade = contentModel.getGrade();
        }else{
            grade = 0.0f;
        }

        if(StringUtils.isNotEmpty(contentModel.gethImage())){
            hImage = contentModel.gethImage();
        }else{
            hImage = "";
        }

        if(contentModel.getMovieLevel() != null){
            movieLevel = contentModel.getMovieLevel();
        }else{
            movieLevel = 0;
        }

        publishDate = contentModel.getPublishDate() == null ? CalendarUtil.currentTimestamp().getTime():contentModel.getPublishDate().getTime();

        if(StringUtils.isNotEmpty(contentModel.getvImage())){
            vImage = contentModel.getvImage();
        }else{
            vImage = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getCopyright())){
            copyRight = contentModel.getCopyright();
        }else{
            copyRight = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getCopyrightId())){
            copyRightId = contentModel.getCopyrightId();
        }else{
            copyRightId = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getActors())){
            actors = contentModel.getActors();
        }else{
            actors = "";
        }

        if(StringUtils.isNotEmpty(contentModel.getAirtime())){
            airtime = contentModel.getAirtime();
        }else{
            airtime = "";
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

        seriesSum = 0;

        if(StringUtils.isNotEmpty(contentModel.getLanguage())){
            language = contentModel.getLanguage();
        }else{
            language = "";
        }

        recentNum = 0;

        isFinish = 1;

        vipFlag = contentModel.getMainVipFlag()==null?"":contentModel.getMainVipFlag();

        List<Object> appsList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appId", "com.newtv.cboxtv");
        jsonObject.put("contentId",contentModel.getContentId());
        jsonObject.put("source", contentModel.getMamId());
        appsList.add(jsonObject);
        apps = appsList;
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

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoClass() {
        return videoClass;
    }

    public void setVideoClass(String videoClass) {
        this.videoClass = videoClass;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
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

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String gethImage() {
        return hImage;
    }

    public void sethImage(String hImage) {
        this.hImage = hImage;
    }

    public Integer getMovieLevel() {
        return movieLevel;
    }

    public void setMovieLevel(Integer movieLevel) {
        this.movieLevel = movieLevel;
    }

    public Long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Long publishDate) {
        this.publishDate = publishDate;
    }

    public String getvImage() {
        return vImage;
    }

    public void setvImage(String vImage) {
        this.vImage = vImage;
    }

    public String getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    public String getCopyRightId() {
        return copyRightId;
    }

    public void setCopyRightId(String copyRightId) {
        this.copyRightId = copyRightId;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getAirtime() {
        return airtime;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime;
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

    public Integer getSeriesSum() {
        return seriesSum;
    }

    public void setSeriesSum(Integer seriesSum) {
        this.seriesSum = seriesSum;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getRecentNum() {
        return recentNum;
    }

    public void setRecentNum(Integer recentNum) {
        this.recentNum = recentNum;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public String getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(String vipFlag) {
        this.vipFlag = vipFlag;
    }

    public Object getApps() {
        return apps;
    }

    public void setApps(Object apps) {
        this.apps = apps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}