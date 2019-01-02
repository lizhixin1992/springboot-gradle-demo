package com.example.demo.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName
 * @Description cms内容实体
 * @Date 2018/12/12 9:25 AM
 **/
@Data
public class CmsContent {

    private String appKey;
    private String channelCode;
    private String mamId;
    private String definition;
    private String description;
    private String director;
    private String contentId;
    private String contentType;
    private String language;
    private String actors;
    private String leadingRolePinYin;
    private String name;
    private String pinYin;
    private String vImage;
    private Object classify;
    private Float grade;
    private String year;
    private String area;
    private String hImage;
    private String subtitle;
    private Long vipFlag;
    private String UUID;
    private Integer movieLevel;
    private Integer periods;
    private Integer drm;
//    private Integer recentNum;
//    private Integer isFinish;
    private Object category;
    private Integer duration;
    private Integer realExclusive;
    private Integer isExquisite;
    private String recentMsg;

    public CmsContent(){

    }
    public CmsContent(ContentModel content){
        this.appKey = "8acb5c18e56c1988723297b1a8dc9260";
        this.channelCode = "600001";
        this.mamId = content.getMamId();
        this.definition = content.getDefinition();
        this.description = content.getDescription();
        this.director = content.getDirector();
        this.contentId = content.getContentId() + "";
        this.contentType = content.getContentType();
        this.language = content.getLanguage();
        this.actors = content.getActors();
        this.leadingRolePinYin = null;
        this.name = content.getTitle();
        this.pinYin = content.getPinyin();
        this.vImage = content.getvImage();
        this.grade = content.getGrade();
        this.year = content.getAirtime();
        this.area = content.getArea();
        this.hImage = content.gethImage();
        this.subtitle = content.getSubTitle();
        this.vipFlag = 1L;
        this.UUID = content.getUuid();
        this.movieLevel = content.getMovieLevel();
        this.periods = 0;
        this.drm = content.getDrm();
//        this.recentNum = 0;
//        this.isFinish = 0;
        this.duration = content.getDuration();
        this.realExclusive = content.getRealExclusive();

        Map<String, String> classifymap = new HashMap<>();
        classifymap.put("first", content.getVideoClass());
        classifymap.put("second", content.getVideoType());
        this.classify = classifymap;


        Map<String, String> categorymap = new HashMap<>();
        categorymap.put("id", "1");
        categorymap.put("name", "1");
        this.category = categorymap;
        if(content.getIsExquisite() != null){
            this.isExquisite = content.getIsExquisite();
        }
        this.recentMsg = content.getRecentMsg();
    }
}