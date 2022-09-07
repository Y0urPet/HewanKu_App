package com.binus.hewanku.DetailMenu.DetailService;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.binus.hewanku.DetailMenu.DetailAnimal.DetailAnimalPage;
import com.binus.hewanku.DetailMenu.TransactionHistory.Transaction;
import com.binus.hewanku.DetailMenu.TransactionHistory.TransactionActivity;
import com.binus.hewanku.DetailMenu.TransactionHistory.TransactionData;
import com.binus.hewanku.DetailMenu.TransactionHistory.TransactionHistory;
import com.binus.hewanku.MainMenu.ClinicFragment;
import com.binus.hewanku.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class GroomingActivity extends AppCompatActivity implements TransactionHistory {

    private static final String TAG = "Grooming";
    private TextView title_clinic;
    private Button mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    Button timeButton;
    int hour,minute;

    TextInputLayout petshop;
    AutoCompleteTextView petshop_choice;
    ArrayList<String> petshop_list;
    ArrayAdapter<String> arrayAdapter_petshop;

    TextInputLayout payment;
    AutoCompleteTextView payment_choice;
    ArrayList<String> arrayList_payment;
    ArrayAdapter<String> arrayAdapter_payment;

    TextInputLayout delivery;
    AutoCompleteTextView delivery_method;
    ArrayList<String> arrayList_delivery;
    ArrayAdapter<String> arrayAdapter_delivery;

    EditText edt_type;
    EditText edt_name;

    public static boolean checked;
    public static String date;
    public static String time;
    public static String petshop_location;
    public static String payment_method;
    public static String name;
    public static String type;
    public static String status;
    public static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming);

        mDisplayDate = findViewById(R.id.btn_date);
        timeButton = findViewById(R.id.btn_time);
        petshop = findViewById(R.id.petshop);
        petshop_choice = findViewById(R.id.petshop_choice);
        payment = findViewById(R.id.payment);
        payment_choice = findViewById(R.id.payment_choice);
        delivery = findViewById(R.id.delivery_method);
        delivery_method = findViewById(R.id.delivery_choice);
        edt_type = findViewById(R.id.edt_animal_type);
        edt_name = findViewById(R.id.edt_animal_name);
        title_clinic = findViewById(R.id.title_clinic);

        title_clinic.setText(ClinicFragment.title);
        if (DetailAnimalPage.isFromAnimalPage){
            edt_name.setText(DetailAnimalPage.animal_name_intent);
            edt_type.setText(DetailAnimalPage.animal_type_intent);
            DetailAnimalPage.isFromAnimalPage = false;
        }

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(GroomingActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth,mDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.i(TAG,"onDataset: data: " + year + "/" + month +"/"+ dayOfMonth );
                date = dayOfMonth+"/"+month+"/"+year;
                mDisplayDate.setText(date);
            }
        };

        petshop_list = new ArrayList<>();
        arrayList_payment = new ArrayList<>();
        arrayList_delivery = new ArrayList<>();

        petshop_list.add("Lush Pet & Co");
        petshop_list.add("De Puppy");
        petshop_list.add("Peata.id");
        petshop_list.add("Top Petshop");
        petshop_list.add("King Petshop");

        arrayAdapter_petshop = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, petshop_list);
        petshop_choice.setAdapter(arrayAdapter_petshop);

        petshop_choice.setThreshold(1);

        arrayList_payment.add("BCA");
        arrayList_payment.add("GoPay");
        arrayList_payment.add("OVO");
        arrayList_payment.add("Mandiri");
        arrayList_payment.add("BNI");

        arrayAdapter_payment = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, arrayList_payment);
        payment_choice.setAdapter(arrayAdapter_payment);

        payment_choice.setThreshold(1);

        arrayList_delivery.add("Drop Off");
        arrayList_delivery.add("Pick Up");

        arrayAdapter_delivery = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, arrayList_delivery);
        delivery_method.setAdapter(arrayAdapter_delivery);

        delivery_method.setThreshold(1);
    }

    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(),"%02d:%02d",hour,minute));
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,onTimeSetListener,hour,minute,true);

        timePickerDialog.setTitle("Selected Time");
        timePickerDialog.show();
    }

    public void onCheckboxClicked(View view) {
        checked = ((CheckBox) view).isChecked();
    }

    public void onSubmitData(View view) {
        String state;
        if (checked){
            state = "True";
        } else {
            state = "False";
        }
        Log.i("GroomingActivity",state);
        if (checked){
            name = edt_name.getText().toString().trim();
            type = edt_type.getText().toString().trim();
            payment_method = Objects.requireNonNull(payment.getEditText()).getText().toString().trim();
            petshop_location = Objects.requireNonNull(petshop.getEditText()).getText().toString().trim();
            time = timeButton.getText().toString().trim();
            status = ClinicFragment.title;
            id = getRandomID();

            //Take the value into arraylist
            activityName.add(status);
            animalTypes.add(type);
            animalNames.add(name);
            dates.add(date);
            times.add(time);
            petshopLocations.add(petshop_location);
            paymentMethods.add(payment_method);
            ids.add(id);

            Intent moveIntent = new Intent(this, TransactionActivity.class);
            Toast.makeText(this,"Successfully Added",Toast.LENGTH_SHORT).show();
            startActivity(moveIntent);
        } else {
            Toast.makeText(this,"Accept Terms!",Toast.LENGTH_SHORT).show();
        }
    }

    public String getRandomID(){
        int[] numbers = {1,2,3,4,5,6,7,8,9,0};
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        int digit1 = getRandomInt(numbers);
        String digit2 = getRandomString(alphabet).toUpperCase();
        int digit3 = getRandomInt(numbers);
        String digit4 = getRandomString(alphabet).toUpperCase();
        int digit5 = getRandomInt(numbers);
        String digit6 = getRandomString(alphabet).toUpperCase();
        int digit7 = getRandomInt(numbers);

        return digit1+digit2+digit3+digit4+digit5+digit6+digit7;
    }

    public static int getRandomInt(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static String getRandomString(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}