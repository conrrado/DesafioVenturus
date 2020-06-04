package com.ccamacho.desafioventurus.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Gallery {

    @SerializedName("data")
    List<GalleryData> galleryDataList;

    public Gallery(List<GalleryData> galleryDataList) {
        this.galleryDataList = galleryDataList;
    }

    public List<GalleryData> getGalleryDataList() {
        return galleryDataList;
    }

    public void setGalleryDataList(List<GalleryData> galleryDataList) {
        this.galleryDataList = galleryDataList;
    }
}
