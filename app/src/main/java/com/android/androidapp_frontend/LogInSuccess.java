package com.android.androidapp_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LogInSuccess extends AppCompatActivity {

    Button btnGoMain, btnAbout, btnLocation, btnGoodsPr, btnGoodsInfo, btnGoodsInfoRadio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        btnGoMain = (Button) findViewById(R.id.btnGoMain);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnLocation = (Button) findViewById(R.id.btnLocation);
        btnGoodsPr = (Button) findViewById(R.id.btnGoodsPr);
        btnGoodsInfo = (Button) findViewById(R.id.btnGoodsInfo);
        btnGoodsInfoRadio = (Button) findViewById(R.id.btnGoodsInfoRadio);

        btnGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
                startActivity(intent);
            }
        });

        btnGoodsPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoodsPRActivity.class);
                startActivity(intent);
            }
        });

        btnGoodsInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoodsInfoActivity.class);
                startActivity(intent);
            }
        });

        btnGoodsInfoRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoodsInfoActivityRadioGroup.class);
                startActivity(intent);
            }
        });
    }
}