package com.example.mypc.esports2.bean;

/**
 * Created by Administrator on 2016/8/10.
 */
public class CircleHotBean {
    /**
     * id : 9
     * title : LOL秋名山丿车神
     * logo : http://139.196.106.200/Uploads/Picture/2016-08-09/57a983bf7bd9a.png
     * description :
     * users : 19
     * posts : 7
     * is_open : 1
     * create_time : 1470726726
     * cname : 推荐
     */

    private String id;
    private String title;
    private String logo;
    private String description;
    private String users;
    private String posts;
    private String is_open;
    private String create_time;
    private String cname;

    public CircleHotBean(String id, String title, String logo, String description, String users, String posts, String is_open, String create_time, String cname) {
        this.id = id;
        this.title = title;
        this.logo = logo;
        this.description = description;
        this.users = users;
        this.posts = posts;
        this.is_open = is_open;
        this.create_time = create_time;
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

    public String getIs_open() {
        return is_open;
    }

    public void setIs_open(String is_open) {
        this.is_open = is_open;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
