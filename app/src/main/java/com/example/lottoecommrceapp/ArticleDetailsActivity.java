package com.example.lottoecommrceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.example.lottoecommrceapp.article.ArticleImageModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_ID;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_IMAGE_NAME;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_NAME;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_PRICE;

public class ArticleDetailsActivity extends AppCompatActivity {
    private static final String TAG = ArticleDetailsActivity.class.getSimpleName();
    private static final String URL = "http://192.168.5.27/api/ArticleGet/GetArticleImageListByID/";
    private static final String ImgUrl = "http://192.168.5.27/Likhon/";
    private ArticleImageModel[] articleDetails;
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
        passId(articleId);
        ImageView imageView = findViewById(R.id.article_detaills_image_id);
        TextView textAricleTitle = findViewById(R.id.article_title_id);
        TextView textArticlePrice = findViewById(R.id.article_price_txt);
        TextView textId = findViewById(R.id.article_id_txt);

        Glide.with(imageView.getContext()).load(ImgUrl+articleMasterImage).fitCenter().into(imageView);
        textAricleTitle.setText(articleTitle);
        textArticlePrice.setText(Integer.toString(articlePrice));
        textId.setText(Integer.toString(articleId));

    }

    private  void passId(int id){
        StringRequest request = new StringRequest(Request.Method.GET,URL+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Successfully signed in response : " + response.toString());
                GsonBuilder gsonbuilder = new GsonBuilder();
                Gson gson = gsonbuilder.create();

                articleDetails = gson.fromJson(response,ArticleImageModel[].class);






            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue Queue = Volley.newRequestQueue(this);
        Queue.add(request);
    }
}
