package com.example.lottoecommrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.lottoecommrceapp.article.ArticleDetails;
import com.example.lottoecommrceapp.article.ArticleDetailsAdapter;
import com.example.lottoecommrceapp.article.ArticleImageAdapter;
import com.example.lottoecommrceapp.article.ArticleImageModel;
import com.example.lottoecommrceapp.article.ArticleSuggetionAdapter;
import com.example.lottoecommrceapp.article.ArticleVariant;
import com.example.lottoecommrceapp.article.ArticleVariantAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_DESCRIPTION;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_DISCOUNT_PRICE;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_DISCOUNT_RATE;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_ID;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_IMAGE_NAME;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_NAME;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_PRICE;

public class ArticleDetailsActivity extends AppCompatActivity {
    private static final String TAG = ArticleDetailsActivity.class.getSimpleName();
    private static final String URL_ALL = "http://192.168.5.27/api/ArticleGet/GetAllArticleDetails";
    private static final String URL_IMG = "http://192.168.5.27/api/ArticleGet/GetArticleImageListByID/";
    private static final String URL_VARIANT = "http://192.168.5.27/api/ArticleGet/GetArticleVarianListByID/";
    private static final String ImgUrl = "http://192.168.5.27/Likhon/";
    private ArticleImageModel[] articleDetails;
    private ArticleVariant[] articleVariant;
    private List<ArticleVariant> articleVariantList = new ArrayList<>();
    private ArticleDetails[] articleDetailsAll;
    private List<ArticleDetails> articleDetailsList = new ArrayList<>();

    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        Intent intent = getIntent();
        String articleTitle = intent.getStringExtra(ARTICLE_NAME);
        String articleMasterImage = intent.getStringExtra(ARTICLE_IMAGE_NAME);
        int articlePrice = intent.getIntExtra(ARTICLE_PRICE,0);
        int articleId = intent.getIntExtra(ARTICLE_ID,0);
        int articleDiscountRate = intent.getIntExtra(ARTICLE_DISCOUNT_RATE,0);
        int articleDiscountPrice = intent.getIntExtra(ARTICLE_DISCOUNT_PRICE,0);
        String articleDiscription = intent.getStringExtra(ARTICLE_DESCRIPTION);
        passId(articleId);
        getSize(articleId);
        TextView textAricleTitle = findViewById(R.id.article_title_id);
        TextView textArticlePrice = findViewById(R.id.article_price_txt);
        TextView textArticleDiscountRate = findViewById(R.id.article_discount_txt);
        TextView textArticleDiscountPrice = findViewById(R.id.article_price_discount_txt);
        TextView textArticleDescription = findViewById(R.id.article_description_txt);



        textAricleTitle.setText(articleTitle);
        textArticlePrice.setText(Integer.toString(articlePrice));
        textArticlePrice.setPaintFlags(textArticlePrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        textArticleDiscountRate.setText(Integer.toString(articleDiscountRate));
        textArticleDiscountPrice.setText(Integer.toString(articleDiscountPrice));
        textArticleDescription.setText(articleDiscription);

        final RecyclerView articleAllList = findViewById(R.id.recyclerview_all_suggetion);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        articleAllList.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);


        StringRequest request = new StringRequest(Request.Method.GET,URL_ALL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Successfully signed in all response : " + response.toString());
                GsonBuilder gsonbuilder = new GsonBuilder();
                Gson gson = gsonbuilder.create();

                articleDetailsAll = gson.fromJson(response,ArticleDetails[].class);
                for(int i =0;i<articleDetailsAll.length;i++){
                    articleDetailsList.add(articleDetailsAll[i]);
                }

                articleAllList.setAdapter(new ArticleSuggetionAdapter(ArticleDetailsActivity.this,articleDetailsList));



            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue Queue = Volley.newRequestQueue(this);
        Queue.add(request);



    }

    private  void passId(int id){
        final ViewPager mPager = findViewById(R.id.image_viewPager);

        StringRequest request = new StringRequest(Request.Method.GET,URL_IMG+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Successfully signed in response : " + response.toString());
                GsonBuilder gsonbuilder = new GsonBuilder();
                Gson gson = gsonbuilder.create();

                articleDetails = gson.fromJson(response,ArticleImageModel[].class);


               mPager.setAdapter(new ArticleImageAdapter(articleDetails));



            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue Queue = Volley.newRequestQueue(this);
        Queue.add(request);
    }
    private void getSize(int id){
        final RecyclerView size_recycler = findViewById(R.id.recyclerview_all_size);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        size_recycler.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        StringRequest request = new StringRequest(Request.Method.GET,URL_VARIANT+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Successfully signed in variant response : " + response.toString());
                GsonBuilder gsonbuilder = new GsonBuilder();
                Gson gson = gsonbuilder.create();

                articleVariant = gson.fromJson(response, ArticleVariant[].class);
                colorData(articleVariant[0]);

             size_recycler.setAdapter(new ArticleVariantAdapter(articleVariant));



            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue Queue = Volley.newRequestQueue(this);
        Queue.add(request);






    }
    private void colorData(ArticleVariant article){
        TextView textColor = findViewById(R.id.article_percntge_color_txt);
        textColor.setText(article.getColor());
    }
}
