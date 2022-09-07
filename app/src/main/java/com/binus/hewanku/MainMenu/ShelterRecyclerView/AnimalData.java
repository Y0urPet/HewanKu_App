package com.binus.hewanku.MainMenu.ShelterRecyclerView;

import com.binus.hewanku.R;

import java.util.ArrayList;

public class AnimalData {
    private static final String[] activityName = {
            "Dog",
            "Cat",
            "Bird",
            "Turtle"
    };

    private static final int[] activityImg = {
            R.drawable.dog,
            R.drawable.cat_fix_4,
            R.drawable.bird_fix_8,
            R.drawable.turtle,
    };

    private static final int[] backgroundText = {
            R.drawable.background_animal_2,
            R.drawable.background_animal_2,
            R.drawable.background_animal_2,
            R.drawable.background_animal_2,
    };

    public static ArrayList<Animal> getListData() {
        ArrayList<Animal> list = new ArrayList<>();
        for (int position = 0; position < activityName.length; position++) {
            Animal animal = new Animal();
            animal.setName(activityName[position]);
            animal.setPhoto(activityImg[position]);
            animal.setBackgroundText(backgroundText[position]);
            list.add(animal);
        }
        return list;
    }
}
