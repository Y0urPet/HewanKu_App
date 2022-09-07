package com.binus.hewanku.MainMenu.HomeRecyclerView;

import com.binus.hewanku.R;

import java.util.ArrayList;

public class TopActivityData {
    private static final String[] activityName = {
            "Dentist For Dog Discount 30%",
            "Anti Lice Shower Discount 40%",
            "Health Check Up Discount 20%",
            "Rabies Vaccine for Dog Discount 50%"
    };

    private static final String[] activityDesc = {
            "Just like us, a dog’s dental health is linked with his overall physical health. Unfortunately, periodontal disease starts to impact many dogs within their first few years. This can result in grave negative consequences for their physical health and wellbeing.",
            "Insecticide shampoos and lime-sulfur dips are generally considered safe and effective for the removal of lice on dogs. They should generally be used weekly for a period of four to six weeks. Combing through the fur with a lice comb after each treatment can remove dead lice from the fur.",
            "Regular health checks give pets and their owners the best chance of preventing, detecting and treating any possible illnesses, both immediately and in the future. A full exam allows your vet to take a closer look at your pet and gives you the opportunity to ask about any unusual behaviour.",
            "By choosing to vaccinate your pet against rabies, you are not only protecting him from becoming unwell in the even that he is bit by a wild animal carrying the disease, you are also protecting other animals that he may come into contact with."
    };

    private static final int[] activityImg = {
            R.drawable.act1,
            R.drawable.act2,
            R.drawable.act3,
            R.drawable.act4,
    };

    public static ArrayList<TopActivity> getListData() {
        ArrayList<TopActivity> list = new ArrayList<>();
        for (int position = 0; position < activityName.length; position++) {
            TopActivity topActivity = new TopActivity();
            topActivity.setName(activityName[position]);
            topActivity.setDetail(activityDesc[position]);
            topActivity.setPhoto(activityImg[position]);
            list.add(topActivity);
        }
        return list;
    }
}
