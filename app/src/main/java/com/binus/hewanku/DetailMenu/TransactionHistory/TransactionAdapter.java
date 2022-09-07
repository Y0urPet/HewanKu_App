package com.binus.hewanku.DetailMenu.TransactionHistory;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.hewanku.R;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.CardViewHolder> implements TransactionHistory {
    ArrayList<Transaction> listTransaction;
    private TransactionAdapter.OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(TransactionAdapter.OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public TransactionAdapter(ArrayList<Transaction> list) {
        this.listTransaction = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_transaction,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Transaction transaction = listTransaction.get(position);

        Log.i("TransactionAdapter",activityName.get(position));

        holder.tv_status.setText(transaction.getStatus());
        holder.tv_animal_type.setText(transaction.getAnimalType());
        holder.tv_animal_name.setText(transaction.getAnimalName());
        holder.tv_date.setText(transaction.getDate());
        holder.tv_time.setText(transaction.getTime());
        holder.tv_petshop_location.setText(transaction.getPetshopLocation());
        holder.tv_payment_method.setText(transaction.getPaymentMethod());
        holder.id_result.setText(transaction.getId());

        holder.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.hiddenView.getVisibility() == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(holder.cardView, new AutoTransition());
                    holder.hiddenView.setVisibility(View.GONE);
                    holder.arrow.setImageResource(R.drawable.ic_baseline_expand_more_24);
                } else {
                    TransitionManager.beginDelayedTransition(holder.cardView, new AutoTransition());
                    holder.hiddenView.setVisibility(View.VISIBLE);
                    holder.arrow.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onItemClicked((listTransaction.get(holder.getAdapterPosition())));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listTransaction.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        TextView tv_status;
        TextView tv_animal_type;
        TextView tv_animal_name;
        TextView tv_date;
        TextView tv_time;
        TextView tv_petshop_location;
        TextView tv_payment_method;
        ImageButton arrow;
        LinearLayout hiddenView;
        CardView cardView;
        TextView id_result;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_status = itemView.findViewById(R.id.heading);
            tv_animal_type = itemView.findViewById(R.id.animal_type);
            tv_animal_name = itemView.findViewById(R.id.animal_name);
            tv_date = itemView.findViewById(R.id.result_date);
            tv_time = itemView.findViewById(R.id.result_time);
            tv_petshop_location = itemView.findViewById(R.id.petshop_location);
            tv_payment_method = itemView.findViewById(R.id.payment_method);
            cardView = itemView.findViewById(R.id.base_cardview);
            arrow = itemView.findViewById(R.id.arrow_button);
            hiddenView = itemView.findViewById(R.id.hidden_view);
            id_result = itemView.findViewById(R.id.result_id);
        }
    }

    public interface OnItemClickCallBack {
        void onItemClicked(Transaction data);
    }
}
