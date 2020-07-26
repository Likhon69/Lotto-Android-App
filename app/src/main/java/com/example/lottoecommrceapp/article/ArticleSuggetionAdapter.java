package com.example.lottoecommrceapp.article;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lottoecommrceapp.R;

import java.util.ArrayList;
import java.util.List;

public class ArticleSuggetionAdapter extends RecyclerView.Adapter<ArticleSuggetionAdapter.ArticleSuggetionViewHolder> {
    private static final String ImgUrl = "http://192.168.5.27/Likhon/";
    @NonNull
    List<ArticleDetails> lista = new ArrayList<>();
    Context context;



    public ArticleSuggetionAdapter(@NonNull Context context, List<ArticleDetails> lista) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public ArticleSuggetionAdapter.ArticleSuggetionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.article_card_suggetion, parent, false);

        return new ArticleSuggetionViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ArticleSuggetionAdapter.ArticleSuggetionViewHolder holder, int position) {

        holder.articleText.setText(lista.get(position).getArticleSubtitle());
        holder.articlePrice.setText(Integer.toString(lista.get(position).getStandardPrice()));
        Glide.with(holder.cardImage.getContext()).load(ImgUrl+lista.get(position).getArticleMasterImage())
                .fitCenter()
                .into(holder.cardImage);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ArticleSuggetionViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView articleText;
        TextView articlePrice;
        public ArticleSuggetionViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.article_image_sugg);
            articleText = itemView.findViewById(R.id.article_txt_sugg_id);
            articlePrice = itemView.findViewById(R.id.article_price_sugg_txt);
        }
    }
}
