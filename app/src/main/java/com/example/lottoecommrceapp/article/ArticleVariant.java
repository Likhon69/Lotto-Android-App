package com.example.lottoecommrceapp.article;

import androidx.annotation.NonNull;

public class ArticleVariant {
    private Integer artV_Id;
    private String articleNo;
    private String gender;
    private String color;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    private Integer size;
    private String style;

    public ArticleVariant(Integer artV_Id, String articleNo, String gender, String color, Integer size, String style) {
        this.artV_Id = artV_Id;
        this.articleNo = articleNo;
        this.gender = gender;
        this.color = color;
        this.size = size;
        this.style = style;
    }

    public Integer getArtV_Id() {
        return artV_Id;
    }

    public void setArtV_Id(Integer artV_Id) {
        this.artV_Id = artV_Id;
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @NonNull
    @Override
    public String toString() {
        return size.toString();
    }
}
