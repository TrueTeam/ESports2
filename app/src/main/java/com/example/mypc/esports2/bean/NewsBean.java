package com.example.mypc.esports2.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by peter on 2016/8/2.
 */
public class NewsBean {

    /**
     * id : 2742
     * title : 8月12日上线 新冒险卡拉赞之夜内容汇总
     * cover : 32705a72cc832b674dd980eb668e7f3b55f27e29
     * link : http://139.196.106.200/Home/ItemWap/info/id/2742
     * cover_link : http://139.196.106.200/Uploads/Picture/2016-07-30/579bff22ed537.jpg
     */

    @SerializedName("ad")
    private List<AdBean> ad;
    /**
     * id : 2815
     * click : 1344
     * title : [资讯]欢迎参加夏季运动会
     * create_time : 1470191400
     * is_home : 0
     * cover : 76dadad155c0e6a64b241afd08e1124ffce18734
     * description :
     * content : http://www.gvgcn.com/Home/ItemWap/info/id/2815
     * keywords : 夏季运动会
     * praise : 2
     * comments : 3
     * collect : 0
     * ispraise : 0
     * iscollect : 0
     * tags : ["http://139.196.106.200/Uploads/Picture/2016-05-19/573d684d8a874.png"]
     * cover_link : http://139.196.106.200/Uploads/Picture/2016-08-03/57a159b57b4d7.jpg
     */

    @SerializedName("list")
    private List<ListBean> list;

    public NewsBean(List<AdBean> ad, List<ListBean> list) {
        this.ad = ad;
        this.list = list;
    }

    public List<AdBean> getAd() {
        return ad;
    }

    public void setAd(List<AdBean> ad) {
        this.ad = ad;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }


}
