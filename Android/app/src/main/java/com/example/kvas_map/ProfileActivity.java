package com.example.kvas_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button homeButton = (Button) findViewById(R.id.home_button);
        Button loginButton = (Button) findViewById(R.id.login_button);
        Button achivmentsButton = (Button) findViewById(R.id.achivments_button);

        View.OnClickListener onClickListenerHomeButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intentHome);
            }
        };

        View.OnClickListener onClickListenerLoginButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intentLogin);
            }
        };

        View.OnClickListener onClickListenerAchivmentsButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAchivments = new Intent(ProfileActivity.this, AcivmentsActivity.class);
                startActivity(intentAchivments);
            }
        };
     homeButton.setOnClickListener(onClickListenerHomeButton);
     loginButton.setOnClickListener(onClickListenerLoginButton);
     achivmentsButton.setOnClickListener(onClickListenerAchivmentsButton);
    }
}