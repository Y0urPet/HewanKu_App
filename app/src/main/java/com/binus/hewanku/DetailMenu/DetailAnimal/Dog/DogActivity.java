package com.binus.hewanku.DetailMenu.DetailAnimal.Dog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.binus.hewanku.DetailMenu.DetailAnimal.Cat.Cat;
import com.binus.hewanku.DetailMenu.DetailAnimal.Cat.CatAdapter;
import com.binus.hewanku.DetailMenu.DetailAnimal.Cat.CatData;
import com.binus.hewanku.DetailMenu.DetailAnimal.DetailAnimalPage;
import com.binus.hewanku.DetailMenu.DetailAnimal.Turtle.TurtleActivity;
import com.binus.hewanku.R;

import java.util.ArrayList;

public class DogActivity extends AppCompatActivity implements DogList{

    private RecyclerView rvDog;
    private final ArrayList<Dog> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        rvDog = findViewById(R.id.rv_dog);

        list.addAll(DogData.getListData());
        rvDog.setHasFixedSize(true);
        showRecyclerCardView();

        if (personalitys.size() <= 0){
            //1.
            personalitys.put("Labrador Retriever","Even-tempered, charming, mischievous, and loving");
            energy_levels.put("Labrador Retriever","Somewhat active; this dog are not exactly natural athletes,\nbut they do have strong legs and endless curiosity—exercise\nboth regularly");
            good_with_childrens.put("Labrador Retriever","Better with supervision");
            good_with_other_dogs.put("Labrador Retriever","With supervision");
            sheddings.put("Labrador Retriever","Regularly");
            groomings.put("Labrador Retriever","Weekly brushing");
            trainabilitys.put("Labrador Retriever","Agreeable");
            heights.put("Labrador Retriever","10-13 inches");
            weights.put("Labrador Retriever","14-18 pounds");
            life_expectancys.put("Labrador Retriever","13-15 years");
            barking_levels.put("Labrador Retriever","Medium");
            //2.
            personalitys.put("Bulldog","Merry, friendly, and curious");
            energy_levels.put("Bulldog","Very Active; This quick, energetic and compact\nhound dog needs plenty of exercises");
            good_with_childrens.put("Bulldog","Yes");
            good_with_other_dogs.put("Bulldog","Yes");
            sheddings.put("Bulldog","Seasonal");
            groomings.put("Bulldog","Weekly");
            trainabilitys.put("Bulldog","Response Well");
            heights.put("Bulldog","13 inches & under, 13-15 inches");
            weights.put("Bulldog","under 20 pounds (13 inches & under), 20-30 pounds (13-15 inches)");
            life_expectancys.put("Bulldog","10-15 years");
            barking_levels.put("Bulldog","Quiet");
            //3.
            personalitys.put("Golden Retriever","Intelligent, friendly, and devoted.");
            energy_levels.put("Golden Retriever","Very Active; This dog is active and energetic and needs daily exercise.");
            good_with_childrens.put("Golden Retriever","Yes");
            good_with_other_dogs.put("Golden Retriever","Yes");
            sheddings.put("Golden Retriever","Seasonal");
            groomings.put("Golden Retriever","Occasional");
            trainabilitys.put("Golden Retriever","Eager To Please");
            heights.put("Golden Retriever","23-24 inches (male), 21.5-22.5 inches (female)");
            weights.put("Golden Retriever","65-75 pounds (male), 55-65 pounds (female)");
            life_expectancys.put("Golden Retriever","10-12 years");
            barking_levels.put("Golden Retriever","Barks When Necessary");
            //4.
            personalitys.put("Beagle","Calm, courageous, and friendly; dignified but amusing");
            energy_levels.put("Beagle","Not Very Active; this dog won’t beg to be exercised,\nbut they require regular walks and the occasional romp");
            good_with_childrens.put("Beagle","Yes");
            good_with_other_dogs.put("Beagle","Yes");
            sheddings.put("Beagle","Seasonal");
            groomings.put("Beagle","Weekly");
            trainabilitys.put("Beagle","Response Well");
            heights.put("Beagle","14-15 inches");
            weights.put("Beagle","50 pounds (male), 40 pounds (female)");
            life_expectancys.put("Beagle","8-10 years");
            barking_levels.put("Beagle","Likes To Be Vocal");
            //5.
            personalitys.put("Pug","Friendly and outgoing, Labs play well with others");
            energy_levels.put("Pug","Very active; this dog are high-spirited and not afraid to show it");
            good_with_childrens.put("Pug","Yes");
            good_with_other_dogs.put("Pug","With supervision");
            sheddings.put("Pug","Regularly");
            groomings.put("Pug","Weekly brushing");
            trainabilitys.put("Pug","Eager to please");
            heights.put("Pug","22.5-24.5 inches (male), 21.5-23.5 inches (female)");
            weights.put("Pug","65-80 pounds (male), 55-70 pounds (female)");
            life_expectancys.put("Pug","10-12 years");
            barking_levels.put("Pug","Barks when necessary");
        }
    }
    public void showRecyclerCardView() {
        rvDog.setLayoutManager(new LinearLayoutManager(this));
        DogAdapter birdAdapter = new DogAdapter(list);
        rvDog.setAdapter(birdAdapter);

        birdAdapter.setOnItemClickCallBack(new DogAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Dog data) {
                showSelectedDate(data);
                Intent moveIntent = new Intent(DogActivity.this, DetailAnimalPage.class);
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
    private void showSelectedDate(Dog dog) {
        Toast.makeText(this, "Clicking " + dog.getName(), Toast.LENGTH_SHORT).show();
    }
}