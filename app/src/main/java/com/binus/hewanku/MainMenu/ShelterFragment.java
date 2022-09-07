package com.binus.hewanku.MainMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.hewanku.DetailMenu.DetailAnimal.Bird.BirdActivity;
import com.binus.hewanku.DetailMenu.DetailAnimal.Cat.CatActivity;
import com.binus.hewanku.DetailMenu.DetailAnimal.Dog.DogActivity;
import com.binus.hewanku.DetailMenu.DetailAnimal.Turtle.TurtleActivity;
import com.binus.hewanku.MainMenu.ShelterRecyclerView.Animal;
import com.binus.hewanku.MainMenu.ShelterRecyclerView.AnimalData;
import com.binus.hewanku.MainMenu.ShelterRecyclerView.ShelterAdapter;
import com.binus.hewanku.R;

import java.util.ArrayList;

public class ShelterFragment extends Fragment{

    private final ArrayList<Animal> list = new ArrayList<>();
    public static String name_intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shelter, container, false);

        RecyclerView rvActivity = view.findViewById(R.id.rv_shelter);
        rvActivity.setHasFixedSize(true);

        list.addAll(AnimalData.getListData());

        rvActivity.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ShelterAdapter shelterAdapter = new ShelterAdapter(list);
        rvActivity.setAdapter(shelterAdapter);

        shelterAdapter.setOnItemClickCallBack(new ShelterAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Animal data) {
                String name = data.getName();
                if (name.equals("Dog")){
                    Intent moveIntent = new Intent(ShelterFragment.this.getActivity(), DogActivity.class);
                    name_intent = "Dog";
                    startActivity(moveIntent);
                } else if (name.equals("Cat")){
                    Intent moveIntent = new Intent(ShelterFragment.this.getActivity(), CatActivity.class);
                    name_intent = "Cat";
                    startActivity(moveIntent);
                } else if (name.equals("Bird")){
                    Intent moveIntent = new Intent(ShelterFragment.this.getActivity(), BirdActivity.class);
                    name_intent = "Bird";
                    startActivity(moveIntent);
                } else if (name.equals("Turtle")){
                    Intent moveIntent = new Intent(ShelterFragment.this.getActivity(), TurtleActivity.class);
                    name_intent = "Turtle";
                    startActivity(moveIntent);
                }
            }
        });

        return view;
    }
}