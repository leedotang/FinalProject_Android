package com.android.androidapp_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.androidapp_frontend.retrofit.MemberVO;

public class GoodsPRActivity extends AppCompatActivity {

    Button btnGoMain, btnHome;

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_pr);

        btnGoMain = (Button) findViewById(R.id.btnGoMain);
        btnHome = (Button) findViewById(R.id.btnHome);

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
    }

}