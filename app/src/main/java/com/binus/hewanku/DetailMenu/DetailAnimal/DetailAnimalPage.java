package com.binus.hewanku.DetailMenu.DetailAnimal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.binus.hewanku.DetailMenu.DetailService.GroomingActivity;
import com.binus.hewanku.MainMenu.ClinicFragment;
import com.binus.hewanku.MainMenu.ShelterFragment;
import com.binus.hewanku.R;

public class DetailAnimalPage extends AppCompatActivity{

    public static String animal_name_intent;
    public static boolean isFromAnimalPage = false;
    public static String animal_type_intent;

    ImageView img_animalPhoto;
    TextView tv_animal_name;
    TextView tv_animal_description;
    TextView tv_personality;
    TextView tv_energy_level;
    TextView tv_good_with_children;
    TextView tv_good_with_other_dogs;
    TextView tv_shedding;
    TextView tv_grooming;
    TextView tv_trainability;
    TextView tv_height;
    TextView tv_weight;
    TextView tv_life_expectancy;
    TextView tv_barking_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_animal_page);

        img_animalPhoto = findViewById(R.id.imageView_shelter);
        tv_animal_name = findViewById(R.id.animal_name_detail);
        tv_animal_description = findViewById(R.id.description_animal);
        tv_personality = findViewById(R.id.personality);
        tv_energy_level = findViewById(R.id.energy_level);
        tv_good_with_children = findViewById(R.id.good_with_children);
        tv_good_with_other_dogs = findViewById(R.id.good_with_other_dog);
        tv_shedding = findViewById(R.id.shedding);
        tv_grooming = findViewById(R.id.grooming_detail_shelter);
        tv_trainability = findViewById(R.id.trainability);
        tv_height = findViewById(R.id.height);
        tv_weight = findViewById(R.id.weight);
        tv_life_expectancy = findViewById(R.id.life_expectancy);
        tv_barking_level = findViewById(R.id.barking_level);

        String animalName = getIntent().getStringExtra("animalName");
        String animalDesc = getIntent().getStringExtra("animalDesc");
        int animalImg = getIntent().getIntExtra("animalImg",0);
        String personality = getIntent().getStringExtra("personality");
        String energy_level = getIntent().getStringExtra("energy_level");
        String good_with_children = getIntent().getStringExtra("good_with_children");
        String good_with_other_dog = getIntent().getStringExtra("good_with_other_dog");
        String shedding = getIntent().getStringExtra("shedding");
        String grooming = getIntent().getStringExtra("grooming");
        String trainability = getIntent().getStringExtra("trainability");
        String height = getIntent().getStringExtra("height");
        String weights = getIntent().getStringExtra("weights");
        String life_expectancys = getIntent().getStringExtra("life_expectancys");
        String barking_levels = getIntent().getStringExtra("barking_levels");

        img_animalPhoto.setImageResource(animalImg);
        tv_animal_name.setText(animalName);
        tv_animal_description.setText(animalDesc);
        tv_personality.setText(personality);
        tv_energy_level.setText(energy_level);
        tv_good_with_children.setText(good_with_children);
        tv_good_with_other_dogs.setText(good_with_other_dog);
        tv_shedding.setText(shedding);
        tv_grooming.setText(grooming);
        tv_trainability.setText(trainability);
        tv_height.setText(height);
        tv_weight.setText(weights);
        tv_life_expectancy.setText(life_expectancys);
        tv_barking_level.setText(barking_levels);

        animal_name_intent = animalName;
    }

    public void onAdopt(View v) {
        if (v.getId() == R.id.btn_adopt){
            Intent moveIntent = new Intent(DetailAnimalPage.this, GroomingActivity.class);
            isFromAnimalPage = true;
            animal_type_intent = ShelterFragment.name_intent;
            ClinicFragment.title = "Adoption";
            startActivity(moveIntent);
        }
    }
}