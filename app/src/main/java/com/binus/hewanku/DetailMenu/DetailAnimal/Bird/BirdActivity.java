package com.binus.hewanku.DetailMenu.DetailAnimal.Bird;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.hewanku.DetailMenu.DetailAnimal.DetailAnimalPage;
import com.binus.hewanku.R;

import java.util.ArrayList;

public class BirdActivity extends AppCompatActivity implements BirdList{

    private RecyclerView rvBird;
    private final ArrayList<Bird> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird);
        rvBird = findViewById(R.id.rv_bird);

        list.addAll(BirdData.getListData());
        rvBird.setHasFixedSize(true);
        showRecyclerCardView();

        if (personalitys.size() <= 0){
            //1.
            personalitys.put("Parakeet","Even-tempered, charming, mischievous, and loving");
            energy_levels.put("Parakeet","Somewhat active; this dog are not exactly natural athletes,\nbut they do have strong legs and endless curiosity—exercise\nboth regularly");
            good_with_childrens.put("Parakeet","Better with supervision");
            good_with_other_dogs.put("Parakeet","With supervision");
            sheddings.put("Parakeet","Regularly");
            groomings.put("Parakeet","Weekly brushing");
            trainabilitys.put("Parakeet","Agreeable");
            heights.put("Parakeet","10-13 inches");
            weights.put("Parakeet","14-18 pounds");
            life_expectancys.put("Parakeet","13-15 years");
            barking_levels.put("Parakeet","Medium");
            //2.
            personalitys.put("Cockatiel","Merry, friendly, and curious");
            energy_levels.put("Cockatiel","Very Active; This quick, energetic and compact\nhound dog needs plenty of exercises");
            good_with_childrens.put("Cockatiel","Yes");
            good_with_other_dogs.put("Cockatiel","Yes");
            sheddings.put("Cockatiel","Seasonal");
            groomings.put("Cockatiel","Weekly");
            trainabilitys.put("Cockatiel","Response Well");
            heights.put("Cockatiel","13 inches & under, 13-15 inches");
            weights.put("Cockatiel","under 20 pounds (13 inches & under), 20-30 pounds (13-15 inches)");
            life_expectancys.put("Cockatiel","10-15 years");
            barking_levels.put("Cockatiel","Quiet");
            //3.
            personalitys.put("Cockatoo","Intelligent, friendly, and devoted.");
            energy_levels.put("Cockatoo","Very Active; This dog is active and energetic and needs daily exercise.");
            good_with_childrens.put("Cockatoo","Yes");
            good_with_other_dogs.put("Cockatoo","Yes");
            sheddings.put("Cockatoo","Seasonal");
            groomings.put("Cockatoo","Occasional");
            trainabilitys.put("Cockatoo","Eager To Please");
            heights.put("Cockatoo","23-24 inches (male), 21.5-22.5 inches (female)");
            weights.put("Cockatoo","65-75 pounds (male), 55-65 pounds (female)");
            life_expectancys.put("Cockatoo","10-12 years");
            barking_levels.put("Cockatoo","Barks When Necessary");
            //4.
            personalitys.put("Lovebird","Calm, courageous, and friendly; dignified but amusing");
            energy_levels.put("Lovebird","Not Very Active; this dog won’t beg to be exercised,\nbut they require regular walks and the occasional romp");
            good_with_childrens.put("Lovebird","Yes");
            good_with_other_dogs.put("Lovebird","Yes");
            sheddings.put("Lovebird","Seasonal");
            groomings.put("Lovebird","Weekly");
            trainabilitys.put("Lovebird","Response Well");
            heights.put("Lovebird","14-15 inches");
            weights.put("Lovebird","50 pounds (male), 40 pounds (female)");
            life_expectancys.put("Lovebird","8-10 years");
            barking_levels.put("Lovebird","Likes To Be Vocal");
            //5.
            personalitys.put("Finch","Friendly and outgoing, Labs play well with others");
            energy_levels.put("Finch","Very active; this dog are high-spirited and not afraid to show it");
            good_with_childrens.put("Finch","Yes");
            good_with_other_dogs.put("Finch","With supervision");
            sheddings.put("Finch","Regularly");
            groomings.put("Finch","Weekly brushing");
            trainabilitys.put("Finch","Eager to please");
            heights.put("Finch","22.5-24.5 inches (male), 21.5-23.5 inches (female)");
            weights.put("Finch","65-80 pounds (male), 55-70 pounds (female)");
            life_expectancys.put("Finch","10-12 years");
            barking_levels.put("Finch","Barks when necessary");
        }
    }

    public void showRecyclerCardView() {
        rvBird.setLayoutManager(new LinearLayoutManager(this));
        BirdAdapter birdAdapter = new BirdAdapter(list);
        rvBird.setAdapter(birdAdapter);

        birdAdapter.setOnItemClickCallBack(new BirdAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Bird data) {
                showSelectedDate(data);
                Intent moveIntent = new Intent(BirdActivity.this, DetailAnimalPage.class);
                moveIntent.putExtra("animalName",data.getName());
                moveIntent.putExtra("animalDesc",data.getDetail());
                moveIntent.putExtra("animalImg",data.getPhoto());
                moveIntent.putExtra("personality",personalitys.get(data.getName()));
                moveIntent.putExtra("energy_level",energy_levels.get(data.getName()));
                moveIntent.putExtra("good_with_children",good_with_childrens.get(data.getName()));
                moveIntent.putExtra("good_with_other_dog",good_with_other_dogs.get(data.getName()));
                moveIntent.putExtra("shedding",sheddings.get(data.getName()));
                moveIntent.putExtra("grooming",groomings.get(data.getName()));
                moveIntent.putExtra("trainability",trainabilitys.get(data.getName()));
                moveIntent.putExtra("height",heights.get(data.getName()));
                moveIntent.putExtra("weights",weights.get(data.getName()));
                moveIntent.putExtra("life_expectancys",life_expectancys.get(data.getName()));
                moveIntent.putExtra("barking_levels",barking_levels.get(data.getName()));
                startActivity(moveIntent);
            }
        });


    }
    private void showSelectedDate(Bird bird) {
        Toast.makeText(this, "Clicking " + bird.getName(), Toast.LENGTH_SHORT).show();
    }
}