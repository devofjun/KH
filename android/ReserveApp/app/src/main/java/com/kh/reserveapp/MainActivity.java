package com.kh.reserveapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Chronometer chrono;
    Button btnStart, btnFinish;
    RadioButton rdoCal,rdoTime;
    CalendarView calendar;
    TimePicker timePicker;
    TextView txtResult;
    int selectedYear, selectedMonth, selectedDayOfMonth;
    Calendar cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cal = Calendar.getInstance();
        setUI();
        setListener();
    }

    private void setUI() {
        chrono = findViewById(R.id.chrono);
        btnStart = findViewById(R.id.btnStart);
        btnFinish = findViewById(R.id.btnFinish);
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        calendar = findViewById(R.id.calendar);
        timePicker = findViewById(R.id.timePicker);
        txtResult = findViewById(R.id.txtResult);
    }
    private void setListener() {
        btnStart.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
        // 날짜설정을 눌렀을때
        rdoCal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    calendar.setVisibility(View.VISIBLE);
                    timePicker.setVisibility(View.INVISIBLE);
                }
            }
        });
        // 시간설정을 눌렀을때
        rdoTime.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    calendar.setVisibility(View.INVISIBLE);
                    timePicker.setVisibility(View.VISIBLE);
                }
            }
        });
        // 선택된 날짜를 저장하기위한 캘린더의 리스너
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedYear = year;
                selectedMonth = month;
                selectedDayOfMonth = dayOfMonth;
                cal.set(year, month, dayOfMonth);
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(btnStart == v){ // 예약시작
            chrono.setBase(SystemClock.elapsedRealtime());
            chrono.start();
            chrono.setTextColor(Color.RED);
        } else if(btnFinish == v){ // 예약종료
            chrono.stop();
            chrono.setTextColor(Color.BLUE);
            // 달력형 데이터
//            cal = Calendar.getInstance();
//            cal.set(selectedYear, selectedMonth, selectedDayOfMonth);

            // timePicker를 제대로 사용하려면 아래 설정을 바꿔야 한다.
            // Gradle Scripts / build.gradle(Module: -> minSdkVersion 23)
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();
            cal.set(Calendar.HOUR_OF_DAY, hour);
            cal.set(Calendar.MINUTE, minute);

            // 날짜형식 설정
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
            String str = sdf.format(cal.getTime());
            txtResult.setText(str);
        }
    }
}