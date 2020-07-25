package com.example.lottoecommrceapp.article;

public class ArticleImageModel {

    private Integer img_Id;
    private String imageName;

    public ArticleImageModel(Integer img_Id, String imageName) {
        this.img_Id = img_Id;
        this.imageName = imageName;
    }

    public Integer getImg_Id() {
        return img_Id;
    }

    public void setImg_Id(Integer img_Id) {
        this.img_Id = img_Id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
