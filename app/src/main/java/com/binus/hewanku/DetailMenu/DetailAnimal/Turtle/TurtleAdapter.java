package com.binus.hewanku.DetailMenu.DetailAnimal.Turtle;

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

public class TurtleAdapter extends RecyclerView.Adapter<TurtleAdapter.CardViewHolder> {
    ArrayList<Turtle> turtles;
    private OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public TurtleAdapter(ArrayList<Turtle> list) {
        this.turtles = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_animal_shelter,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Turtle turtle = turtles.get(position);

        Glide.with(holder.itemView.getContext())
                .load(turtle.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvName.setText(turtle.getName());
        holder.tvDetail.setText(turtle.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onItemClicked((turtles.get(holder.getAdapterPosition())));
            }
        });

    }

    @Override
    public int getItemCount() {
        return turtles.size();
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

    public interface OnItemClickCallBack {
        void onItemClicked(Turtle data);
    }
}
