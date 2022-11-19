package com.example.kvas_map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button profileButton = (Button) findViewById(R.id.profile_button);
        View.OnClickListener onClickListenerProfileButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        };

        Button mapButton = (Button) findViewById(R.id.map_button);
        View.OnClickListener onClickListenerMapButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        };

        profileButton.setOnClickListener(onClickListenerProfileButton);
        mapButton.setOnClickListener(onClickListenerMapButton);
    }
}