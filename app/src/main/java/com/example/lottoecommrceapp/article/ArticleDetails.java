package com.example.lottoecommrceapp.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleDetails {

    @SerializedName("articleTitle")
    @Expose
    private  String articleTitle;



    @SerializedName("articleSubtitle")
    @Expose
    private String articleSubtitle;
    @SerializedName("articleMasterImage")
    @Expose
    private String articleMasterImage;
    @SerializedName("standardPrice")
    @Expose
    private Integer standardPrice;

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleSubtitle() {
        return articleSubtitle;
    }

    public void setArticleSubtitle(String articleSubtitle) {
        this.articleSubtitle = articleSubtitle;
    }

    public String getArticleMasterImage() {
        return articleMasterImage;
    }

    public void setArticleMasterImage(String articleMasterImage) {
        this.articleMasterImage = articleMasterImage;
    }

    public Integer getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(Integer standardPrice) {
        this.standardPrice = standardPrice;
    }

}
