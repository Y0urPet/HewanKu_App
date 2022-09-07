package com.binus.hewanku.DetailMenu.DetailAnimal.Turtle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.hewanku.DetailMenu.DetailAnimal.DetailAnimalPage;
import com.binus.hewanku.R;

import java.util.ArrayList;

public class TurtleActivity extends AppCompatActivity implements TurtleList{

    private RecyclerView rvTurtle;
    private final ArrayList<Turtle> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        rvTurtle = findViewById(R.id.rv_dog);

        list.addAll(TurtleData.getListData());
        rvTurtle.setHasFixedSize(true);
        showRecyclerCardView();

        if (personalitys.size() <= 0){
            //1.
            personalitys.put("Ambon Turtles","Even-tempered, charming, mischievous, and loving");
            energy_levels.put("Ambon Turtles","Somewhat active; this turtle are not exactly natural athletes,\nbut they do have strong legs and endless curiosity—exercise\nboth regularly");
            good_with_childrens.put("Ambon Turtles","Better with supervision");
            good_with_other_dogs.put("Ambon Turtles","With supervision");
            sheddings.put("Ambon Turtles","Regularly");
            groomings.put("Ambon Turtles","Weekly brushing");
            trainabilitys.put("Ambon Turtles","Agreeable");
            heights.put("Ambon Turtles","10-13 inches");
            weights.put("Ambon Turtles","14-18 pounds");
            life_expectancys.put("Ambon Turtles","13-15 years");
            barking_levels.put("Ambon Turtles","None");
            //2.
            personalitys.put("Forsteni Turtles","Merry, friendly, and curious");
            energy_levels.put("Forsteni Turtles","Very Active; This quick, energetic and\ncompact hound turtle needs plenty of exercises");
            good_with_childrens.put("Forsteni Turtles","Yes");
            good_with_other_dogs.put("Forsteni Turtles","Yes");
            sheddings.put("Forsteni Turtles","Seasonal");
            groomings.put("Forsteni Turtles","Weekly");
            trainabilitys.put("Forsteni Turtles","Response Well");
            heights.put("Forsteni Turtles","13 inches & under, 13-15 inches");
            weights.put("Forsteni Turtles","under 20 pounds (13 inches & under), 20-30 pounds (13-15 inches)");
            life_expectancys.put("Forsteni Turtles","10-15 years");
            barking_levels.put("Forsteni Turtles","None");
            //3.
            personalitys.put("Pig Muzzle Tortoise","Intelligent, friendly, and devoted.");
            energy_levels.put("Pig Muzzle Tortoise","Very Active; This turtle is active\nand energetic and needs daily exercise.");
            good_with_childrens.put("Pig Muzzle Tortoise","Yes");
            good_with_other_dogs.put("Pig Muzzle Tortoise","Yes");
            sheddings.put("Pig Muzzle Tortoise","Seasonal");
            groomings.put("Pig Muzzle Tortoise","Occasional");
            trainabilitys.put("Pig Muzzle Tortoise","Eager To Please");
            heights.put("Pig Muzzle Tortoise","23-24 inches (male), 21.5-22.5 inches (female)");
            weights.put("Pig Muzzle Tortoise","65-75 pounds (male), 55-65 pounds (female)");
            life_expectancys.put("Pig Muzzle Tortoise","10-12 years");
            barking_levels.put("Pig Muzzle Tortoise","None");
            //4.
            personalitys.put("Sun Tortoise","Calm, courageous, and friendly; dignified but amusing");
            energy_levels.put("Sun Tortoise","Not Very Active; this turtle won’t beg to be exercised,\nbut they require regular walks and the occasional romp");
            good_with_childrens.put("Sun Tortoise","Yes");
            good_with_other_dogs.put("Sun Tortoise","Yes");
            sheddings.put("Sun Tortoise","Seasonal");
            groomings.put("Sun Tortoise","Weekly");
            trainabilitys.put("Sun Tortoise","Response Well");
            heights.put("Sun Tortoise","14-15 inches");
            weights.put("Sun Tortoise","50 pounds (male), 40 pounds (female)");
            life_expectancys.put("Sun Tortoise","8-10 years");
            barking_levels.put("Sun Tortoise","None");
            //5.
            personalitys.put("Aquatic Turtles","Friendly and outgoing, Labs play well with others");
            energy_levels.put("Aquatic Turtles","Very active; this turtle are high-spirited and not afraid to show it");
            good_with_childrens.put("Aquatic Turtles","Yes");
            good_with_other_dogs.put("Aquatic Turtles","With supervision");
            sheddings.put("Aquatic Turtles","Regularly");
            groomings.put("Aquatic Turtles","Weekly brushing");
            trainabilitys.put("Aquatic Turtles","Eager to please");
            heights.put("Aquatic Turtles","22.5-24.5 inches (male), 21.5-23.5 inches (female)");
            weights.put("Aquatic Turtles","65-80 pounds (male), 55-70 pounds (female)");
            life_expectancys.put("Aquatic Turtles","10-12 years");
            barking_levels.put("Aquatic Turtles","None");
        }
    }
    public void showRecyclerCardView() {
        rvTurtle.setLayoutManager(new LinearLayoutManager(this));
        TurtleAdapter turtleAdapter = new TurtleAdapter(list);
        rvTurtle.setAdapter(turtleAdapter);

        turtleAdapter.setOnItemClickCallBack(new TurtleAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Turtle data) {
                showSelectedDate(data);
                Intent moveIntent = new Intent(TurtleActivity.this,DetailAnimalPage.class);
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
    private void showSelectedDate(Turtle turtle) {
        Toast.makeText(this, "Clicking " + turtle.getName(), Toast.LENGTH_SHORT).show();
    }
}