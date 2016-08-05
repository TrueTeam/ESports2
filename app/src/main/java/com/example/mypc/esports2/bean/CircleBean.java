package com.example.mypc.esports2.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 强 on 2016/8/5.
 */
public class CircleBean {


    /**
     * id : 1
     * title : 英雄联盟开黑
     * logo : http://139.196.106.200/Uploads/Picture/2016-07-15/5788b5dcc87b5.png
     * description :
     * praises : 118
     * users : 3570
     * posts : 141
     * follows : 302
     * is_open : 1
     * create_time : 1468486719
     * cname : 推荐
     */

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("logo")
    private String logo;
    @SerializedName("description")
    private String description;
    @SerializedName("praises")
    private String praises;
    @SerializedName("users")
    private String users;
    @SerializedName("posts")
    private String posts;
    @SerializedName("follows")
    private String follows;
    @SerializedName("is_open")
    private String isOpen;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("cname")
    private String cname;

    public CircleBean(String id, String title, String logo, String description, String praises, String users, String posts, String follows, String isOpen, String createTime, String cname) {
        this.id = id;
        this.title = title;
        this.logo = logo;
        this.description = description;
        this.praises = praises;
        this.users = users;
        this.posts = posts;
        this.follows = follows;
        this.isOpen = isOpen;
        this.createTime = createTime;
        this.cname = cname;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPraises() {
        return praises;
    }

    public void setPraises(String praises) {
        this.praises = praises;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
    }

    public String getFollows() {
        return follows;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
