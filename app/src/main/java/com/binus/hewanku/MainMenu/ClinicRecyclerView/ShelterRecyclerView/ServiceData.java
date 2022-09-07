package com.binus.hewanku.MainMenu.ClinicRecyclerView.ShelterRecyclerView;

import com.binus.hewanku.R;

import java.util.ArrayList;

public class ServiceData {
    private static final String[] activityName = {
            "Grooming Reservation",
            "Medical Check up reservation",
            "Vaccine Reservation",
            "MRI Reservation",
            "Online Consult",
    };

    private static final int[] activityImg = {
            R.drawable.grooming,
            R.drawable.medical_checkup,
            R.drawable.vaccine,
            R.drawable.mri_dog,
            R.drawable.online_consult,
    };

    private static final int[] backgroundText = {
            R.drawable.background_animal_1,
            R.drawable.background_animal_1,
            R.drawable.background_animal_1,
            R.drawable.background_animal_1,
            R.drawable.background_animal_1,
    };

    public static ArrayList<Service> getListData() {
        ArrayList<Service> list = new ArrayList<>();
        for (int position = 0; position < activityName.length; position++) {
            Service service = new Service();
            service.setName(activityName[position]);
            service.setPhoto(activityImg[position]);
            service.setBackgroundText(backgroundText[position]);
            list.add(service);
        }
        return list;
    }
}
