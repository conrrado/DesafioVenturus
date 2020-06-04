package com.ccamacho.desafioventurus.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cat {

    private String id;
    private String title;
    private int views;

    @SerializedName("images")
    private List<CatImage> catImageList;

    public Cat(String id, String title, int views, List<CatImage> catImageList) {
        this.id = id;
        this.title = title;
        this.views = views;
        this.catImageList = catImageList;
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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public List<CatImage> getCatImageList() {
        return catImageList;
    }

    public void setCatImageList(List<CatImage> catImageList) {
        this.catImageList = catImageList;
    }
}
