package com.dhawal.petetite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
EditText username , password;
Button loginButton;
TextView goToRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_loginButton);
        goToRegister = findViewById(R.id.login_register);

        goToRegister.setOnClickListener(v->{
            Intent intent = new Intent(this,RegisterActivtiy.class);
            startActivity(intent);
        });



    }
}