package com.example.lottoecommrceapp.addtocart;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface AddToCartDao {
    @Query("SELECT * FROM AddToCartModel")
    Flowable<List<AddToCartModel>> getAllCartItems();

    @Query("SELECT * FROM AddToCartModel WHERE id=:cartItemId")
    Flowable<List<AddToCartModel>> getCartItemById(int cartItemId);
    @Query("SELECT COUNT(*) from AddToCartModel")
    int countCartItems();
    @Query("DELETE FROM AddToCartModel")
    void emptyCart();
    @Insert
    void insertToCart(AddToCartModel... cartModels);
    @Update
    void UpdateCart(AddToCartModel... cartModels);
    @Delete
    void deleteCartItem(AddToCartModel cartModel);

}
