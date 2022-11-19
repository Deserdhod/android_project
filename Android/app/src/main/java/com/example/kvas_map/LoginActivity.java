package com.example.kvas_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button homeButton = (Button) findViewById(R.id.home_button3);
        Button enterButton = (Button) findViewById(R.id.enter_button);
        Button registrationButton = (Button) findViewById(R.id.registration_button);

        View.OnClickListener onClickListenerHomeButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentHome);
            }
        };

        View.OnClickListener onClickListenerEnterButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEnter = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(intentEnter);
            }
        };

        View.OnClickListener onClickListenerRegistrationButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegistration = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intentRegistration);
            }
        };

        homeButton.setOnClickListener(onClickListenerHomeButton);
        enterButton.setOnClickListener(onClickListenerEnterButton);
        registrationButton.setOnClickListener(onClickListenerRegistrationButton);
    }
}