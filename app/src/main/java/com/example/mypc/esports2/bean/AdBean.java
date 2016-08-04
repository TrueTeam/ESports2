package com.example.mypc.esports2.bean;

import com.google.gson.annotations.SerializedName;

public class AdBean {
        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;
        @SerializedName("cover")
        private String cover;
        @SerializedName("link")
        private String link;
        @SerializedName("cover_link")
        private String coverLink;

    public AdBean(String id, String title, String cover, String link, String coverLink) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.link = link;
        this.coverLink = coverLink;
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

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCoverLink() {
            return coverLink;
        }

        public void setCoverLink(String coverLink) {
            this.coverLink = coverLink;
        }
    }