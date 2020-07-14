package com.example.lottoecommrceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_home, container, false);

       /* RecyclerView categoryRecyclerView  = view.findViewById(R.id.category);
        LinearLayoutManager layoutManager = new LinearLayoutManager((getActivity()));
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);
        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Kid's"));
        categoryModelList.add(new CategoryModel("link2","Children's"));

        categoryModelList.add(new CategoryModel("link3","Women's"));
        categoryModelList.add(new CategoryModel("link4","Men's"));
        categoryModelList.add(new CategoryModel("link5","Accessories"));*/


        return view;
    }
}
