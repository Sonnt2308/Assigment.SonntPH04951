package com.example.quynh.assigment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quynh.assigment.R;
import com.example.quynh.assigment.adapter.AdapterCategory;
import com.example.quynh.assigment.model.FragmentCategory;
import com.example.quynh.assigment.model.HDWALLPAPER;
import com.example.quynh.assigment.retrofit.ApiClient;
import com.example.quynh.assigment.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fr_Category extends Fragment {
    RecyclerView recyclerView;
    AdapterCategory adapter;
    List<HDWALLPAPER> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_category,container,false);

        recyclerView = view.findViewById(R.id.rc_category);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<FragmentCategory> call = apiService.getCategory();
        call.enqueue(new Callback<FragmentCategory>() {

            @Override
            public void onResponse(Call<FragmentCategory> call, Response<FragmentCategory> response) {
                list = response.body().getHDWALLPAPER();
                adapter = new AdapterCategory(Fr_Category.this, list);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

                Toast.makeText(getContext(), "TRUE", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<FragmentCategory> call, Throwable t) {
                Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }









}

