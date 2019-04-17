package com.example.quynh.assigment.retrofit;

import com.example.quynh.assigment.model.FragmentCategory;
import com.example.quynh.assigment.model.model_about.FragmentAbout;
import com.example.quynh.assigment.model.model_gift.FragmentGift;
import com.example.quynh.assigment.model.model_latest.FragmentLatest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/api.php?cat_list")
    Call<FragmentCategory> getCategory();

    @GET("/api.php?latest")
    Call<FragmentLatest> getLatest();

    @GET("/api.php?gif_list")
    Call<FragmentGift> getGift();

    @GET("/api.php")
    Call<FragmentAbout> getAbout();
}
