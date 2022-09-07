package com.binus.hewanku.DetailMenu.DetailAnimal.Cat;

import com.binus.hewanku.R;

import java.util.ArrayList;

public class CatData {
    private static final String[] activityName = {
            "Sphynx",
            "Persian",
            "Exotic Shorthair",
            "Siamese",
            "Ragdoll",
    };

    private static final String[] activityDetail = {
            "Known as the hairless cat, the Sphynx is unmistakable. They’re friendly, outgoing, and intelligent. They also love to be the center of attention – they might even get in trouble to make sure you’re watching!",
            "Persians are one of the most popular cat breeds, known for their sweet, gentle personalities and adorable expressions. These long-haired cats tend to prefer it when it’s calm and quiet, making them excellent lap cats.",
            "Sweet, quiet, and affectionate, the Exotic Shorthair is very similar to the Persian cat, who’s bred in almost the same way (except for their coat). Exotic Shorthairs are loyal companions who love to spend time with you.",
            "According to the CFA, the Siamese cat is known for its striking blue eyes, inquisitive personality, and loving nature. The CFA calls the Siamese the “quintessential people cat.”",
            "Ragdolls are gentle, laid-back cats that love to follow you wherever you go. They’re great lap cats who’ve been known to greet family members at the door. Plus, they can learn to play fetch!",
    };

    private static final int[] activityImg = {
            R.drawable.spynx_cat,
            R.drawable.persian_cat,
            R.drawable.exotic_cat,
            R.drawable.siamese_cat,
            R.drawable.ragdoll_cat,
    };

    public static ArrayList<Cat> getListData() {
        ArrayList<Cat> list = new ArrayList<>();
        for (int position = 0; position < activityName.length; position++) {
            Cat cat = new Cat();
            cat.setName(activityName[position]);
            cat.setDetail(activityDetail[position]);
            cat.setPhoto(activityImg[position]);
            list.add(cat);
        }
        return list;
    }
}
