package com.binus.hewanku.DetailMenu.TransactionHistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.binus.hewanku.LoginSystem.MainActivity;
import com.binus.hewanku.MainMenu.MainMenuActivity;
import com.binus.hewanku.R;

import java.util.ArrayList;

public class TransactionActivity extends AppCompatActivity implements TransactionHistory,View.OnClickListener{

    private RecyclerView rvTransaction;
    private ConstraintLayout hidden_content;
    ImageView btn_back;
    private final ArrayList<Transaction> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        rvTransaction = findViewById(R.id.rv_transaction);
        hidden_content = findViewById(R.id.hidden_content);
        btn_back = findViewById(R.id.btn_back_to_home);

        btn_back.setOnClickListener(this);

        if (activityName.size() <= 0){
            hidden_content.setVisibility(View.VISIBLE);
        } else {
            hidden_content.setVisibility(View.GONE);
        }

        list.addAll(TransactionData.getListData());
        rvTransaction.setHasFixedSize(true);
        showRecyclerCardView();
    }

    public void showRecyclerCardView() {
        rvTransaction.setLayoutManager(new LinearLayoutManager(this));
        TransactionAdapter transactionAdapter = new TransactionAdapter(list);
        rvTransaction.setAdapter(transactionAdapter);

        transactionAdapter.setOnItemClickCallBack(new TransactionAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Transaction data) {
                showSelectedDate(data);
            }
        });


    }
    private void showSelectedDate(Transaction transaction) {
        Toast.makeText(this, "Open Transaction in " + transaction.getDate(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_back_to_home){
            Intent moveIntent = new Intent(TransactionActivity.this, MainMenuActivity.class);
            startActivity(moveIntent);
        }
    }
}