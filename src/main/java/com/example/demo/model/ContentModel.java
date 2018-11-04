package com.example.demo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(indexName = "icms.data",type = "content")
public class ContentModel implements Serializable {

    @Id
    private Integer contentId;

    private String mamId;

    private String uuid;

    private String title;

    private String subTitle;

//    private Integer weight;

    private String pinyin;

    private String tags;

    private String contentType;

    private String videoType;

    private String videoClass;

//    private String mainCategory;

//    private String categorys;

    @Field(fielddata = true)
    private Date createDate;

    private Integer status;

    private Integer createUserId;

    private String createUserName;

    private String definition;

    private Integer duration;

    private Float grade;

    private String hImage;

//    private Integer lSubScript;

//    private Integer lSuperScript;

    private Integer movieLevel;

    private Date offlineDate;

    private Date publishDate;

//    private Integer rSubScript;

//    private Integer rSuperScript;

    private Integer siteId;

    private String vImage;

    private String copyright;

    private String copyrightId;

    private String actors;

    private String airtime;

    private Integer payStatus;

    private Integer isCanSearch;

    private String bidType;

    private Integer drm;

    private String area;

    private Integer deleteFlag;

    private String director;

    private Date lastModifiedDate;

    private Integer lastModifiedUserId;

    private Integer subCount;

    private Integer seriesSum;

    private String description;

//    分发渠道号,多个ID用分号分割 如：;1;2;3;4;
    private String distributeChannelIds;
//    已完成分发渠道号,多个ID用分号分割 如：;1;2;3;
    private String finishDistributeChannelIds;
//    主产品包ID
    private String mainProductId;
//    主产品包类型
    private String mainVipFlag;
//    各渠道产品包信息，包括产品包类型和产品包ID{[channelId:xxx,vipFlag:xxx,productId:xxx]}
    private String channelProduct;

    private String language;
    //real_exclusive 角标 0:未设置，1:独播 2:腾讯出品 3:会员独家
    private Integer realExclusive;
    // 扩展表对象
    private Object extendObject;
    // 内容为节目时 媒体信息
    private List<MediaModel> medias;
    
    private String outId;
    
    private String crClassId;
    
    private String ppvCode;
    
    private String dataProvider;
    
    private String publishPlatformIds;
    
    private String finishPlatformIds;
    
    private String cpId;
    
    private String filmCpId;
    

    //栏目内容表中的排序字段
    private Integer sort;

    private Integer isExquisite;

    //显示用 一级栏目id
    private Integer firstCategoryId;
    //显示用 一级栏目标题
    private String firstCategoryTitle;
    //显示用 二级栏目id
    private Integer secondCategoryId;
    //显示用 二级栏目标题
    private String secondCategoryTitle;

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getMamId() {
        return mamId;
    }

    public void setMamId(String mamId) {
        this.mamId = mamId == null ? null : mamId.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType == null ? null : videoType.trim();
    }

    public String getVideoClass() {
        return videoClass;
    }

    public void setVideoClass(String videoClass) {
        this.videoClass = videoClass == null ? null : videoClass.trim();
    }

