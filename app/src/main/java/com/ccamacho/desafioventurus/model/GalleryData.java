package com.ccamacho.desafioventurus.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GalleryData {

    private String id;
    private String title;
    private int views;

    @SerializedName("images")
    private List<GalleryImage> galleryImageList;

    public GalleryData(String id, String title, int views, List<GalleryImage> galleryImageList) {
        this.id = id;
        this.title = title;
        this.views = views;
        this.galleryImageList = galleryImageList;
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

    public List<GalleryImage> getGalleryImageList() {
        return galleryImageList;
    }

    public void setGalleryImageList(List<GalleryImage> galleryImageList) {
        this.galleryImageList = galleryImageList;
    }
}
