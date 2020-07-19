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

public class ArticleDetailsAdapter extends RecyclerView.Adapter<ArticleDetailsAdapter.ArticleDetailsHolder> {
    private static final String ImgUrl = "http://192.168.5.27/Likhon/";
    @NonNull
    ArticleDetails[] articleDetails;
    Context context;



    public ArticleDetailsAdapter(@NonNull Context context,ArticleDetails[] articleDetails) {
        this.articleDetails = articleDetails;
        this.context = context;
    }

    @Override
    public ArticleDetailsAdapter.ArticleDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_article_layout,parent,false);

        return new ArticleDetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleDetailsAdapter.ArticleDetailsHolder holder, int position) {
        ArticleDetails article = articleDetails[position];
       holder.articleText.setText(article.getArticleSubtitle());
       holder.articlePrice.setText(Integer.toString(article.getStandardPrice()));
        Glide.with(holder.cardImage.getContext()).load(ImgUrl+article.getArticleMasterImage())
                .fitCenter()
                .into(holder.cardImage);
    }

    @Override
    public int getItemCount() {
        return articleDetails.length;
    }

    public class ArticleDetailsHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView articleText;
        TextView articlePrice;
        public ArticleDetailsHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.article_image);
            articleText = itemView.findViewById(R.id.article_txt_id);
            articlePrice = itemView.findViewById(R.id.article_price_txt);
        }
    }
}
