package com.example.mypc.esports2.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by peter on 2016/8/5.
 */
public class NewsDetailBean {

    /**
     * id : 2742
     * topic_id :
     * url_content :
     * url_id :
     * url_type :
     * click : 1493
     * click_back : 1439
     * cid : 0
     * cidstr : ,77,223,
     * mid : 00000000011
     * update_time : 1470357764
     * create_time : 1469840569
     * start_time : 0
     * end_time : 0
     * sort : 0
     * is_home : 0
     * status : 1
     * uid :
     * color :
     * top_pid : 0
     * title : [资讯]8月12日上线 新冒险卡拉赞之夜内容汇总
     * attachment :
     * format :
     * keywords : 卡拉赞
     * description :
     * account :
     * cover : b9d59e2ee7910ece0d1c05a2fd6ef2a36218aa21
     * address :
     * shopcartimg :
     * content : http://www.gvgcn.com/Home/ItemWap/info/id/2742
     * model_alias : article
     * model_title : 资讯
     * category_title :
     * pid : 0
     * praise : 2
     * comments : 4
     * collect : 0
     * hero_id : 0
     * to_hero_id : 0
     * relation_item :
     * member_mobile :
     * member_nickname :
     * member_head :
     * member_name :
     * ispraise : 0
     * iscollect : 0
     * cover_link : http://139.196.106.200/Uploads/Picture/2016-07-30/579bfee8045ed.jpg
     * member_head_link :
     */

    @SerializedName("id")
    private String id;
    @SerializedName("click")
    private String click;
    @SerializedName("click_back")
    private String clickBack;
    @SerializedName("cidstr")
    private String cidstr;
    @SerializedName("mid")
    private String mid;
    @SerializedName("update_time")
    private String updateTime;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("praise")
    private String praise;
    @SerializedName("comments")
    private String comments;
    @SerializedName("cover_link")
    private String coverLink;

    public NewsDetailBean(String id, String click, String clickBack, String cidstr, String mid, String updateTime, String createTime, String title, String content, String praise, String comments, String coverLink) {
        this.id = id;
        this.click = click;
        this.clickBack = clickBack;
        this.cidstr = cidstr;
        this.mid = mid;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.title = title;
        this.content = content;
        this.praise = praise;
        this.comments = comments;
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

    public String getClickBack() {
        return clickBack;
    }

    public void setClickBack(String clickBack) {
        this.clickBack = clickBack;
    }

    public String getCidstr() {
        return cidstr;
    }

    public void setCidstr(String cidstr) {
        this.cidstr = cidstr;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCoverLink() {
        return coverLink;
    }

    public void setCoverLink(String coverLink) {
        this.coverLink = coverLink;
    }
}
