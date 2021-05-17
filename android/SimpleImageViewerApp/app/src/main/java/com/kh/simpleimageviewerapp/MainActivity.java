package com.kh.simpleimageviewerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPrev, btnNext;
    myPictureView myView;
    File[] files;
    int index = 0;
    int imgLength = 0;
    ArrayList<Integer> noImgIdx = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        myView = findViewById(R.id.myView);
        // 버튼 클릭 리스너
        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        File f = new File("/sdcard/Pictures");
        files = f.listFiles();
        for(int i=0; i< files.length; i++) {
            //Log.d("mytag", "list: "+files[i].toString());
            String filename = files[i].toString();
            String extension = filename.substring(filename.lastIndexOf(".")+1);
            Log.d("mytag", "list: "+files[i].toString()+"|ext|: " + extension);
            if(extension.equals("jpg") || extension.equals("png") || extension.equals("gif")){
                ++imgLength;
            } else {
                noImgIdx.add(i);
            }
        }
        myView.filePath = files[index].toString();
        for(int i=0; i < noImgIdx.size(); i++){
            Log.d("mytag","noImage: "+noImgIdx.get(i));
        }
    }

    @Override
    public void onClick(View v) {
        if(v == btnPrev){
            if(index > 0) {
                int i = 0;
                while(true){
                    if(index == noImgIdx.get(i++) && noImgIdx.size() > i){
                        if(index-2 < 0){
                            Toast.makeText(this, "이전 그림 없음", Toast.LENGTH_SHORT).show();
                        } else {
                            index -= 2;
                        }
                        break;
                    } else if(noImgIdx.size() <= i){
                        if(index-1 < 0){
                            Toast.makeText(this, "이전 그림 없음", Toast.LENGTH_SHORT).show();
                        } else {
                            --index;
                        }
                        break;
                    }
                }
            } else {
                Toast.makeText(this, "이전 그림 없음", Toast.LENGTH_SHORT).show();
            }
        } else if(v == btnNext) {
            if(index < files.length - 1) {
                int i = 0;
                while(true){
                    if(index == noImgIdx.get(i++) && noImgIdx.size() > i){
                        if(files.length <= index+2){
                            Toast.makeText(this, "다음 그림 없음", Toast.LENGTH_SHORT).show();
                        } else {
                            index+=2;
                        }
                        break;
                    } else if(noImgIdx.size() <= i){
                        if(files.length <= index+2){
                            Toast.makeText(this, "다음 그림 없음", Toast.LENGTH_SHORT).show();
                        } else {
                            ++index;
                        }
                        break;
                    }
                }
            } else {
                Toast.makeText(this, "다음 그림 없음", Toast.LENGTH_SHORT).show();
            }
        }
        Log.d("mytag", "index: "+index);
        myView.filePath = files[index].toString();
        myView.invalidate(); // 무효화하다. -> 다시 그리기 요청
    }
}