package com.example.quynh.assigment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quynh.assigment.R;
import com.example.quynh.assigment.adapter.AdapterAbout;
import com.example.quynh.assigment.adapter.AdapterCategory;
import com.example.quynh.assigment.model.FragmentCategory;
import com.example.quynh.assigment.model.model_about.FragmentAbout;
import com.example.quynh.assigment.model.model_about.HDWALLPAPER;
import com.example.quynh.assigment.retrofit.ApiClient;
import com.example.quynh.assigment.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fr_AboutUs extends Fragment {
    RecyclerView recyclerView;
    AdapterAbout adapter;
    List<HDWALLPAPER> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aboutus,container,false);

        recyclerView = view.findViewById(R.id.rc_aboutus);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<FragmentAbout> call = apiService.getAbout();
        call.enqueue(new Callback<FragmentAbout>() {

            @Override
            public void onResponse(Call<FragmentAbout> call, Response<FragmentAbout> response) {
                list = response.body().getHDWALLPAPER();
                adapter = new AdapterAbout(Fr_AboutUs.this, list);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

                Toast.makeText(getContext(), "TRUE", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<FragmentAbout> call, Throwable t) {
                Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
