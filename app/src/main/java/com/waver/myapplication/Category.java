package com.waver.myapplication;

import java.io.Serializable;

/**
 * Created by wowfl on 2015/12/9 0009.
 */
public class Category implements Serializable {
    //分类标题，图片
    private String title;
    private int photoId;

    Category(String title,int img){
        this.title = title;
        this.photoId = img;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getTitle() {
        return title;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
