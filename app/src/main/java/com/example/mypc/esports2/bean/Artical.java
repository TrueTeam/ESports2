package com.example.mypc.esports2.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by peter on 2016/8/4.
 */
public class Artical {

    /**
     * id : 223
     * title : 推荐资讯
     * alias : tuijianzixun
     * model_alias : article
     * model_title : 资讯
     * has_service : 0
     */

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("model_alias")
    private String modelAlias;
    @SerializedName("model_title")
    private String modelTitle;
    @SerializedName("has_service")
    private String hasService;

    public Artical(String id, String title, String modelAlias, String modelTitle, String hasService) {
        this.id = id;
        this.title = title;
        this.modelAlias = modelAlias;
        this.modelTitle = modelTitle;
        this.hasService = hasService;
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

    public String getModelAlias() {
        return modelAlias;
    }

    public void setModelAlias(String modelAlias) {
        this.modelAlias = modelAlias;
    }

    public String getModelTitle() {
        return modelTitle;
    }

    public void setModelTitle(String modelTitle) {
        this.modelTitle = modelTitle;
    }

    public String getHasService() {
        return hasService;
    }

    public void setHasService(String hasService) {
        this.hasService = hasService;
    }
}
