package com.example.lottoecommrceapp.article;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

public class ArticleImageAdapter extends PagerAdapter {

    private static final String ImgUrl = "http://192.168.5.27/Likhon/";
    private ArticleImageModel[] articleImageModelList;

    public ArticleImageAdapter(ArticleImageModel[] articleImageModelList) {
        this.articleImageModelList = articleImageModelList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ArticleImageModel articleImageModel = articleImageModelList[position];
        ImageView articleImage = new ImageView(container.getContext());
        Glide.with(articleImage.getContext()).load(ImgUrl+articleImageModel.getImageName())
                .fitCenter()
                .into(articleImage);
        container.addView(articleImage,0);
        return articleImage;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }

    @Override
    public int getCount() {
        return articleImageModelList.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
