package com.example.lottoecommrceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lottoecommrceapp.addtocart.AddToCartModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartAdapterViewHolder> {
    private static final String ImgUrl = "http://192.168.5.27/Likhon/";
    List<AddToCartModel> addToCartModelList;
    Context context;

    public CartAdapter(List<AddToCartModel> addToCartModelList, Context context) {
        this.addToCartModelList = addToCartModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.CartAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.add_to_cart_details,parent,false);
        return new CartAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartAdapterViewHolder holder, int position) {
        Glide.with(holder.add_to_cart_image.getContext()).load(ImgUrl+addToCartModelList.get(position).articleMasterImage)
                .into(holder.add_to_cart_image);
        holder.add_to_cart_Article_title.setText(addToCartModelList.get(position).articleTitle);
        holder.add_to_cart_standard_price.setText(Integer.toString(addToCartModelList.get(position).standardPrice));
        holder.add_to_cart_discount_rate.setText(Integer.toString(addToCartModelList.get(position).discountRate));
        holder.add_to_cart_discount_price.setText(Integer.toString(addToCartModelList.get(position).discountPrice));
    }

    @Override
    public int getItemCount() {
        return addToCartModelList.size();
    }

    public class CartAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView add_to_cart_image;
        TextView add_to_cart_Article_title;
        TextView add_to_cart_standard_price;
        TextView add_to_cart_discount_rate;
        TextView add_to_cart_discount_price;
        public CartAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            add_to_cart_image = itemView.findViewById(R.id.cart_image_add_to_cart);
            add_to_cart_Article_title = itemView.findViewById(R.id.article_title_add_to_cart);
            add_to_cart_standard_price = itemView.findViewById(R.id.article_standard_price_add_to_cart);
            add_to_cart_discount_rate = itemView.findViewById(R.id.article_discount_rate_add_to_cart);
            add_to_cart_discount_price = itemView.findViewById(R.id.article_price_discount_add_to_cart);
        }
    }
}
