package com.binus.hewanku.MainMenu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.binus.hewanku.DetailMenu.DetailService.GroomingActivity;
import com.binus.hewanku.DetailMenu.TransactionHistory.TransactionActivity;
import com.binus.hewanku.LoginSystem.AccountData;
import com.binus.hewanku.LoginSystem.MainActivity;
import com.binus.hewanku.R;

public class ProfileFragment extends Fragment implements AccountData,View.OnClickListener{

    CardView transaction_history;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView nama = view.findViewById(R.id.name_profile);
        TextView email = view.findViewById(R.id.email_profile);
        transaction_history = view.findViewById(R.id.transaction_history);
        String currentEmail = MainActivity.getCurrentEmail();


        email.setText(currentEmail);
        nama.setText(accountName.get(currentEmail));
        transaction_history.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.transaction_history){
            Intent moveIntent = new Intent(ProfileFragment.this.getActivity(), TransactionActivity.class);
            startActivity(moveIntent);
        }
    }
}