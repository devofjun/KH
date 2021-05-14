package com.kh.simplediaryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    EditText editText;
    Button btn;

    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = findViewById(R.id.datePicker);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);

        // DatePicker를 사용하기 위해선 오늘 날짜를 설정 해줘야함.
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        // 오늘날짜의 일기 바로 보이게하기
        fileName = year + "_" + (month + 1) + "_" + dayOfMonth + ".txt";
        String fileData = readDiary(fileName);
        // 읽어온 데이터가 없으면 null
        if(fileData == null){
            editText.setText("");
            editText.setHint("일기 없음");
            btn.setText("작성하기");
        } else {
            editText.setText(fileData);
            btn.setText("수정하기");
        }

        // DatePicker를 사용하기 위해선 init함수를 사용해야함
        datePicker.init(year, month, dayOfMonth, new DatePicker.OnDateChangedListener() {
            // 날짜가 선택될때마다
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = year + "_" + (monthOfYear + 1) + "_" + dayOfMonth + ".txt";
                String fileData = readDiary(fileName);
                // 읽어온 데이터가 없으면 null
                if(fileData == null){
                    editText.setText("");
                    editText.setHint("일기 없음");
                    btn.setText("작성하기");
                } else {
                    editText.setText(fileData);
                    btn.setText("수정하기");
                }
                //btn.setEnabled(true);
            }
        });

        // 파일쓰기 버튼
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                try {
                    FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    osw.write(text);
                    osw.close();
                    fos.close();
                    Toast.makeText(MainActivity.this, "작성완료", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 전달 받은 파일명의 데이터를 읽어서 string으로 반환한다.
    private String readDiary(String fileName) {
        String str = "";
        try {
            FileInputStream fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            while(true){
                int data = br.read();
                if(data == -1){
                    break;
                }
                str += String.valueOf((char)data);
            }
            fis.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}