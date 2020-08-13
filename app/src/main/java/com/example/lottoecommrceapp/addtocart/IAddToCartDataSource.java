package com.example.lottoecommrceapp.addtocart;

import java.util.List;

import io.reactivex.Flowable;

public interface IAddToCartDataSource {
    Flowable<List<AddToCartModel>> getAllCartItems();
    Flowable<List<AddToCartModel>> getCartItemById(int cartItemId);
    int countCartItems();
    void emptyCart();
    void insertToCart(AddToCartModel... cartModels);
    void UpdateCart(AddToCartModel... cartModels);
    void deleteCartItem(AddToCartModel cartModel);

}
