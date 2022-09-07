package com.binus.hewanku.MainMenu.ClinicRecyclerView.ShelterRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.hewanku.MainMenu.ClinicFragment;
import com.binus.hewanku.MainMenu.ShelterRecyclerView.Animal;
import com.binus.hewanku.MainMenu.ShelterRecyclerView.ShelterAdapter;
import com.binus.hewanku.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ClinicAdapter extends RecyclerView.Adapter<ClinicAdapter.CardViewHolder> {
    ArrayList<Service> listService;

    private ClinicAdapter.OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(ClinicAdapter.OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public ClinicAdapter(ArrayList<Service> list) {
        this.listService = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_clinic,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Service service = listService.get(position);

        Glide.with(holder.itemView.getContext())
                .load(service.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvName.setText(service.getName());

        Glide.with(holder.itemView.getContext())
                .load(service.getBackgroundText())
                .apply(new RequestOptions().override(350,550))
                .into(holder.backgroundText);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onItemClicked((listService.get(holder.getAdapterPosition())));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listService.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        ImageView backgroundText;
        TextView tvName;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            backgroundText = itemView.findViewById(R.id.img_background_photo);
        }
    }

    public interface OnItemClickCallBack {
        void onItemClicked(Service data);
    }
}
