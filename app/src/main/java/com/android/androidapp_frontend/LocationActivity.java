package com.android.androidapp_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LocationActivity extends AppCompatActivity {

    Button btnGoMain, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        btnGoMain = (Button) findViewById(R.id.btnLocationGoMain);
        btnHome = (Button) findViewById(R.id.btnLocationHome);

        btnGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LogInSuccess.class);
                startActivity(intent);
            }
        });

        // Fragment﻿를 추가하는 소스를 코딩해 줍니다.
        if (savedInstanceState == null) {

            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFragment, mainFragment, "main")
                    .commit();
        }


    }
}