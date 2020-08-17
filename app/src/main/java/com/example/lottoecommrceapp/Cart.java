package com.example.lottoecommrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lottoecommrceapp.addtocart.AddToCartModel;
import com.example.lottoecommrceapp.addtocart.Common;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Cart extends AppCompatActivity {

     RecyclerView recycler_cart;
     CompositeDisposable compositeDisposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        compositeDisposable = new CompositeDisposable();

        recycler_cart = findViewById(R.id.cart_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler_cart.setLayoutManager(layoutManager);

        loadCartItems();
    }

   private void loadCartItems() {
        compositeDisposable.add(
                Common.addToCartRepository.getAllCartItems()
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeOn(Schedulers.io())
               .subscribe(new Consumer<List<AddToCartModel>>() { @Override
                   public void accept(List<AddToCartModel> addToCartModels) throws Exception { displayCart(addToCartModels); }
               })
      );
  }

    private void displayCart(List<AddToCartModel> addToCartModels){
       CartAdapter adapter = new CartAdapter(addToCartModels,this);
       recycler_cart.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
       compositeDisposable.clear();
       super.onDestroy();
    }

    @Override
  protected void onStop() {
       compositeDisposable.clear();
       super.onStop();
   }
}
