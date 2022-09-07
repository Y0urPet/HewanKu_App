package com.binus.hewanku.DetailMenu.DetailAnimal.Dog;

import com.binus.hewanku.R;

import java.util.ArrayList;

public class DogData {
    private static final String[] activityName = {
            "Labrador Retriever",
            "Bulldog",
            "Golden Retriever",
            "Beagle",
            "Pug",

    };

    private static final String[] activityDetail = {
            "The Labrador Retriever is the most popular dog in the United States for a reason. The breed is friendly, patient, and trainable. The breed is extremely versatile, doing everything including hunting, showing, dock diving, tracking, and obedience.",
            "The distinct and wrinkly Bulldog makes a wonderful companion to children. These loyal dogs can adapt to most atmospheres — city or country — and are happy to spend time with their families.",
            "Golden Retrievers originally came into prominence because of the desire for a medium-sized dog that would do well in wild-fowling, both upland game, and waterfowl. Today, the breed’s versatility, intelligence, and agreeable personality suit it for many purposes, and it has become one of the most successful, recognizable, and popular breeds in all areas of competition.",
            "The actual origin of the Beagle seems to be obscure with no reliable documentation on the earliest days of development. Their compact size, short, easy-to-care-for coat, and intelligence make the Beagle an excellent family dog.",
            "The Pug is well described by the phrase “multum in parvo” which means “a lot of dogs in a small space.” He is small but requires no coddling and his roguish face soon wiggles its way into the hearts of men, women, and especially children, for whom this dog seems to have a special affinity. His great reason for living is to be near his people and to please them. He is comfortable in a small apartment or country home alike, and easily adaptable to all situations.",
    };

    private static final int[] activityImg = {
            R.drawable.labrador_retriver_dog,
            R.drawable.bulldog_dog,
            R.drawable.golden_retriver_dog,
            R.drawable.beagle_dog,
            R.drawable.pug_dog,
    };

    public static ArrayList<Dog> getListData() {
        ArrayList<Dog> list = new ArrayList<>();
        for (int position = 0; position < activityName.length; position++) {
            Dog dog = new Dog();
            dog.setName(activityName[position]);
            dog.setDetail(activityDetail[position]);
            dog.setPhoto(activityImg[position]);
            list.add(dog);
        }
        return list;
    }
}
