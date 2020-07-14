package com.example.lottoecommrceapp;

public class CategoryModel {
    private String IconLink;
    private String CategoryName;

    public CategoryModel(String iconLink, String categoryName) {
        IconLink = iconLink;
        CategoryName = categoryName;
    }

    public String getIconLink() {
        return IconLink;
    }

    public void setIconLink(String iconLink) {
        IconLink = iconLink;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
