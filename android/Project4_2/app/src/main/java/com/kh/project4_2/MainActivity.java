package com.kh.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox chkStart;
    TextView txtLike;
    RadioGroup rGroup;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnFinish;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkStart = findViewById(R.id.chkStart);
        txtLike = findViewById(R.id.chkStart);
        rGroup = findViewById(R.id.rGroup);
        rdoDog = findViewById(R.id.rdoDog);
        rdoCat = findViewById(R.id.rdoCat);
        rdoRabbit = findViewById(R.id.rdoRabbit);
        btnFinish = findViewById(R.id.btnFinish);
        imgPet = findViewById(R.id.imgPet);

        // 시작하기를 체크했을때
        chkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    txtLike.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    btnFinish.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else {
                    txtLike.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    btnFinish.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rdoDog.isChecked()){ // 강아지 사진
                    imgPet.setImageResource(R.drawable.dog);
                } else if(rdoCat.isChecked()) { // 고양이 사진
                    imgPet.setImageResource(R.drawable.cat);
                } else if(rdoRabbit.isChecked()) { // 토끼 사진
                    imgPet.setImageResource(R.drawable.rabbit);
                }
            }
        });

    }
}