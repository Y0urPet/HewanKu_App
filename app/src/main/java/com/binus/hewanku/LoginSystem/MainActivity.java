package com.binus.hewanku.LoginSystem;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.binus.hewanku.MainMenu.MainMenuActivity;
import com.binus.hewanku.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AccountData {

    private EditText edtEmail;
    private EditText edtPassword;
    private static String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        TextView txt_signUp = findViewById(R.id.txt_signUp);
        Button btn_signIn = findViewById(R.id.btn_signIn);

        btn_signIn.setOnClickListener(this);
        txt_signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txt_signUp){
            Intent moveIntent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(moveIntent);
        } else if (v.getId() == R.id.btn_signIn) {
            String inputEmail = edtEmail.getText().toString();
            String inputPassword = edtPassword.getText().toString();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputEmail)){
                isEmptyFields = true;
                edtEmail.setError("Field can not be empty!");
            } else if (TextUtils.isEmpty(inputPassword)){
                isEmptyFields = true;
                edtEmail.setError("Field can not be empty!");
            }

            if (!isEmptyFields){
                Log.i("Ini emailnya",inputEmail);
                Log.i("Ini Passwordnya",inputPassword);
                Log.i("ini keyset", String.valueOf(accountData.keySet()));
                if (accountData.containsKey(inputEmail)){
                    String password = accountData.get(inputEmail);
                    if (inputPassword.equals(password)) {
                        Intent moveIntent = new Intent(MainActivity.this, MainMenuActivity.class);
                        setCurrEmail(inputEmail);
                        Log.i("Ini Profile Email",inputEmail);
                        startActivity(moveIntent);
                    } else {
                        edtPassword.setError("Invalid Password!");
                    }
                } else {
                    edtEmail.setError("Invalid Email!");
                }
            }

        }
    }

    public void setCurrEmail(String currEmail){
        email = currEmail;
    }

    public static String getCurrentEmail(){
        return email;
    }
}