package com.binus.hewanku.DetailMenu.DetailAnimal.Bird;

import com.binus.hewanku.R;
import java.util.ArrayList;

public class BirdData {
    private static final String[] activityName = {
            "Parakeet",
            "Cockatiel",
            "Cockatoo",
            "Lovebird",
            "Finch",
    };

    private static final String[] activityDetail = {
            "Also known as \"Budgies,\" according to PetSmart, Parakeets can quickly become your family's best friend with their sweet gestures and tunes. With practice, Parakeets can nibble out of your hand, whistle in tune, and learn basic commands. How can you resist?",
            "A perfect beginner bird, PetSmart notes that Cockatiels love playing with their owners, and should be given at least one hour of attention a day. These bright birds love hanging out outside of their cage, so consider purchasing a perch for them to hang out on and socialize, even if you're not actively playing with them.",
            "A bird of style, the Cockatoos are one attention-grabbing — and attention-loving — animal. According to The Spruce, Cockatoos are quick to bond with their owners and thrive on their relationships. In fact, if they don't receive enough attention they can become depressed and begin plucking out their feathers as a sign of distress. But as long as these birds are getting love for at least an hour or so a day, they'll become a member of the family in no time.",
            "If you're looking for a companion for life, stop your search now. Pet Smart notes that there's no bond-breaking when Lovebirds make a connection with their partners — whether it's with another bird of their kind or with their human. These creatures love bathing, so give them a bowl of water to wash in two or three times a week for some playtime!",
            "If your family is looking for a bird that doesn't require much attention, the Finch might be the perfect fit. While its beautiful look and charming chirps are fun to watch, The Spruce notes that Finches prefer to stay inside their cage, away from human interaction. If you want a bird of a similar size, but with a more hands-on experience, check out the Parakeet.",
    };

    private static final int[] activityImg = {
            R.drawable.parakeet_bird,
            R.drawable.cockatiel_bird,
            R.drawable.cockatoo_bird,
            R.drawable.lovebird_bird,
            R.drawable.finch_bird,
    };

    public static ArrayList<Bird> getListData() {
        ArrayList<Bird> list = new ArrayList<>();
        for (int position = 0; position < activityName.length; position++) {
            Bird bird = new Bird();
            bird.setName(activityName[position]);
            bird.setDetail(activityDetail[position]);
            bird.setPhoto(activityImg[position]);
            list.add(bird);
        }
        return list;
    }
}
