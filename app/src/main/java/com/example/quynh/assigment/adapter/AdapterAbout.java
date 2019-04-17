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
import com.example.quynh.assigment.fragment.Fr_AboutUs;
import com.example.quynh.assigment.fragment.Fr_Category;
import com.example.quynh.assigment.model.model_about.HDWALLPAPER;


import java.util.List;

public class AdapterAbout extends RecyclerView.Adapter<AdapterAbout.ViewHolder> {

    Fr_AboutUs context;
    List<HDWALLPAPER> list;

    public AdapterAbout(Fr_AboutUs context, List<HDWALLPAPER> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterAbout.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_aboutus,parent,false);
        return new AdapterAbout.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAbout.ViewHolder holder, int position) {

        Glide.with(context)
                .load(list.get(position).getAppLogo())
                .into(holder.imgLogo);

        holder.tvName.setText(list.get(position).getAppName());
        holder.tvVersion.setText(list.get(position).getAppVersion());
        holder.tvCompany.setText(list.get(position).getAppAuthor());
        holder.tvEmail.setText(list.get(position).getAppEmail());
        holder.tvWebsite.setText(list.get(position).getAppWebsite());
        holder.tvContact.setText(list.get(position).getAppContact());
        holder.tvAbout.setText(list.get(position).getAppDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgLogo;
        private TextView tvName, tvVersion, tvCompany, tvEmail, tvWebsite, tvContact, tvAbout;
        public ViewHolder(View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.img_Logo);
            tvName = itemView.findViewById(R.id.tv_Name);
            tvVersion = itemView.findViewById(R.id.tv_Version);
            tvCompany = itemView.findViewById(R.id.tv_Conpany);
            tvEmail = itemView.findViewById(R.id.tv_Emaill);
            tvWebsite= itemView.findViewById(R.id.tv_Website);
            tvContact = itemView.findViewById(R.id.tv_Contact);
            tvAbout = itemView.findViewById(R.id.tv_About);
        }
    }
}



