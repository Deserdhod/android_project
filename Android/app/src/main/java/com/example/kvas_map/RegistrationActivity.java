package com.example.kvas_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button homeButton = (Button) findViewById(R.id.home_button4);
        Button registrationButton = (Button) findViewById(R.id.registration_button2);

        View.OnClickListener onClickListenerHomeButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intentHome);
            }
        };

        homeButton.setOnClickListener(onClickListenerHomeButton);
    }
}