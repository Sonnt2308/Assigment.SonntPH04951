package com.example.quynh.assigment.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.quynh.assigment.R;
import com.example.quynh.assigment.fragment.Fr_Category;
import com.example.quynh.assigment.fragment.Fr_Gift;
import com.example.quynh.assigment.fragment.Gift_FullScreen;
import com.example.quynh.assigment.model.model_gift.HDWALLPAPER;


import java.util.List;

public class AdapterGift extends RecyclerView.Adapter<AdapterGift.ViewHolder> {

    Fr_Gift context;
    List<HDWALLPAPER> list;

    public AdapterGift(Fr_Gift context, List<HDWALLPAPER> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterGift.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_gift,parent,false);
        return new AdapterGift.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGift.ViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getGifImage())
                .into(holder.imgGift);

        holder.imgGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getContext(), "jghdfjgdfjghdf", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgGift;
        public ViewHolder(View itemView) {
            super(itemView);
            imgGift = itemView.findViewById(R.id.img_gift);
        }
    }

}
