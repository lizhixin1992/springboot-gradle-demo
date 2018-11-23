package com.example.demo.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @ClassName Content
 * @Description 内容表
 * @Date 2018/11/14 7:22 PM
 **/
@Data
public class Content {

    private String title;

    private String subTitle;

    private String tags;

    private String contentType;

    private String definition;

    private String description;

    private String duration;

    private String grade;

    private String hImage;

    private String movieLevel;

    private String publishDate;

    private String vImage;

    private String copyRight;

    private String copyRightId;

    private String actors;

    private String year;

    private String area;

    private String director;

    private String language;

    private String vipFlag;

    private String category;

    private String appId;

    private String contentId;

    private String uri;

    public Content() {
        super();
    }

    public Content(ContentModel contentModel) {
//        id = java.util.UUID.randomUUID().toString().replaceAll("-","");


        if (StringUtils.isNotEmpty(contentModel.getTitle())) {
            title = contentModel.getTitle();
        } else {
            title = "";
        }

        if (StringUtils.isNotEmpty(contentModel.getSubTitle())) {
            subTitle = contentModel.getSubTitle();
        } else {
            subTitle = "";
        }

        contentType = "1001";

        if (StringUtils.isNotEmpty(contentModel.getTags())) {
            tags = contentModel.getTags();
        } else {
            tags = "";
        }

        if (StringUtils.isNotEmpty(contentModel.getDescription())) {
            description = contentModel.getDescription();
        } else {
            description = "";
        }

        if (contentModel.getDuration() != null) {
            duration = contentModel.getDuration() + "";
        } else {
            duration = "0";
        }

        if (contentModel.getMovieLevel() != null) {
            movieLevel = contentModel.getMovieLevel() + "";
        } else {
            movieLevel = "1";
        }


        if (StringUtils.isNotEmpty(contentModel.getActors())) {
            actors = contentModel.getActors();
        } else {
            actors = "";
        }

        if (StringUtils.isNotEmpty(contentModel.getAirtime())) {
            year = contentModel.getAirtime();
        } else {
            year = "";
        }

        if (StringUtils.isNotEmpty(contentModel.getArea())) {
            area = contentModel.getArea();
        } else {
            area = "";
        }

        if (StringUtils.isNotEmpty(contentModel.getDirector())) {
            director = contentModel.getDirector();
        } else {
            director = "";
        }

        switch (contentModel.getVideoType()) {
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

        appId = "com.newtv.cboxtv";
        contentId = contentModel.getContentId().toString();
        definition =  StringUtils.isNotEmpty(contentModel.getDefinition()) ? contentModel.getDefinition() : "SD";
        grade = contentModel.getGrade() != null ? contentModel.getGrade() + "" : "0";
        hImage = StringUtils.isNotEmpty(contentModel.gethImage()) ? contentModel.gethImage() : contentModel.getvImage();
        vImage = StringUtils.isNotEmpty(contentModel.getvImage()) ? contentModel.getvImage() : contentModel.gethImage();
        publishDate = contentModel.getPublishDate() != null ? contentModel.getPublishDate().getTime() + "" : System.currentTimeMillis() + "";
        copyRight = StringUtils.isNotEmpty(contentModel.getCopyright()) ? contentModel.getCopyright() : "";
        copyRightId = StringUtils.isNotEmpty(contentModel.getCopyrightId()) ? contentModel.getCopyrightId() : "";
        language = StringUtils.isNotEmpty(contentModel.getLanguage()) ? contentModel.getLanguage() : "普通话";
        vipFlag = "0".equals(contentModel.getMainVipFlag()) ? "2" : "1";
        uri = "";
    }

}