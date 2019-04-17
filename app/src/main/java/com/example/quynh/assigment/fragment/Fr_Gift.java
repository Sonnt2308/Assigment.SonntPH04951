package com.example.quynh.assigment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quynh.assigment.R;
import com.example.quynh.assigment.adapter.AdapterGift;
import com.example.quynh.assigment.adapter.AdapterLatest;
import com.example.quynh.assigment.model.model_gift.FragmentGift;
import com.example.quynh.assigment.model.model_gift.HDWALLPAPER;
import com.example.quynh.assigment.retrofit.ApiClient;
import com.example.quynh.assigment.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fr_Gift extends Fragment {
    RecyclerView recyclerView;
    AdapterGift adapter;
    List<HDWALLPAPER> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_latest,container,false);

        recyclerView = view.findViewById(R.id.rc_latest);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<FragmentGift> call = apiService.getGift();
        call.enqueue(new Callback<FragmentGift>() {

            @Override
            public void onResponse(Call<FragmentGift> call, Response<FragmentGift> response) {
                list = response.body().getHDWALLPAPER();
                adapter = new AdapterGift(Fr_Gift.this,list);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

                Toast.makeText(getContext(), "TRUE", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<FragmentGift> call, Throwable t) {
                Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }}
