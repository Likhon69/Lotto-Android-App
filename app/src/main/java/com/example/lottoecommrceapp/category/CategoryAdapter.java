package com.example.lottoecommrceapp.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lottoecommrceapp.CategoryModel;
import com.example.lottoecommrceapp.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    @NonNull

    private List<Category> categoryModelList;

    public CategoryAdapter(@NonNull List<Category> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
     holder.categoryImg.setImageResource(categoryModelList.get(position).getCategoryImage());
     holder.categoryName.setText(categoryModelList.get(position).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImg;
        TextView categoryName;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImg = itemView.findViewById(R.id.category_img_id);
            categoryName = itemView.findViewById(R.id.category_txt_id);
        }
    }
}
