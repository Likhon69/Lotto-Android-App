package com.example.lottoecommrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.lottoecommrceapp.addtocart.AddToCartModel;
import com.example.lottoecommrceapp.addtocart.Common;
import com.example.lottoecommrceapp.article.ArticleDetails;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Checkout extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String URL = "http://192.168.5.27/api/ArticleGet/GetAllArticleDetails";
    public ArrayList<ArticleDetails> lista=new ArrayList<ArticleDetails>();
    private List<ArticleDetails> articleDetailsList = new ArrayList<>();
    private ArticleDetails[] articleDetails;
    private ArticleDetails[] articleDetails2;
    RecyclerView checkout_recycler;
    List<Integer>listOfQuantity = new ArrayList<>();
    CompositeDisposable compositeDisposable;
    private List<AddToCartModel> addToCartModelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        compositeDisposable = new CompositeDisposable();

        checkout_recycler = findViewById(R.id.checkout_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        checkout_recycler.setLayoutManager(layoutManager);
        StringRequest request = new StringRequest(Request.Method.GET,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Successfully signed in response : " + response.toString());
                GsonBuilder gsonbuilder = new GsonBuilder();
                Gson gson = gsonbuilder.create();

                articleDetails = gson.fromJson(response,ArticleDetails[].class);



                passData(articleDetails);


            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue Queue = Volley.newRequestQueue(this);
        Queue.add(request);

        loadCartItems();

    }



    public void  passData(ArticleDetails[] article) {

        for (int i = 0; i < article.length; i++) {
            lista.add(article[i]);
        }
        displayCartCheckout(addToCartModelList);
    }

    private void loadCartItems() {


        compositeDisposable.add(
                Common.addToCartRepository.getAllCartItems()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Consumer<List<AddToCartModel>>() { @Override
                        public void accept(List<AddToCartModel> addToCartModels) throws Exception {
                            addToCartModelList = addToCartModels;


                        }
                        })
        );
    }


    private void displayCartCheckout(List<AddToCartModel> addToCartModels){
       for(int i =0;i<addToCartModels.size();i++){
           checkQuantity(addToCartModels.get(i).articleId);
       }
    }
    private void  checkQuantity(int i){
        articleDetailsList = lista;
        for (int j=0;j<articleDetailsList.size();j++){
            if(i==articleDetailsList.get(j).getArticleId()){
                listOfQuantity.add(articleDetailsList.get(j).getQuantity());
                break;
            }
        }
        callCheckoutAdapter();
    }
    private void callCheckoutAdapter(){
        CheckoutAdapter adapter = new CheckoutAdapter(addToCartModelList,this,listOfQuantity);
        checkout_recycler.setAdapter(adapter);
    }



}