    /*
    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory == null ? null : mainCategory.trim();
    }

    public String getCategorys() {
        return categorys;
    }

    public void setCategorys(String categorys) {
        this.categorys = categorys == null ? null : categorys.trim();
    }
    */
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition == null ? null : definition.trim();
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
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
        this.hImage = hImage == null ? null : hImage.trim();
    }

    public Integer getMovieLevel() {
        return movieLevel;
    }

    public void setMovieLevel(Integer movieLevel) {
        this.movieLevel = movieLevel;
    }

    public Date getOfflineDate() {
        return offlineDate;
    }

    public void setOfflineDate(Date offlineDate) {
        this.offlineDate = offlineDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getvImage() {
        return vImage;
    }

    public void setvImage(String vImage) {
        this.vImage = vImage == null ? null : vImage.trim();
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright == null ? null : copyright.trim();
    }

    public String getCopyrightId() {
        return copyrightId;
    }

    public void setCopyrightId(String copyrightId) {
        this.copyrightId = copyrightId == null ? null : copyrightId.trim();
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors == null ? null : actors.trim();
    }

    public String getAirtime() {
        return airtime;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime == null ? null : airtime.trim();
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getIsCanSearch() {
        return isCanSearch;
    }

    public void setIsCanSearch(Integer isCanSearch) {
        this.isCanSearch = isCanSearch;
    }

    public String getBidType() {
        return bidType;
    }

    public void setBidType(String bidType) {
        this.bidType = bidType == null ? null : bidType.trim();
    }

    public Integer getDrm() {
        return drm;
    }

    public void setDrm(Integer drm) {
        this.drm = drm;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getLastModifiedUserId() {
        return lastModifiedUserId;
    }

    public void setLastModifiedUserId(Integer lastModifiedUserId) {
        this.lastModifiedUserId = lastModifiedUserId;
    }

    public Integer getSubCount() {
        return subCount;
    }

    public void setSubCount(Integer subCount) {
        this.subCount = subCount;
    }

    public Integer getSeriesSum() {
        return seriesSum;
    }

    public void setSeriesSum(Integer seriesSum) {
        this.seriesSum = seriesSum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDistributeChannelIds() {
        return distributeChannelIds;
    }

    public void setDistributeChannelIds(String distributeChannelIds) {
        this.distributeChannelIds = distributeChannelIds;
    }

    public String getFinishDistributeChannelIds() {
        return finishDistributeChannelIds;
    }

    public void setFinishDistributeChannelIds(String finishDistributeChannelIds) {
        this.finishDistributeChannelIds = finishDistributeChannelIds;
    }

    public String getMainProductId() {
        return mainProductId;
    }

    public void setMainProductId(String mainProductId) {
        this.mainProductId = mainProductId;
    }

    public String getMainVipFlag() {
        return mainVipFlag;
    }

    public void setMainVipFlag(String mainVipFlag) {
        this.mainVipFlag = mainVipFlag;
    }

    public String getChannelProduct() {
        return channelProduct;
    }

    public void setChannelProduct(String channelProduct) {
        this.channelProduct = channelProduct;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getRealExclusive() {
        return realExclusive;
    }

    public void setRealExclusive(Integer realExclusive) {
        this.realExclusive = realExclusive;
    }

    public Object getExtendObject() {
        return extendObject;
    }

    public void setExtendObject(Object extendObject) {
        this.extendObject = extendObject;
    }

    public List<MediaModel> getMedias() {
        return medias;
    }

    public void setMedias(List<MediaModel> medias) {
        this.medias = medias;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (ContentModel)super.clone();
    }

	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}

	public String getCrClassId() {
		return crClassId;
	}

	public void setCrClassId(String crClassId) {
		this.crClassId = crClassId;
	}

	public String getPpvCode() {
		return ppvCode;
	}

	public void setPpvCode(String ppvCode) {
		this.ppvCode = ppvCode;
	}

	public String getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(String dataProvider) {
		this.dataProvider = dataProvider;
	}

	public String getPublishPlatformIds() {
		return publishPlatformIds;
	}

	public void setPublishPlatformIds(String publishPlatformIds) {
		this.publishPlatformIds = publishPlatformIds;
	}

	public String getFinishPlatformIds() {
		return finishPlatformIds;
	}

	public void setFinishPlatformIds(String finishPlatformIds) {
		this.finishPlatformIds = finishPlatformIds;
	}

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public String getFilmCpId() {
		return filmCpId;
	}

	public void setFilmCpId(String filmCpId) {
		this.filmCpId = filmCpId;
	}

    public Integer getIsExquisite() {
        return isExquisite;
    }

    public void setIsExquisite(Integer isExquisite) {
        this.isExquisite = isExquisite;
    }

    public Integer getFirstCategoryId() {
        return firstCategoryId;
    }

    public void setFirstCategoryId(Integer firstCategoryId) {
        this.firstCategoryId = firstCategoryId;
    }

    public String getFirstCategoryTitle() {
        return firstCategoryTitle;
    }

    public void setFirstCategoryTitle(String firstCategoryTitle) {
        this.firstCategoryTitle = firstCategoryTitle;
    }

    public Integer getSecondCategoryId() {
        return secondCategoryId;
    }

    public void setSecondCategoryId(Integer secondCategoryId) {
        this.secondCategoryId = secondCategoryId;
    }

    public String getSecondCategoryTitle() {
        return secondCategoryTitle;
    }

    public void setSecondCategoryTitle(String secondCategoryTitle) {
        this.secondCategoryTitle = secondCategoryTitle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"contentId\":")
                .append(contentId);
        sb.append(",\"mamId\":\"")
                .append(mamId).append('\"');
        sb.append(",\"uuid\":\"")
                .append(uuid).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"subTitle\":\"")
                .append(subTitle).append('\"');
        sb.append(",\"pinyin\":\"")
                .append(pinyin).append('\"');
        sb.append(",\"tags\":\"")
                .append(tags).append('\"');
        sb.append(",\"contentType\":\"")
                .append(contentType).append('\"');
        sb.append(",\"videoType\":\"")
                .append(videoType).append('\"');
        sb.append(",\"videoClass\":\"")
                .append(videoClass).append('\"');
        sb.append(",\"createDate\":\"")
                .append(createDate).append('\"');
        sb.append(",\"status\":")
                .append(status);
        sb.append(",\"createUserId\":")
                .append(createUserId);
        sb.append(",\"createUserName\":\"")
                .append(createUserName).append('\"');
        sb.append(",\"definition\":\"")
                .append(definition).append('\"');
        sb.append(",\"duration\":")
                .append(duration);
        sb.append(",\"grade\":")
                .append(grade);
        sb.append(",\"hImage\":\"")
                .append(hImage).append('\"');
        sb.append(",\"movieLevel\":")
                .append(movieLevel);
        sb.append(",\"offlineDate\":\"")
                .append(offlineDate).append('\"');
        sb.append(",\"publishDate\":\"")
                .append(publishDate).append('\"');
        sb.append(",\"siteId\":")
                .append(siteId);
        sb.append(",\"vImage\":\"")
                .append(vImage).append('\"');
        sb.append(",\"copyright\":\"")
                .append(copyright).append('\"');
        sb.append(",\"copyrightId\":\"")
                .append(copyrightId).append('\"');
        sb.append(",\"actors\":\"")
                .append(actors).append('\"');
        sb.append(",\"airtime\":\"")
                .append(airtime).append('\"');
        sb.append(",\"payStatus\":")
                .append(payStatus);
        sb.append(",\"isCanSearch\":")
                .append(isCanSearch);
        sb.append(",\"bidType\":\"")
                .append(bidType).append('\"');
        sb.append(",\"drm\":")
                .append(drm);
        sb.append(",\"area\":\"")
                .append(area).append('\"');
        sb.append(",\"deleteFlag\":")
                .append(deleteFlag);
        sb.append(",\"director\":\"")
                .append(director).append('\"');
        sb.append(",\"lastModifiedDate\":\"")
                .append(lastModifiedDate).append('\"');
        sb.append(",\"lastModifiedUserId\":")
                .append(lastModifiedUserId);
        sb.append(",\"subCount\":")
                .append(subCount);
        sb.append(",\"seriesSum\":")
                .append(seriesSum);
        sb.append(",\"description\":\"")
                .append(description).append('\"');
        sb.append(",\"distributeChannelIds\":\"")
                .append(distributeChannelIds).append('\"');
        sb.append(",\"finishDistributeChannelIds\":\"")
                .append(finishDistributeChannelIds).append('\"');
        sb.append(",\"mainProductId\":\"")
                .append(mainProductId).append('\"');
        sb.append(",\"mainVipFlag\":\"")
                .append(mainVipFlag).append('\"');
        sb.append(",\"channelProduct\":\"")
                .append(channelProduct).append('\"');
        sb.append(",\"language\":\"")
                .append(language).append('\"');
        sb.append(",\"realExclusive\":")
                .append(realExclusive);
        sb.append(",\"extendObject\":")
                .append(extendObject);
        sb.append(",\"medias\":")
                .append(medias);
        sb.append(",\"outId\":\"")
                .append(outId).append('\"');
        sb.append(",\"crClassId\":\"")
                .append(crClassId).append('\"');
        sb.append(",\"ppvCode\":\"")
                .append(ppvCode).append('\"');
        sb.append(",\"dataProvider\":\"")
                .append(dataProvider).append('\"');
        sb.append(",\"publishPlatformIds\":\"")
                .append(publishPlatformIds).append('\"');
        sb.append(",\"finishPlatformIds\":\"")
                .append(finishPlatformIds).append('\"');
        sb.append(",\"cpId\":\"")
                .append(cpId).append('\"');
        sb.append(",\"filmCpId\":\"")
                .append(filmCpId).append('\"');
        sb.append(",\"sort\":")
                .append(sort);
        sb.append(",\"isExquisite\":")
                .append(isExquisite);
        sb.append(",\"firstCategoryId\":")
                .append(firstCategoryId);
        sb.append(",\"firstCategoryTitle\":\"")
                .append(firstCategoryTitle).append('\"');
        sb.append(",\"secondCategoryId\":")
                .append(secondCategoryId);
        sb.append(",\"secondCategoryTitle\":\"")
                .append(secondCategoryTitle).append('\"');
        sb.append('}');
        return sb.toString();
    }

}
