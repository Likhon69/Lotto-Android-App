package com.example.lottoecommrceapp.article;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lottoecommrceapp.R;

public class ArticleVariantAdapter extends RecyclerView.Adapter<ArticleVariantAdapter.ArticleVariantViewHolder> {

    private ArticleVariant[] articleVariants;
    int row_index =-1 ;

    public ArticleVariantAdapter(ArticleVariant[] articleVariants) {
        this.articleVariants = articleVariants;
    }

    @NonNull
    @Override
    public ArticleVariantAdapter.ArticleVariantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.size_view,parent,false);
        return new ArticleVariantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleVariantAdapter.ArticleVariantViewHolder holder, final int position) {
     ArticleVariant articleVariant = articleVariants[position];
     holder.textSizeView.setText(Integer.toString(articleVariant.getSize()));



     if(row_index==position){
         holder.frameLayout.setBackgroundColor(Color.parseColor("#FF4500"));
     }else{
         holder.frameLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
     }
    }

    @Override
    public int getItemCount() {
        return articleVariants.length;
    }

    public class ArticleVariantViewHolder extends RecyclerView.ViewHolder {
         TextView textSizeView;
         FrameLayout frameLayout;
        public ArticleVariantViewHolder(@NonNull View itemView) {
            super(itemView);
            textSizeView = itemView.findViewById(R.id.size_text);
            frameLayout = itemView.findViewById(R.id.size_change_color);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     row_index=getAdapterPosition();
                     notifyDataSetChanged();
                }
            });
        }
    }
}
