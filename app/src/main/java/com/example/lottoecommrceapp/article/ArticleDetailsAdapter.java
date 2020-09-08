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
import com.example.lottoecommrceapp.HomeActivity;
import com.example.lottoecommrceapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class ArticleDetailsAdapter extends RecyclerView.Adapter<ArticleDetailsAdapter.ArticleDetailsHolder> {

    public static String ARTICLE_NAME = "articleTitle";
    public static  String ARTICLE_PRICE = "standardPrice";
    public static  String ARTICLE_IMAGE_NAME = "articleMasterImage";
    public static  String ARTICLE_ID = "articleId";
    public static  String ARTICLE_DISCOUNT_RATE = "discountRate";
    public static  String ARTICLE_DISCOUNT_PRICE = "discountPrice";
    public static String ARTICLE_DESCRIPTION = "description";
    private static final String ImgUrl = "http://192.168.5.27/Likhon/";
    @NonNull
    List<ArticleDetails> lista = new ArrayList<>();
    Context context;
    public boolean showShimmer = true;
    private onItemClickListener mListner;


    public interface onItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListner(onItemClickListener listner){
        this.mListner = listner;
    }



    public ArticleDetailsAdapter(@NonNull Context context,  List<ArticleDetails> lista) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public ArticleDetailsAdapter.ArticleDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


           LayoutInflater inflater = LayoutInflater.from(parent.getContext());

           View view = inflater.inflate(R.layout.card_article_layout, parent, false);

           return new ArticleDetailsHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ArticleDetailsAdapter.ArticleDetailsHolder holder, int position) {
        if(showShimmer){
            holder.shimmerFrameLayout.startShimmer();
        }else {
            holder.shimmerFrameLayout.stopShimmer();
            holder.shimmerFrameLayout.setShimmer(null);
            holder.articleText.setBackground(null);
            holder.articleText.setText(lista.get(position).getArticleSubtitle());
            holder.articlePrice.setBackground(null);
            holder.articlePrice.setText(Integer.toString(lista.get(position).getStandardPrice()));
            holder.cardImage.setBackground(null);
            Glide.with(holder.cardImage.getContext()).load(ImgUrl + lista.get(position).getArticleMasterImage())
                    .fitCenter()
                    .into(holder.cardImage);
        }
    }

    @Override
    public int getItemCount() {
        int SHIMMER_ITEM_NUMBER = 10;
        return showShimmer?SHIMMER_ITEM_NUMBER:lista.size();
    }

    public class ArticleDetailsHolder extends RecyclerView.ViewHolder {
        ShimmerFrameLayout shimmerFrameLayout;
        ImageView cardImage;
        TextView articleText;
        TextView articlePrice;
        public ArticleDetailsHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.article_image);
            articleText = itemView.findViewById(R.id.article_txt_id);
            articlePrice = itemView.findViewById(R.id.article_price_txt);
            shimmerFrameLayout = itemView.findViewById(R.id.shimmer_view_container);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListner!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListner.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
