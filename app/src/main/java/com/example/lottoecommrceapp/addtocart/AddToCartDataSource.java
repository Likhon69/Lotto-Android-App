package com.example.lottoecommrceapp.addtocart;

import java.util.List;

import io.reactivex.Flowable;

public class AddToCartDataSource implements IAddToCartDataSource {

    private AddToCartDao addToCartDao;
    private static AddToCartDataSource instance;

    public AddToCartDataSource(AddToCartDao addToCartDao) {
        this.addToCartDao = addToCartDao;
    }
    public static AddToCartDataSource getInstance(AddToCartDao cartDao){
        if(instance==null)
            instance = new AddToCartDataSource(cartDao);
            return instance;

    }

    @Override
    public Flowable<List<AddToCartModel>> getAllCartItems() {
        return addToCartDao.getAllCartItems();
    }

    @Override
    public Flowable<List<AddToCartModel>> getCartItemById(int cartItemId) {
        return addToCartDao.getCartItemById(cartItemId);
    }

    @Override
    public int countCartItems() {
        return addToCartDao.countCartItems();
    }

    @Override
    public void emptyCart() {
      addToCartDao.countCartItems();
    }

    @Override
    public void insertToCart(AddToCartModel... cartModels) {
       addToCartDao.insertToCart(cartModels);
    }

    @Override
    public void UpdateCart(AddToCartModel... cartModels) {
      addToCartDao.UpdateCart(cartModels);
    }

    @Override
    public void deleteCartItem(AddToCartModel cartModel) {
        addToCartDao.deleteCartItem(cartModel);
    }
}
