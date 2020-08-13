package com.example.lottoecommrceapp.addtocart;

import java.util.List;

import io.reactivex.Flowable;

public class AddToCartRepository implements IAddToCartDataSource {

    private IAddToCartDataSource iAddToCartDataSource;
    private static  AddToCartRepository instance;

    public AddToCartRepository(IAddToCartDataSource iAddToCartDataSource) {
        this.iAddToCartDataSource = iAddToCartDataSource;
    }

    public static AddToCartRepository getInstance(IAddToCartDataSource iAddToCartDataSource){
        if(instance==null)
            instance = new AddToCartRepository(iAddToCartDataSource);
        return instance;
    }

    @Override
    public Flowable<List<AddToCartModel>> getAllCartItems() {
        return iAddToCartDataSource.getAllCartItems();
    }

    @Override
    public Flowable<List<AddToCartModel>> getCartItemById(int cartItemId) {
        return iAddToCartDataSource.getCartItemById(cartItemId);
    }

    @Override
    public int countCartItems() {
        return iAddToCartDataSource.countCartItems();
    }

    @Override
    public void emptyCart() {
      iAddToCartDataSource.emptyCart();

    }

    @Override
    public void insertToCart(AddToCartModel... cartModels) {
    iAddToCartDataSource.insertToCart(cartModels);
    }

    @Override
    public void UpdateCart(AddToCartModel... cartModels) {
      iAddToCartDataSource.UpdateCart(cartModels);
    }

    @Override
    public void deleteCartItem(AddToCartModel cartModel) {
     iAddToCartDataSource.deleteCartItem(cartModel);
    }
}
