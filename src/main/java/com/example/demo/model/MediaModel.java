package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

public class MediaModel implements Serializable {
    private Integer videoId;

    private Integer contentId;

    private Date createDate;

    private String fileType;

    private String md5;

    private String playUrl;

    private Integer accessId;

    private Integer type;

    private String uuid;

    private String bitrateStream;

    private String spId;

    private String srcFilePath;
    //加密key
    private String cryTokey;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl == null ? null : playUrl.trim();
    }

    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getBitrateStream() {
        return bitrateStream;
    }

    public void setBitrateStream(String bitrateStream) {
        this.bitrateStream = bitrateStream == null ? null : bitrateStream.trim();
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId == null ? null : spId.trim();
    }

    public String getSrcFilePath() {
        return srcFilePath;
    }

    public void setSrcFilePath(String srcFilePath) {
        this.srcFilePath = srcFilePath == null ? null : srcFilePath.trim();
    }

    public String getCryTokey() {
        return cryTokey;
    }

    public void setCryTokey(String cryTokey) {
        this.cryTokey = cryTokey;
    }
}