package com.example.lottoecommrceapp.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleDetails {

    @SerializedName("articleTitle")
    @Expose
    private  String articleTitle;

    @SerializedName("articleId")
    @Expose
    private  Integer articleId;

    //RATE
    @SerializedName("discountRate")
    @Expose
    private  Integer discountRate;
    //d_price
    @SerializedName("discountPrice")
    @Expose
    private  Integer discountPrice;
    //description
    @SerializedName("description")
    @Expose
    private  String description;


    @SerializedName("articleSubtitle")
    @Expose
    private String articleSubtitle;
    @SerializedName("articleMasterImage")
    @Expose
    private String articleMasterImage;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }


    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

}
