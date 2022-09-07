package com.binus.hewanku.MainMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.hewanku.MainMenu.HomeRecyclerView.HomeAdapter;
import com.binus.hewanku.MainMenu.HomeRecyclerView.TopActivity;
import com.binus.hewanku.MainMenu.HomeRecyclerView.TopActivityData;
import com.binus.hewanku.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private final ArrayList<TopActivity> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView rvActivity = view.findViewById(R.id.rv_item);
        rvActivity.setHasFixedSize(true);

        list.addAll(TopActivityData.getListData());

        rvActivity.setLayoutManager(new LinearLayoutManager(view.getContext()));
        HomeAdapter homeAdapter = new HomeAdapter(list);
        rvActivity.setAdapter(homeAdapter);

        return view;
    }
}