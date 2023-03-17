package com.android.androidapp_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class GoodsInfoActivityRadioGroup extends AppCompatActivity {

    Button btnGoMain, btnHome;

    RadioGroup rGroup;
    RadioButton rdol01, rdol02, rdol03, rdol04;
    Button btnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info_radio);

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

        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        rdol01 = (RadioButton) findViewById(R.id.rdol01);
        rdol02 = (RadioButton) findViewById(R.id.rdol02);
        rdol03 = (RadioButton) findViewById(R.id.rdol03);
        rdol04 = (RadioButton) findViewById(R.id.rdol04);
        btnImage = (Button) findViewById(R.id.btnImage);

        final Integer[] radioID = {R.id.rdol01, R.id.rdol02, R.id.rdol03,
                R.id.rdol04};
        final Integer[] petID = {R.drawable.l01, R.drawable.l02,
                R.drawable.l03, R.drawable.l04};

        btnImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int pos = rGroup.getCheckedRadioButtonId();
                View dialogView = (View) View.inflate(GoodsInfoActivityRadioGroup.this,
                        R.layout.dialog2, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(
                        GoodsInfoActivityRadioGroup.this);
                ImageView ivPet = (ImageView) dialogView
                        .findViewById(R.id.ivPet);

                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.rdol01:
                        ivPet.setImageResource(petID[0]);
                        dlg.setTitle("피치 앤 블랙티");
                        break;
                    case R.id.rdol02:
                        ivPet.setImageResource(petID[1]);
                        dlg.setTitle("100% 제주산 말차");
                        break;
                    case R.id.rdol03:
                        ivPet.setImageResource(petID[2]);
                        dlg.setTitle("악마 초코");
                        break;
                    case R.id.rdol04:
                        ivPet.setImageResource(petID[3]);
                        dlg.setTitle("콜드브루");
                        break;
                }

                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();

            }
        });

    }
}