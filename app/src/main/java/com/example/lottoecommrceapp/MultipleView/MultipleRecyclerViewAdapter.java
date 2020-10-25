package com.example.lottoecommrceapp.MultipleView;

import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.lottoecommrceapp.HomeActivity;
import com.example.lottoecommrceapp.R;
import com.example.lottoecommrceapp.article.ArticleDetails;
import com.example.lottoecommrceapp.article.ArticleDetailsAdapter;
import com.example.lottoecommrceapp.category.Category;
import com.example.lottoecommrceapp.category.CategoryAdapter;
import com.example.lottoecommrceapp.slider.SliderAdapter;
import com.example.lottoecommrceapp.slider.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

public class MultipleRecyclerViewAdapter extends RecyclerView.Adapter {

    @NonNull
    private List<MultipleRecyclerViewModel> multipleRecyclerViewModelList;

    public MultipleRecyclerViewAdapter(@NonNull List<MultipleRecyclerViewModel> multipleRecyclerViewModelList) {
        this.multipleRecyclerViewModelList = multipleRecyclerViewModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (multipleRecyclerViewModelList.get(position).getViewType()){
            case 0:
                return MultipleRecyclerViewModel.SLIDER_ITEM_POSITION;
            case 1:
                return MultipleRecyclerViewModel.CATEGORY_ITEM;
            case 2:
                return MultipleRecyclerViewModel.ARTICLE_DETAILS_ITEM;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case MultipleRecyclerViewModel.SLIDER_ITEM_POSITION:
                LayoutInflater banner_inflater = LayoutInflater.from(parent.getContext());
                View banner_view = banner_inflater.inflate(R.layout.slider_layout,parent,false);
               return  new BannerSliderViewHolder(banner_view);
            case MultipleRecyclerViewModel.CATEGORY_ITEM:
                LayoutInflater category_inflater = LayoutInflater.from(parent.getContext());
                View category_view = category_inflater.inflate(R.layout.category_layout, parent, false);
                return new CategoryListViewHolder(category_view);
            case MultipleRecyclerViewModel.ARTICLE_DETAILS_ITEM:
                LayoutInflater article_details_inflater = LayoutInflater.from(parent.getContext());

                View article_details_view_view = article_details_inflater.inflate(R.layout.article_details_all_list, parent, false);
                return new ArticleDetailsViewHolder(article_details_view_view);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
      switch (multipleRecyclerViewModelList.get(position).getViewType()){
          case MultipleRecyclerViewModel.SLIDER_ITEM_POSITION:
              List<SliderItem> sliderItems = multipleRecyclerViewModelList.get(position).getSliderItemList();
              ((BannerSliderViewHolder)holder).setBannerSlider(sliderItems);
              break;
          case MultipleRecyclerViewModel.CATEGORY_ITEM:
              List<Category> categoryItems = multipleRecyclerViewModelList.get(position).getCategoryList();
              ((CategoryListViewHolder)holder).setCategory(categoryItems);
              break;
           case MultipleRecyclerViewModel.ARTICLE_DETAILS_ITEM:
               List<ArticleDetails> articleDetailsList = multipleRecyclerViewModelList.get(position).getArticleDetailsList();
               ((ArticleDetailsViewHolder)holder).setArticleDetailsList(articleDetailsList);
          default:
              return;
      }
    }

    @Override
    public int getItemCount() {
        return multipleRecyclerViewModelList.size();
    }

    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {
        SliderView sliderView;
        public BannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);

        }
        private void setBannerSlider(List<SliderItem>sliderItemList ){
            sliderView = itemView.findViewById(R.id.imageSlider);
            sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
            sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
            sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
            sliderView.setIndicatorSelectedColor(Color.WHITE);
            sliderView.setIndicatorUnselectedColor(Color.GRAY);
            sliderView.setScrollTimeInSec(3);
            sliderView.setAutoCycle(true);
            sliderView.startAutoCycle();
            sliderView.setSliderAdapter(new SliderAdapter(sliderItemList));
            sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
                @Override
                public void onIndicatorClicked(int position) {
                    Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
                }
            });
        }

    }

    public class CategoryListViewHolder extends  RecyclerView.ViewHolder {
        RecyclerView categoryListView;
        public CategoryListViewHolder(@NonNull View itemView) {
            super(itemView);

        }
        private void setCategory(List<Category> category){
            categoryListView = itemView.findViewById(R.id.category_List);
            CategoryAdapter cadapter = new CategoryAdapter(category);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            categoryListView.setLayoutManager(linearLayoutManager);

            categoryListView.setAdapter(cadapter);
        }

    }

    public class ArticleDetailsViewHolder extends  RecyclerView.ViewHolder {
        RecyclerView articleAllList;
        public ArticleDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void setArticleDetailsList(List<ArticleDetails> articleDetailsList){
            articleAllList = itemView.findViewById(R.id.article_List);
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
     /* layoutManager.setOrientation(RecyclerView.VERTICAL
      );*/


            articleAllList.setLayoutManager(layoutManager);


            articleAllList.setVisibility(View.VISIBLE);

            final ArticleDetailsAdapter adapter = new ArticleDetailsAdapter(articleDetailsList);

            articleAllList.setAdapter(adapter);


        }
    }
}
