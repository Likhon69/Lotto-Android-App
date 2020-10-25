package com.example.lottoecommrceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.lottoecommrceapp.addtocart.AddToCartModel;

import java.util.List;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.CheckoutAdapterViewHolder> {

    private static final String ImgUrl = "http://192.168.5.27/Likhon/";
    List<AddToCartModel> addToCartModelList;
    Context context;
    List<Integer>listOfQuantity;


    public CheckoutAdapter(List<AddToCartModel> addToCartModelList, Context context, List<Integer> listOfQuantity) {
        this.addToCartModelList = addToCartModelList;
        this.context = context;
        this.listOfQuantity = listOfQuantity;
    }

    @NonNull
    @Override
    public CheckoutAdapter.CheckoutAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.checkout_view,parent,false);
        return new CheckoutAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutAdapter.CheckoutAdapterViewHolder holder, int position) {
        Glide.with(holder.checkout_image.getContext()).load(ImgUrl + addToCartModelList.get(position).articleMasterImage)
                .into(holder.checkout_image);
        if (listOfQuantity.get(position) == 0) {

            holder.currency.setVisibility(View.INVISIBLE);
            holder.currency_discount.setVisibility(View.INVISIBLE);
            holder.id_off.setVisibility(View.INVISIBLE);
            holder.id_qty.setVisibility(View.INVISIBLE);
            holder.checkout_Article_title.setText("Sorry sir,Stock Out of this product");
        } else {
            holder.checkout_Article_title.setText(addToCartModelList.get(position).articleTitle);
            holder.checkout_standard_price.setText(Integer.toString(addToCartModelList.get(position).standardPrice));
            holder.checkout_discount_rate.setText(Integer.toString(addToCartModelList.get(position).discountRate));
            holder.checkout_discount_price.setText(Integer.toString(addToCartModelList.get(position).discountPrice));
            holder.checkout_quantity.setText(Integer.toString(addToCartModelList.get(position).quantity));

        }
    }

    @Override
    public int getItemCount() {
        return addToCartModelList.size();
    }

    public class CheckoutAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView checkout_image;
        TextView checkout_Article_title;
        TextView checkout_standard_price;
        TextView checkout_discount_rate;
        TextView checkout_discount_price;
        TextView checkout_quantity;
        LinearLayout checkout_linear;
        LinearLayout checkout_linear_quantity;
        ImageView currency;
        ImageView currency_discount;
        TextView id_off;
        TextView id_qty;
        public CheckoutAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            checkout_image = itemView.findViewById(R.id.cart_image_checkout);
            checkout_Article_title = itemView.findViewById(R.id.article_title_checkout);
            checkout_standard_price = itemView.findViewById(R.id.article_standard_price_checkout);
            checkout_discount_rate = itemView.findViewById(R.id.article_discount_rate_checkout);
            checkout_discount_price = itemView.findViewById(R.id.article_price_discount_checkout);
            checkout_quantity = itemView.findViewById(R.id.button_quantity_checkout);
            checkout_linear = itemView.findViewById(R.id.checkout_linear);
            checkout_linear_quantity = itemView.findViewById(R.id.checkout_linear_quantity);
            currency = itemView.findViewById(R.id.currency);
            currency_discount = itemView.findViewById(R.id.currency_discount);
            id_off = itemView.findViewById(R.id.id_off);
            id_qty = itemView.findViewById(R.id.id_qty);
        }
    }
}
