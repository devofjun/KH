package com.kh.prac7_6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    RadioButton rbDog, rbCat, rbRabbit, rbHorse;
    Button btn;
    ImageView dlImg;
    String[] items = {"강아지", "고양이", "토끼", "말"};
    int checked = 0;
    View dlgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbDog = findViewById(R.id.rbDog);
        rbCat = findViewById(R.id.rbCat);
        rbRabbit = findViewById(R.id.rbRabbit);
        rbHorse = findViewById(R.id.rbHorse);
        btn = findViewById(R.id.btn);

        rbDog.setOnCheckedChangeListener(this);
        rbCat.setOnCheckedChangeListener(this);
        rbRabbit.setOnCheckedChangeListener(this);
        rbHorse.setOnCheckedChangeListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog();
            }
        });

    }
    private void showdialog() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle(items[checked]);
        dlg.setPositiveButton("닫기",null);

        dlgView = View.inflate(MainActivity.this, R.layout.view_dialog, null);
        dlg.setView(dlgView);
        dlImg = dlgView.findViewById(R.id.dlImg);
        if(checked == 0) {
            dlImg.setImageResource(R.drawable.dog);
        } else if(checked == 1) {
            dlImg.setImageResource(R.drawable.cat);
        } else if(checked == 2) {
            dlImg.setImageResource(R.drawable.rabbit);
        } else if(checked == 3) {
            dlImg.setImageResource(R.drawable.horse);
        }

        dlg.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView == rbDog && isChecked){
            checked = 0;
            Log.d("tag", checked+"");
        } else if(buttonView == rbCat && isChecked) {
            checked = 1;
            Log.d("tag", checked+"");
        } else if(buttonView == rbRabbit && isChecked) {
            checked = 2;
            Log.d("tag", checked+"");
        } else if(buttonView == rbHorse && isChecked) {
            checked = 3;
            Log.d("tag", checked+"");
        }
    }
}