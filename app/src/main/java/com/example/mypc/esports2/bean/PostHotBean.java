package com.example.mypc.esports2.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class PostHotBean {
    /**
     * id : 111
     * content : 最强阵容游戏规则说明
     * icon : http://139.196.106.200/Uploads/Picture/2016-07-15/5788b5fba6e45.png
     * pic : http://139.196.106.200/Uploads/Picture/2016-07-19/578df5f83bdb4.png
     * uid : 42571
     * nickname : 悟空电竞官方号
     * head : 858324e4ace585e5f56acc5e09b4e6fd221c42f2
     * praises : 1019
     * reviews : 20
     * tags : ["http://139.196.106.200/Uploads/Picture/2016-04-28/5722134b3fea8.png"]
     * create_time : 1468921391
     * circle_title : 英雄联盟开黑
     * is_praise : 0
     * pic_lists : ["http://139.196.106.200/Uploads/Picture/2016-07-19/578df5f83bdb4.png"]
     * head_link : http://139.196.106.200/Uploads/Picture/2016-07-18/578c3857756a7.png
     */

    private String id;
    private String content;
    private String icon;
    private String pic;
    private String uid;
    private String nickname;
    private String head;
    private String praises;
    private String reviews;
    private String create_time;
    private String circle_title;
    private String is_praise;
    private String head_link;
    private List<String> pic_lists;

    public PostHotBean(String id, String content, String icon, String pic, String uid, String nickname, String head, String praises, String reviews, String create_time, String circle_title, String is_praise, String head_link, List<String> pic_lists) {
        this.id = id;
        this.content = content;
        this.icon = icon;
        this.pic = pic;
        this.uid = uid;
        this.nickname = nickname;
        this.head = head;
        this.praises = praises;
        this.reviews = reviews;
        this.create_time = create_time;
        this.circle_title = circle_title;
        this.is_praise = is_praise;
        this.head_link = head_link;
        this.pic_lists = pic_lists;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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

    public String getPraises() {
        return praises;
    }

    public void setPraises(String praises) {
        this.praises = praises;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCircle_title() {
        return circle_title;
    }

    public void setCircle_title(String circle_title) {
        this.circle_title = circle_title;
    }

    public String getIs_praise() {
        return is_praise;
    }

    public void setIs_praise(String is_praise) {
        this.is_praise = is_praise;
    }

    public String getHead_link() {
        return head_link;
    }

    public void setHead_link(String head_link) {
        this.head_link = head_link;
    }


    public List<String> getPic_lists() {
        return pic_lists;
    }

    public void setPic_lists(List<String> pic_lists) {
        this.pic_lists = pic_lists;
    }
}
