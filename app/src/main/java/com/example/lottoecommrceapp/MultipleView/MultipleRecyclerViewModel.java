package com.example.lottoecommrceapp.MultipleView;

import com.example.lottoecommrceapp.article.ArticleDetails;
import com.example.lottoecommrceapp.category.Category;
import com.example.lottoecommrceapp.slider.SliderItem;

import java.util.List;

public class MultipleRecyclerViewModel {

    public static final int SLIDER_ITEM_POSITION = 0;
    public static final int CATEGORY_ITEM = 1;
    public static final int ARTICLE_DETAILS_ITEM = 2;
    private int viewType;
    private List<SliderItem> sliderItemList;
    //Slider_item
    public int getViewType() {
        return viewType;
    }



    public MultipleRecyclerViewModel(int viewType, List<SliderItem> sliderItemList) {
        this.viewType = viewType;
        this.sliderItemList = sliderItemList;
    }

    public static int getSliderItemPosition() {
        return SLIDER_ITEM_POSITION;
    }

    public List<SliderItem> getSliderItemList() {
        return sliderItemList;
    }

    public void setSliderItemList(List<SliderItem> sliderItemList) {
        this.sliderItemList = sliderItemList;
    }
    //CATEGORY_ITEM
    private List<Category> categoryList;
    private int anInt;
    public MultipleRecyclerViewModel(int viewType,List<Category> categoryList,int anInt) {
        this.viewType = viewType;
        this.categoryList = categoryList;
        this.anInt = anInt;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    //All Article Details

    private List<ArticleDetails> articleDetailsList;
    private String id;

    public MultipleRecyclerViewModel( int viewType,List<ArticleDetails> articleDetailsList,String id) {
        this.viewType = viewType;
        this.articleDetailsList = articleDetailsList;
        this.id = id;
    }

    public List<ArticleDetails> getArticleDetailsList() {
        return articleDetailsList;
    }

    public void setArticleDetailsList(List<ArticleDetails> articleDetailsList) {
        this.articleDetailsList = articleDetailsList;
    }
}
