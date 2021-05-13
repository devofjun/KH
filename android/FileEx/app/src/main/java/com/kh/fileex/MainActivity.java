package com.kh.fileex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnWrite, btnRead;
    String text = "Hello 안녕하세요";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);
        btnWrite.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnWrite){
            FileOutputStream fos = null;
            try {
                // 스트림 개설 - /data/data/패키지명/files
                // openFileOutput : 이미 만들어진 메소드가 있다. 앱이 다른공간에 접근하는걸 제한하기위함
                fos = openFileOutput("file.txt", Context.MODE_PRIVATE);
                // 쓰기는 바이트 단위로 써야함
                fos.write(text.getBytes());
                // 스트림 닫기
                fos.close();
                // 확인 메세지
                Toast.makeText(getApplicationContext(), "file.txt가 생성됨", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (v == btnRead) {
            FileInputStream fis = null;
            try {
                // 스트림 개설
                fis = openFileInput("file.txt");
                // 읽어올때도 바이트 단위로 읽어옴.
                byte[] txt = new byte[30];
                fis.read(txt);
                // 읽어온 바이트를 String형식으로 저장
                String str = new String(txt);
                // 읽어온 데이터 메세지로 출력
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}