package com.example.lottoecommrceapp.home;

import com.example.lottoecommrceapp.slider.SliderItem;

import java.util.List;

public class HomePageModel {
    public static final int SLIDER_IMAGE_VIEW = 0;
    public  static final int CATEGORY_IMAGE_VIEW = 1;
    public static  final int ALL_PRODUCT_LIST = 2;
    private int viewType;
    private List<SliderItem> sliderItemList;

    public HomePageModel(int viewType, List<SliderItem> sliderItemList) {
        this.viewType = viewType;
        this.sliderItemList = sliderItemList;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public List<SliderItem> getSliderItemList() {
        return sliderItemList;
    }

    public void setSliderItemList(List<SliderItem> sliderItemList) {
        this.sliderItemList = sliderItemList;
    }
}
