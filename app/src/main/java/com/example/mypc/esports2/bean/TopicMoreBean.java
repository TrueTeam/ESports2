package com.example.mypc.esports2.bean;

/**
 * Created by Administrator on 2016/8/10.
 */
public class TopicMoreBean {
    /**
     * id : 51
     * title : 守望先锋朋友使用插件怎么处理
     * pic : http://139.196.106.200/Uploads/Picture/2016-08-08/57a8483189add.png
     * red_title : 支持正义
     * red_count : 42
     * blue_title : 支持躺赢
     * blue_count : 1
     * is_open : 1
     */

    private String id;
    private String title;
    private String pic;
    private String red_title;
    private String red_count;
    private String blue_title;
    private String blue_count;
    private String is_open;

    public TopicMoreBean(String id, String title, String pic, String red_title, String red_count, String blue_title, String blue_count, String is_open) {
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.red_title = red_title;
        this.red_count = red_count;
        this.blue_title = blue_title;
        this.blue_count = blue_count;
        this.is_open = is_open;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRed_title() {
        return red_title;
    }

    public void setRed_title(String red_title) {
        this.red_title = red_title;
    }

    public String getRed_count() {
        return red_count;
    }

    public void setRed_count(String red_count) {
        this.red_count = red_count;
    }

    public String getBlue_title() {
        return blue_title;
    }

    public void setBlue_title(String blue_title) {
        this.blue_title = blue_title;
    }

    public String getBlue_count() {
        return blue_count;
    }

    public void setBlue_count(String blue_count) {
        this.blue_count = blue_count;
    }

    public String getIs_open() {
        return is_open;
    }

    public void setIs_open(String is_open) {
        this.is_open = is_open;
    }
}
