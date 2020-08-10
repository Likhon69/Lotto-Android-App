package com.example.lottoecommrceapp.article;

public class AddToCartData {
    private int standardPrice;
    private int discountPrice;
    private String articleMasterImage;
    private int articleId;
    private int discountRate;


    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public AddToCartData(int standardPrice, int discountPrice, String articleMasterImage, int articleId, int discountRate) {
        this.standardPrice = standardPrice;
        this.discountPrice = discountPrice;
        this.articleMasterImage = articleMasterImage;
        this.articleId = articleId;
        this.discountRate = discountRate;
    }

    public int getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(int standardPrice) {
        this.standardPrice = standardPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getArticleMasterImage() {
        return articleMasterImage;
    }

    public void setArticleMasterImage(String articleMasterImage) {
        this.articleMasterImage = articleMasterImage;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
