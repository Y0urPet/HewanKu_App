package com.binus.hewanku.DetailMenu.DetailAnimal.Turtle;

import com.binus.hewanku.R;

import java.util.ArrayList;

public class TurtleData {
    private static final String[] activityName = {
            "Ambon Turtles",
            "Forsteni Turtles",
            "Pig Muzzle Tortoise",
            "Sun Tortoise",
            "Aquatic Turtles",
    };

    private static final String[] activityDetail = {
            "Who doesn’t know Ambon turtles? These turtles are so much sold on the market. Almost all levels of society can actually buy these turtles because they are affordable.",
            "Forsteni turtle. Indeed, not all hobbyists have this turtle because the price is quite tempting. The tantalizing point is that you can reach a pretty deep pocket. The turtle that has a Latin name, Indotestudo forstenii has a base on the island of Sulawesi. Is it only on the island of Sulawesi?",
            "Some have called Pork Muzzle Turtles. The important thing is that both refer to Carettochelys insculpta.",
            "Sun tortoises are also commonly referred to as thorn turtles because the edges of the shell are sharp spikes. This turtle has the scientific name Heosemys spinosa.",
            "This flat-shaped tortoise comes from Kalimantan. This animal has yellowish plastro leaves. That is why people often mistakenly think that this aquatic turtle is a leaf turtle. These turtles that live in water have the Latin name Notochelys platynota-semi-aquatic.",

    };

    private static final int[] activityImg = {
            R.drawable.ambon_turtle,
            R.drawable.forstenii_turtle,
            R.drawable.pig_muzzle_turtle,
            R.drawable.sun_turtle,
            R.drawable.aquatic_turtle,
    };

    public static ArrayList<Turtle> getListData() {
        ArrayList<Turtle> list = new ArrayList<>();
        for (int position = 0; position < activityName.length; position++) {
            Turtle turtle = new Turtle();
            turtle.setName(activityName[position]);
            turtle.setDetail(activityDetail[position]);
            turtle.setPhoto(activityImg[position]);
            list.add(turtle);
        }
        return list;
    }
}
