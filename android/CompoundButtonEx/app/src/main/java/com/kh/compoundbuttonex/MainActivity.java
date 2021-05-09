package com.kh.compoundbuttonex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox check1, check2;
    RadioButton radio1, radio2;
    Switch alarm;
    ToggleButton alarmOnOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        alarm = findViewById(R.id.alarm);
        alarmOnOff = findViewById(R.id.alarmOnOff);


        check1.setOnCheckedChangeListener(this);
        check2.setOnCheckedChangeListener(this);
        radio1.setOnCheckedChangeListener(this);
        radio2.setOnCheckedChangeListener(this);
        alarm.setOnCheckedChangeListener(this);
        alarmOnOff.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
            case R.id.check1:
                if(isChecked){
                    Log.d("MainActivity", "안드로이드 체크됨");
                } else {
                    Log.d("MainActivity", "안드로이드 체크 해제됨");
                }
                break;
            case R.id.check2:
                if(isChecked){
                    Log.d("MainActivity", "아이폰 체크됨");
                } else {
                    Log.d("MainActivity", "아이폰 체크 해제됨");
                }
                break;
            case R.id.radio1:
                if (isChecked){
                    Log.d("MainActivity","남자 체크됨");
                } else {
                    Log.d("MainActivity","남자 체크해제됨");
                }
                break;
            case R.id.radio2:
                if (isChecked){
                    Log.d("MainActivity","여자 체크됨");
                } else {
                    Log.d("MainActivity","여자 체크해제됨");
                }
                break;
            case R.id.alarm:
                if(isChecked){
                    Log.d("MainActivity","알람 체크됨");
                } else {
                    Log.d("MainActivity","알람 체크해제됨");
                }
                break;
            case R.id.alarmOnOff:
                if(isChecked){
                    Log.d("MainActivity","알람 온됨");
                } else {
                    Log.d("MainActivity","알람 오프됨");
                }
                break;
        }
    }
}