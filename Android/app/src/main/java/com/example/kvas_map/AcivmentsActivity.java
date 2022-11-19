package com.example.kvas_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcivmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivments);

        Button homeButton2 = (Button) findViewById(R.id.home_button2);
        View.OnClickListener onClickListenerHomeButton2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome2 = new Intent(AcivmentsActivity.this, MainActivity.class);
                startActivity(intentHome2);
            }
        };
        homeButton2.setOnClickListener(onClickListenerHomeButton2);
    }
}