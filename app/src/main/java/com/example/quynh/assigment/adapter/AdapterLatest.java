package com.example.quynh.assigment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.quynh.assigment.R;
import com.example.quynh.assigment.fragment.Fr_Latest;
import com.example.quynh.assigment.model.model_latest.HDWALLPAPER_LATEST;

import java.util.List;

public class AdapterLatest extends RecyclerView.Adapter<AdapterLatest.ViewHolder> {

    Fr_Latest context;
    List<HDWALLPAPER_LATEST> list;

    public AdapterLatest(Fr_Latest context, List<HDWALLPAPER_LATEST> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterLatest.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_latest,parent,false);
        return new AdapterLatest.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLatest.ViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getCategoryImageThumb())
                .into(holder.imgLatest);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgLatest;
        public ViewHolder(View itemView) {
            super(itemView);
            imgLatest = itemView.findViewById(R.id.img_latest);
        }
    }
}
