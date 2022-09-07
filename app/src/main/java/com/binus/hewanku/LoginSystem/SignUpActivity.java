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

import com.binus.hewanku.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener,AccountData {

    private EditText edt_name;
    private EditText edt_email;
    private EditText edt_password;
    private EditText edt_confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        edt_name = findViewById(R.id.edt_name);
        edt_email = findViewById(R.id.edt_email_signup);
        edt_password = findViewById(R.id.edt_password_signup);
        edt_confirm_password = findViewById(R.id.edt_confirm_password_signup);
        Button btn_signUp = findViewById(R.id.btn_signUp);
        TextView txt_signIn = findViewById(R.id.txt_signIn);

        btn_signUp.setOnClickListener(this);
        txt_signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txt_signIn) {
            Intent moveIntent = new Intent(SignUpActivity.this,MainActivity.class);
            startActivity(moveIntent);
        } else if (v.getId() == R.id.btn_signUp){
            String inputName = edt_name.getText().toString().trim();
            String inputEmail = edt_email.getText().toString();
            String inputPassword = edt_password.getText().toString();
            String inputConfirmPassword = edt_confirm_password.getText().toString();

            boolean isEmptyField = false;

            if (TextUtils.isEmpty(inputName) ){
                isEmptyField = true;
                edt_name.setError("Field can not be empty!");
            } else if (TextUtils.isEmpty(inputEmail)){
                isEmptyField = true;
                edt_email.setError("Field can not be empty!");
            } else if (TextUtils.isEmpty(inputPassword)){
                isEmptyField = true;
                edt_password.setError("Field can not be empty!");
            } else if (TextUtils.isEmpty(inputConfirmPassword)) {
                isEmptyField = true;
                edt_confirm_password.setError("Field can not be empty");
            }

            if (!isEmptyField){
                if (inputEmail.contains("@") || inputEmail.endsWith(".com")){
                    if (inputPassword.length() > 6) {
                        if (inputPassword.equals(inputConfirmPassword)){
                            accountData.put(inputEmail,inputPassword);
                            accountName.put(inputEmail,inputName);
                            Log.i("Ini Email",inputEmail);
                            Log.i("Ini Password",inputPassword);
                            Log.i("ini keyset", String.valueOf(accountData.keySet()));
                            Intent moveIntent = new Intent(SignUpActivity.this,MainActivity.class);
                            startActivity(moveIntent);
                        } else {
                            edt_password.setError("Eror confirmation!");
                            edt_confirm_password.setError("Eror Confirmation!");
                        }
                    } else {
                        edt_password.setError("Password must be at leash 6 character!");
                    }
                } else {
                    edt_email.setError("Must be endwith @gmail.com!");
                }
            }
        }
    }
}