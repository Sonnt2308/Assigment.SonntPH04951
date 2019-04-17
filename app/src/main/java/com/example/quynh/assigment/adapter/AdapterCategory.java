package com.example.quynh.assigment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quynh.assigment.R;
import com.example.quynh.assigment.fragment.Fr_Category;
import com.example.quynh.assigment.fragment.Fr_Latest;
import com.example.quynh.assigment.model.HDWALLPAPER;

import java.util.List;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.ViewHolder> {

    Fr_Category context;
    List<HDWALLPAPER>list;

    public AdapterCategory(Fr_Category context, List<HDWALLPAPER> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_category,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getCategoryName());
        Glide.with(context)
                .load(list.get(position).getCategoryImageThumb())
                .into(holder.imgCategory);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgCategory;
        private TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            imgCategory = itemView.findViewById(R.id.img_category);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}


