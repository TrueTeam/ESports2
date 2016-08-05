package com.example.mypc.esports2.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by peter on 2016/8/5.
 */
public class CommentBean {

    /**
     * id : 2861
     * create_time : 1470357764
     * uid : 102862
     * nickname : 都督
     * head : afeb1864b48c64c4f1157f1a1c7c26ee4033acb0
     * content : 11111
     * praise : 0
     * content_text : 11111
     * has_parent : 0
     * parent_object : {"id":"0","uid":"0","nickname":"","head":"","content":"","create_time":"","head_link":""}
     * is_praise : 0
     * head_link : http://139.196.106.200/Uploads/Picture/2016-07-31/579cd78c71652.jpg
     */

    @SerializedName("id")
    private String id;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("uid")
    private String uid;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("head")
    private String head;
    @SerializedName("content")
    private String content;
    @SerializedName("praise")
    private String praise;
    @SerializedName("content_text")
    private String contentText;
    @SerializedName("has_parent")
    private String hasParent;
    @SerializedName("is_praise")
    private String isPraise;
    @SerializedName("head_link")
    private String headLink;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getHasParent() {
        return hasParent;
    }

    public void setHasParent(String hasParent) {
        this.hasParent = hasParent;
    }

    public String getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(String isPraise) {
        this.isPraise = isPraise;
    }

    public String getHeadLink() {
        return headLink;
    }

    public void setHeadLink(String headLink) {
        this.headLink = headLink;
    }
}
