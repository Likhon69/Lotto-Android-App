package com.example.lottoecommrceapp.article;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lottoecommrceapp.R;

public class ArticleVariantAdapter extends RecyclerView.Adapter<ArticleVariantAdapter.ArticleVariantViewHolder> {

    private ArticleVariant[] articleVariants;

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
    public void onBindViewHolder(@NonNull ArticleVariantAdapter.ArticleVariantViewHolder holder, int position) {
     ArticleVariant articleVariant = articleVariants[position];
     holder.textSizeView.setText(Integer.toString(articleVariant.getSize()));
    }

    @Override
    public int getItemCount() {
        return articleVariants.length;
    }

    public class ArticleVariantViewHolder extends RecyclerView.ViewHolder {
         TextView textSizeView;
        public ArticleVariantViewHolder(@NonNull View itemView) {
            super(itemView);
            textSizeView = itemView.findViewById(R.id.size_text);
        }
    }
}
