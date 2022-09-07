package com.binus.hewanku.MainMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.hewanku.DetailMenu.DetailService.GroomingActivity;
import com.binus.hewanku.MainMenu.ClinicRecyclerView.ShelterRecyclerView.ClinicAdapter;
import com.binus.hewanku.MainMenu.ClinicRecyclerView.ShelterRecyclerView.Service;
import com.binus.hewanku.MainMenu.ClinicRecyclerView.ShelterRecyclerView.ServiceData;
import com.binus.hewanku.R;

import java.util.ArrayList;

public class ClinicFragment extends Fragment {
    private final ArrayList<Service> list = new ArrayList<>();
    TextView title_clinic;
    public static String title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clinic, container, false);

        RecyclerView rvActivity = view.findViewById(R.id.rv_clinic);
        title_clinic = view.findViewById(R.id.title_clinic);
        rvActivity.setHasFixedSize(true);

        list.addAll(ServiceData.getListData());

        rvActivity.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ClinicAdapter clinicAdapter = new ClinicAdapter(list);
        rvActivity.setAdapter(clinicAdapter);

        clinicAdapter.setOnItemClickCallBack(new ClinicAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Service data) {
                String name = data.getName();
                if (name.equals("Grooming Reservation")){
                    title = "Grooming Reservation";
                } else if (name.equals("Medical Check up reservation")){
                    title = "Medical Check up";
                } else if (name.equals("Vaccine Reservation")){
                    title = "Vaccine Reservation";
                } else if (name.equals("MRI Reservation")){
                    title = "MRI Reservation";
                } else if (name.equals("Online Consult")){
                    title = "Online Consult";
                }
                Intent moveIntent = new Intent(ClinicFragment.this.getActivity(), GroomingActivity.class);
                startActivity(moveIntent);
            }
        });

        return view;
    }
}