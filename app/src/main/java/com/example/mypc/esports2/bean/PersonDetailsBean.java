package com.example.mypc.esports2.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MyPC on 2016/8/5.
 */
public class PersonDetailsBean {

    /**
     * id : 101685
     * nickname : mini酱
     * sign :
     * head : d38e68a18a22f7c8ebcd9d2916319f41604702e3
     * mygames : []
     * head_list : d38e68a18a22f7c8ebcd9d2916319f41604702e3
     * mobile : 1234****956
     * sex : 1
     * age : 0
     * last_login_time : 24506653
     * distance : 0
     * follow_count : 0
     * fans_count : 2
     * groups : []
     * teams : []
     * activity : []
     * match : []
     * isfriend : 0
     * tags : []
     * role_list : []
     * posts : [{"id":"509","uid":"101685","content":"这工作好危险~","pic":"http://139.196.106.200/Uploads/Picture/2016-08-03/57a1a0b6e8f9e.jpg","praises":"3","reviews":"0","create_time":"1470210252","tags":[],"nickname":"mini酱","head":"d38e68a18a22f7c8ebcd9d2916319f41604702e3","mobile":"12345678956","circle_title":"树洞杂谈","icon":"http://139.196.106.200/Uploads/Picture/2016-07-15/5788d61dce93d.jpg","is_praise":"0","pic_lists":["http://139.196.106.200/Uploads/Picture/2016-08-03/57a1a0b6e8f9e.jpg"],"head_link":"http://139.196.106.200/Uploads/Picture/2016-07-26/5797268894090.jpg"}]
     * head_link : http://139.196.106.200/Uploads/Picture/2016-07-26/5797268894090.jpg
     * head_list_link : ["http://139.196.106.200/Uploads/Picture/2016-07-26/5797268894090.jpg"]
     */

    @SerializedName("id")
    private String id;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("sign")
    private String sign;
    @SerializedName("head")
    private String head;
    @SerializedName("head_list")
    private String headList;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("sex")
    private String sex;
    @SerializedName("age")
    private String age;
    @SerializedName("last_login_time")
    private String lastLoginTime;
    @SerializedName("distance")
    private String distance;
    @SerializedName("follow_count")
    private String followCount;
    @SerializedName("fans_count")
    private String fansCount;
    @SerializedName("isfriend")
    private String isfriend;
    @SerializedName("head_link")
    private String headLink;
    @SerializedName("mygames")
    private List<?> mygames;
    @SerializedName("groups")
    private List<?> groups;
    @SerializedName("teams")
    private List<?> teams;
    @SerializedName("activity")
    private List<?> activity;
    @SerializedName("match")
    private List<?> match;
    @SerializedName("tags")
    private List<?> tags;
    @SerializedName("role_list")
    private List<?> roleList;
    /**
     * id : 509
     * uid : 101685
     * content : 这工作好危险~
     * pic : http://139.196.106.200/Uploads/Picture/2016-08-03/57a1a0b6e8f9e.jpg
     * praises : 3
     * reviews : 0
     * create_time : 1470210252
     * tags : []
     * nickname : mini酱
     * head : d38e68a18a22f7c8ebcd9d2916319f41604702e3
     * mobile : 12345678956
     * circle_title : 树洞杂谈
     * icon : http://139.196.106.200/Uploads/Picture/2016-07-15/5788d61dce93d.jpg
     * is_praise : 0
     * pic_lists : ["http://139.196.106.200/Uploads/Picture/2016-08-03/57a1a0b6e8f9e.jpg"]
     * head_link : http://139.196.106.200/Uploads/Picture/2016-07-26/5797268894090.jpg
     */

    @SerializedName("posts")
    private List<PostsBean> posts;
    @SerializedName("head_list_link")
    private List<String> headListLink;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHeadList() {
        return headList;
    }

    public void setHeadList(String headList) {
        this.headList = headList;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFollowCount() {
        return followCount;
    }

    public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }

    public String getFansCount() {
        return fansCount;
    }

    public void setFansCount(String fansCount) {
        this.fansCount = fansCount;
    }

    public String getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(String isfriend) {
        this.isfriend = isfriend;
    }

    public String getHeadLink() {
        return headLink;
    }

    public void setHeadLink(String headLink) {
        this.headLink = headLink;
    }

    public List<?> getMygames() {
        return mygames;
    }

    public void setMygames(List<?> mygames) {
        this.mygames = mygames;
    }

    public List<?> getGroups() {
        return groups;
    }

    public void setGroups(List<?> groups) {
        this.groups = groups;
    }

    public List<?> getTeams() {
        return teams;
    }

    public void setTeams(List<?> teams) {
        this.teams = teams;
    }

    public List<?> getActivity() {
        return activity;
    }

    public void setActivity(List<?> activity) {
        this.activity = activity;
    }

    public List<?> getMatch() {
        return match;
    }

    public void setMatch(List<?> match) {
        this.match = match;
    }

    public List<?> getTags() {
        return tags;
    }

    public void setTags(List<?> tags) {
        this.tags = tags;
    }

    public List<?> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<?> roleList) {
        this.roleList = roleList;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public List<String> getHeadListLink() {
        return headListLink;
    }

    public void setHeadListLink(List<String> headListLink) {
        this.headListLink = headListLink;
    }

    public static class PostsBean {
        @SerializedName("id")
        private String id;
        @SerializedName("uid")
        private String uid;
        @SerializedName("content")
        private String content;
        @SerializedName("pic")
        private String pic;
        @SerializedName("praises")
        private String praises;
        @SerializedName("reviews")
        private String reviews;
        @SerializedName("create_time")
        private String createTime;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("head")
        private String head;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("circle_title")
        private String circleTitle;
        @SerializedName("icon")
        private String icon;
        @SerializedName("is_praise")
        private String isPraise;
        @SerializedName("head_link")
        private String headLink;
        @SerializedName("tags")
        private List<?> tags;
        @SerializedName("pic_lists")
        private List<String> picLists;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
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

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
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

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getCircleTitle() {
            return circleTitle;
        }

        public void setCircleTitle(String circleTitle) {
            this.circleTitle = circleTitle;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
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

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public List<String> getPicLists() {
            return picLists;
        }

        public void setPicLists(List<String> picLists) {
            this.picLists = picLists;
        }
    }
}
