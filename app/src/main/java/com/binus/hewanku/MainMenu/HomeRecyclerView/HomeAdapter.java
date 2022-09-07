package com.binus.hewanku.MainMenu.HomeRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.hewanku.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.CardViewHolder> {
    ArrayList<TopActivity> listTopActivities;

    public HomeAdapter(ArrayList<TopActivity> list) {
        this.listTopActivities = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_home,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        TopActivity topActivity = listTopActivities.get(position);

        Glide.with(holder.itemView.getContext())
                .load(topActivity.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvName.setText(topActivity.getName());
        holder.tvDetail.setText(topActivity.getDetail());
    }

    @Override
    public int getItemCount() {
        return listTopActivities.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView tvName,tvDetail;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}
