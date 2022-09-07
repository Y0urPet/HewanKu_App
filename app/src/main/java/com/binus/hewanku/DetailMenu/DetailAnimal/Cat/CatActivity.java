package com.binus.hewanku.DetailMenu.DetailAnimal.Cat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.binus.hewanku.DetailMenu.DetailAnimal.Bird.Bird;
import com.binus.hewanku.DetailMenu.DetailAnimal.Bird.BirdAdapter;
import com.binus.hewanku.DetailMenu.DetailAnimal.Bird.BirdData;
import com.binus.hewanku.DetailMenu.DetailAnimal.DetailAnimalPage;
import com.binus.hewanku.DetailMenu.DetailAnimal.Dog.DogActivity;
import com.binus.hewanku.R;

import java.util.ArrayList;

public class CatActivity extends AppCompatActivity implements CatList {

    private RecyclerView rvCat;
    private final ArrayList<Cat> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        rvCat = findViewById(R.id.rv_cat);

        list.addAll(CatData.getListData());
        rvCat.setHasFixedSize(true);
        showRecyclerCardView();
        if (personalitys.size() <= 0){
            //1.
            personalitys.put("Sphynx","Even-tempered, charming, mischievous, and loving");
            energy_levels.put("Sphynx","Somewhat active; this dog are not exactly natural athletes,\nbut they do have strong legs and endless curiosity—exercise\nboth regularly");
            good_with_childrens.put("Sphynx","Better with supervision");
            good_with_other_dogs.put("Sphynx","With supervision");
            sheddings.put("Sphynx","Regularly");
            groomings.put("Sphynx","Weekly brushing");
            trainabilitys.put("Sphynx","Agreeable");
            heights.put("Sphynx","10-13 inches");
            weights.put("Sphynx","14-18 pounds");
            life_expectancys.put("Sphynx","13-15 years");
            barking_levels.put("Sphynx","Medium");
            //2.
            personalitys.put("Persian","Merry, friendly, and curious");
            energy_levels.put("Persian","Very Active; This quick, energetic and compact\nhound dog needs plenty of exercises");
            good_with_childrens.put("Persian","Yes");
            good_with_other_dogs.put("Persian","Yes");
            sheddings.put("Persian","Seasonal");
            groomings.put("Persian","Weekly");
            trainabilitys.put("Persian","Response Well");
            heights.put("Persian","13 inches & under, 13-15 inches");
            weights.put("Persian","under 20 pounds (13 inches & under), 20-30 pounds (13-15 inches)");
            life_expectancys.put("Persian","10-15 years");
            barking_levels.put("Persian","Quiet");
            //3.
            personalitys.put("Exotic Shorthair","Intelligent, friendly, and devoted.");
            energy_levels.put("Exotic Shorthair","Very Active; This dog is active and energetic and needs daily exercise.");
            good_with_childrens.put("Exotic Shorthair","Yes");
            good_with_other_dogs.put("Exotic Shorthair","Yes");
            sheddings.put("Exotic Shorthair","Seasonal");
            groomings.put("Exotic Shorthair","Occasional");
            trainabilitys.put("Exotic Shorthair","Eager To Please");
            heights.put("Exotic Shorthair","23-24 inches (male), 21.5-22.5 inches (female)");
            weights.put("Exotic Shorthair","65-75 pounds (male), 55-65 pounds (female)");
            life_expectancys.put("Exotic Shorthair","10-12 years");
            barking_levels.put("Exotic Shorthair","Barks When Necessary");
            //4.
            personalitys.put("Siamese","Calm, courageous, and friendly; dignified but amusing");
            energy_levels.put("Siamese","Not Very Active; this dog won’t beg to be exercised,\nbut they require regular walks and the occasional romp");
            good_with_childrens.put("Siamese","Yes");
            good_with_other_dogs.put("Siamese","Yes");
            sheddings.put("Siamese","Seasonal");
            groomings.put("Siamese","Weekly");
            trainabilitys.put("Siamese","Response Well");
            heights.put("Siamese","14-15 inches");
            weights.put("Siamese","50 pounds (male), 40 pounds (female)");
            life_expectancys.put("Siamese","8-10 years");
            barking_levels.put("Siamese","Likes To Be Vocal");
            //5.
            personalitys.put("Ragdoll","Friendly and outgoing, Labs play well with others");
            energy_levels.put("Ragdoll","Very active; this dog are high-spirited and not afraid to show it");
            good_with_childrens.put("Ragdoll","Yes");
            good_with_other_dogs.put("Ragdoll","With supervision");
            sheddings.put("Ragdoll","Regularly");
            groomings.put("Ragdoll","Weekly brushing");
            trainabilitys.put("Ragdoll","Eager to please");
            heights.put("Ragdoll","22.5-24.5 inches (male), 21.5-23.5 inches (female)");
            weights.put("Ragdoll","65-80 pounds (male), 55-70 pounds (female)");
            life_expectancys.put("Ragdoll","10-12 years");
            barking_levels.put("Ragdoll","Barks when necessary");
        }
    }

    public void showRecyclerCardView() {
        rvCat.setLayoutManager(new LinearLayoutManager(this));
        CatAdapter birdAdapter = new CatAdapter(list);
        rvCat.setAdapter(birdAdapter);

        birdAdapter.setOnItemClickCallBack(new CatAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Cat data) {
                showSelectedDate(data);
                Intent moveIntent = new Intent(CatActivity.this, DetailAnimalPage.class);
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
    private void showSelectedDate(Cat cat) {
        Toast.makeText(this, "Clicking " + cat.getName(), Toast.LENGTH_SHORT).show();
    }
}