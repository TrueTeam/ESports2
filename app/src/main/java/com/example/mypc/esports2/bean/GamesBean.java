package com.example.mypc.esports2.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 2016/8/2.
 */
public class GamesBean {


    /**
     * id : 218
     * cover : a27387a66d5d880648d6dbaeaa2c6d86ea067d60
     * title : #悟空水友-卡拉赞之夜#切磋赛     * apply_start_time : 1470034800
     * apply_end_time : 1470454200
     * city : 0
     * type : 2
     * mtype : 2
     * start_time : 1470456000
     * end_time : 1470585600
     * city_name :
     * province_name :
     * issign : 1
     * match_nature : 1
     * match_address :
     * match_status : 2
     * haspassword : 0
     * cover_link : http://139.196.106.200/Uploads/Picture/2016-08-01/579f224698f4b.jpg
     */

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("apply_start_time")
    private String applyStartTime;
    @SerializedName("apply_end_time")
    private String applyEndTime;
    @SerializedName("city")
    private String city;
    @SerializedName("type")
    private String type;
    @SerializedName("mtype")
    private String mtype;
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("end_time")
    private String endTime;
    @SerializedName("city_name")
    private String cityName;
    @SerializedName("province_name")
    private String provinceName;
    @SerializedName("issign")
    private String issign;
    @SerializedName("match_nature")
    private String matchNature;
    @SerializedName("match_address")
    private String matchAddress;
    @SerializedName("match_status")
    private String matchStatus;
    @SerializedName("haspassword")
    private String haspassword;
    @SerializedName("cover_link")
    private String coverLink;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GamesBean(String id, String title,  String applyStartTime, String applyEndTime,String startTime, String endTime, String matchNature, String matchStatus, String coverLink) {
        this.id = id;
        this.title = title;
        this.applyStartTime = applyStartTime;
        this.applyEndTime = applyEndTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.matchNature = matchNature;
        this.matchStatus = matchStatus;
        this.coverLink = coverLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(String applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public String getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(String applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getIssign() {
        return issign;
    }

    public void setIssign(String issign) {
        this.issign = issign;
    }

    public String getMatchNature() {
        return matchNature;
    }

    public void setMatchNature(String matchNature) {
        this.matchNature = matchNature;
    }

    public String getMatchAddress() {
        return matchAddress;
    }

    public void setMatchAddress(String matchAddress) {
        this.matchAddress = matchAddress;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public String getHaspassword() {
        return haspassword;
    }

    public void setHaspassword(String haspassword) {
        this.haspassword = haspassword;
    }

    public String getCoverLink() {
        return coverLink;
    }

    public void setCoverLink(String coverLink) {
        this.coverLink = coverLink;
    }
}
