package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class RetroPhoto {

    @SerializedName("id")
    private Integer id;
    @SerializedName("albumId")
    private Integer albumId;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnail")
    private String thumbnail;

    public RetroPhoto(Integer id, Integer albumId, String title, String url, String thumbnail) {
        this.id = id;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.thumbnail = thumbnail;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
