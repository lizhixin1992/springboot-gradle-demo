package com.example.demo.model;

import lombok.Data;

import java.util.*;

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
    private String tags;
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
    private String uuid;
    private Integer movieLevel;
//    private Integer periods;
    private Integer drm;
    private Object category;
    private Object secondCategory;
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
        this.tags = content.getTags();
        this.definition = content.getDefinition();
        this.description = content.getDescription();
        this.director = content.getDirector();
        this.contentId = content.getContentId() + "";
        this.contentType = content.getContentType();
        this.language = content.getLanguage();
        this.actors = content.getActors();
        this.name = content.getTitle();
        this.pinYin = content.getPinyin();
        this.vImage = content.getvImage();
        this.grade = content.getGrade();
        this.year = content.getAirtime();
        this.area = content.getArea();
        this.hImage = content.gethImage();
        this.subtitle = content.getSubTitle();
        this.vipFlag = 1L;
        this.uuid = content.getUuid();
        this.movieLevel = content.getMovieLevel();
        this.drm = content.getDrm();
        this.duration = content.getDuration();
        this.realExclusive = content.getRealExclusive();

        Map<String, String> classifymap = new HashMap<>();
        classifymap.put("first", content.getVideoType());
        classifymap.put("second", content.getVideoClass());
        this.classify = classifymap;

        Random random = new Random();
        List<Object> categoryList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, String> categorymap = new HashMap<>();
            categorymap.put("id", random.nextInt(1000) + "");
            categorymap.put("name", "CCTV");
            categoryList.add(categorymap);
        }
        this.category = categoryList;

        List<Object> secondCategoryList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, String> categorymap = new HashMap<>();
            categorymap.put("id", random.nextInt(1000) + "");
            categorymap.put("name", "CCTV-1");
            secondCategoryList.add(categorymap);
        }
        this.secondCategory = secondCategoryList;

        if(content.getIsExquisite() != null){
            this.isExquisite = content.getIsExquisite();
        }
        this.recentMsg = content.getRecentMsg();
    }
}