package com.kh.simpleimageviewerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPrev, btnNext;
    myPictureView myView;
    File[] files;
    int index = 0;
    ArrayList<File> imgFiles = new ArrayList<>();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        myView = findViewById(R.id.myView);
        textView = findViewById(R.id.textView);
        // 버튼 클릭 리스너
        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        // 읽어올 파일 경로
        File f = new File("/sdcard/Pictures");
        // 해당 경로의 모든 파일목록
        files = f.listFiles();
        for(int i=0; i< files.length; i++) {
            // 파일이름
            String filename = files[i].toString();
            // 파일 확장자 읽기
            String extension = filename.substring(filename.lastIndexOf(".")+1);
            // 파일 확장자가 이미지 파일일 경우만 imgFiles에 담음
            if(extension.equals("jpg") || extension.equals("png") || extension.equals("gif")){
                imgFiles.add(files[i]);
            } else {
               // Log.d("mytag","noImgIdx:"+i);
            }
        }
        // 첫 화면에 나올 이미지
        myView.filePath = imgFiles.get(index).toString();
        // 인덱스 표시
        textView.setText((index+1)+"/"+(imgFiles.size()));
    }

    @Override
    public void onClick(View v) {
        if(v == btnPrev){
            if(index > 0) {
                --index;
            } else {
                // 인덱스의 경계를 넘으려하면 반대편 인덱스로 변경
                index = imgFiles.size() -1;
            }
        } else if(v == btnNext) {
            if(index < imgFiles.size() - 1) {
                ++index;
            } else {
                // 인덱스의 경계를 넘으려하면 반대편 인덱스로 변경
                index = 0;
            }
        }
        // 인덱스를 변경한 후 그려질 이미지의 경로를 저장한다.
        myView.filePath = imgFiles.get(index).toString();
        // 무효화하다. -> 다시 그리기 요청
        myView.invalidate();
        // 인덱스 최신화
        textView.setText((index+1)+"/"+(imgFiles.size()));
    }
}