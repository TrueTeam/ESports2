package com.example.mypc.esports2.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by peter on 2016/8/8.
 */
@DatabaseTable(tableName = "user")
public class UserBean {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String uid;
    @DatabaseField
    private String username;
    @DatabaseField
    private String password;
    @DatabaseField
    private String nickname;
    @DatabaseField
    private String sex;
    @DatabaseField
    private String age;
    @DatabaseField
    private String sign;
    @DatabaseField
    private String qq;
    @DatabaseField
    private String headimg;
    @DatabaseField
    private String fansuid;
    @DatabaseField
    private String insertuid;

    public UserBean() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getFansuid() {
        return fansuid;
    }

    public void setFansuid(String fansuid) {
        this.fansuid = fansuid;
    }

    public String getInsertuid() {
        return insertuid;
    }

    public void setInsertuid(String insertuid) {
        this.insertuid = insertuid;
    }
}
