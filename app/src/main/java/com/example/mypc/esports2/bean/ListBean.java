package com.example.mypc.esports2.bean;

import com.google.gson.annotations.SerializedName;

public class ListBean {
    @SerializedName("id")
    private String id;
    @SerializedName("click")
    private String click;
    @SerializedName("title")
    private String title;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("is_home")
    private String isHome;
    @SerializedName("cover")
    private String cover;
    @SerializedName("description")
    private String description;
    @SerializedName("content")
    private String content;
    @SerializedName("keywords")
    private String keywords;
    @SerializedName("praise")
    private String praise;
    @SerializedName("comments")
    private String comments;
    @SerializedName("collect")
    private String collect;
    @SerializedName("ispraise")
    private String ispraise;
    @SerializedName("iscollect")
    private String iscollect;
    @SerializedName("cover_link")
    private String coverLink;

    public ListBean(String id, String click, String title, String createTime, String isHome, String cover, String content, String keywords, String praise, String comments, String collect, String ispraise, String iscollect, String coverLink) {
        this.id = id;
        this.click = click;
        this.title = title;
        this.createTime = createTime;
        this.isHome = isHome;
        this.cover = cover;
        this.content = content;
        this.keywords = keywords;
        this.praise = praise;
        this.comments = comments;
        this.collect = collect;
        this.ispraise = ispraise;
        this.iscollect = iscollect;
        this.coverLink = coverLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIsHome() {
        return isHome;
    }

    public void setIsHome(String isHome) {
        this.isHome = isHome;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getIspraise() {
        return ispraise;
    }

    public void setIspraise(String ispraise) {
        this.ispraise = ispraise;
    }

    public String getIscollect() {
        return iscollect;
    }

    public void setIscollect(String iscollect) {
        this.iscollect = iscollect;
    }

    public String getCoverLink() {
        return coverLink;
    }

    public void setCoverLink(String coverLink) {
        this.coverLink = coverLink;
    }
}