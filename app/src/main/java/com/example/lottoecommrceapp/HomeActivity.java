package com.example.lottoecommrceapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lottoecommrceapp.addtocart.AddToCartDataSource;
import com.example.lottoecommrceapp.addtocart.AddToCartDatabase;
import com.example.lottoecommrceapp.addtocart.AddToCartRepository;
import com.example.lottoecommrceapp.addtocart.Common;
import com.example.lottoecommrceapp.article.ArticleDetails;
import com.example.lottoecommrceapp.article.ArticleDetailsAdapter;
import com.example.lottoecommrceapp.slider.SliderAdapter;
import com.example.lottoecommrceapp.slider.SliderItem;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nex3z.notificationbadge.NotificationBadge;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_DESCRIPTION;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_DISCOUNT_PRICE;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_DISCOUNT_RATE;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_ID;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_IMAGE_NAME;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_NAME;
import static com.example.lottoecommrceapp.article.ArticleDetailsAdapter.ARTICLE_PRICE;

public class HomeActivity extends AppCompatActivity implements ArticleDetailsAdapter.onItemClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String URL = "http://192.168.5.27/api/ArticleGet/GetAllArticleDetails";
    private static final String URL2 = "http://192.168.5.27/Likhon";
    private ArticleDetails[] articleDetails;
    private ArticleDetails[] articleDetails2;
    private RequestQueue mQueue;
    private FrameLayout frameLayout;
    private SliderView sliderView;
    MenuItem menuItem;
    TextView badgeCounter;
    TextView badge;
    ImageView img_icon;

    public ArrayList<ArticleDetails> lista=new ArrayList<ArticleDetails>();
    private List<ArticleDetails> articleDetailsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sliderView = findViewById(R.id.imageSlider);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
     /*   DrawerLayout drawer = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);*/
       /* ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();*/
       /* frameLayout = findViewById(R.id.main_frameLayout);
       setFragment(new HomeFragment());*/

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
        List<SliderItem> sliderItemList = new ArrayList<>();
        sliderItemList.add(new SliderItem("Image1","https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"));
        sliderItemList.add(new SliderItem("Image2","https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=126"));

        sliderView.setSliderAdapter(new SliderAdapter(sliderItemList));
        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });
       /* CardView cardView = findViewById(R.id.men_card);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MenCategoryActivity.class);
                startActivity(intent);
            }
        });*/
        //article details code

        articleDetailsList = lista;


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
        initDB();

    }

    private void initDB() {
        Common.addToCartDatabase = AddToCartDatabase.getInstance(this);
        Common.addToCartRepository = AddToCartRepository.getInstance(AddToCartDataSource.getInstance(Common.addToCartDatabase.addToCartDao()));

    }

    public  boolean onCreateOptionsMenu( Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
       View view = menu.findItem(R.id.cart_id).getActionView();



        badge = view.findViewById(R.id.badge_id);
        img_icon = view.findViewById(R.id.cart_icon);
        img_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(HomeActivity.this,Cart.class);
              startActivity(intent);
            }
        });
        updateCartCount();


    MenuItem item = menu.findItem(R.id.search_id);
    SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    });

        return  true;
}

public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.cart_id){
            return true;
        }
        return  super.onOptionsItemSelected(item);
}

    @Override
    protected void onResume() {
        super.onResume();
        updateCartCount();
    }

    private void updateCartCount() {
        if(badge==null) return;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(Common.addToCartRepository.countCartItems()==0){
                    badge.setVisibility(View.INVISIBLE);
                }else {
                    badge.setVisibility(View.VISIBLE);
                    badge.setText(String.valueOf(Common.addToCartRepository.countCartItems()));
                }
            }
        });

    }


  public void  passData(ArticleDetails[] article){

      for(int i =0;i<article.length;i++){
          lista.add(article[i]);
      }
      final RecyclerView articleAllList = findViewById(R.id.article_List);
      GridLayoutManager layoutManager = new GridLayoutManager(this,2);
     /* layoutManager.setOrientation(RecyclerView.VERTICAL
      );*/
      articleAllList.setLayoutManager(layoutManager);

      ArticleDetailsAdapter adapter = new ArticleDetailsAdapter(HomeActivity.this,articleDetailsList);
      articleAllList.setAdapter(adapter);
      adapter.setOnItemClickListner(HomeActivity.this);
  }

    @Override
    public void onItemClick(int position) {
        Intent articleDetailsIntent = new Intent(this,ArticleDetailsActivity.class);
        ArticleDetails checkedItem = articleDetailsList.get(position);
        articleDetailsIntent.putExtra(ARTICLE_NAME,checkedItem.getArticleTitle());
        articleDetailsIntent.putExtra(ARTICLE_PRICE,checkedItem.getStandardPrice());
        articleDetailsIntent.putExtra(ARTICLE_IMAGE_NAME,checkedItem.getArticleMasterImage());
        articleDetailsIntent.putExtra(ARTICLE_ID,checkedItem.getArticleId());
        articleDetailsIntent.putExtra(ARTICLE_DISCOUNT_RATE,checkedItem.getDiscountRate());
        articleDetailsIntent.putExtra(ARTICLE_DISCOUNT_PRICE,checkedItem.getDiscountPrice());
        articleDetailsIntent.putExtra(ARTICLE_DESCRIPTION,checkedItem.getDescription());

        startActivity(articleDetailsIntent);
    }


}
