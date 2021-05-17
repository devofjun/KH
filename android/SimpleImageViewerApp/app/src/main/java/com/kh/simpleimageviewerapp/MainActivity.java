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

        File f = new File("/sdcard/Pictures");
        files = f.listFiles();
        for(int i=0; i< files.length; i++) {
            //Log.d("mytag", "list: "+files[i].toString());
            String filename = files[i].toString();
            String extension = filename.substring(filename.lastIndexOf(".")+1);
            Log.d("mytag", "list: "+files[i].toString()+"|ext|: " + extension);
            if(extension.equals("jpg") || extension.equals("png") || extension.equals("gif")){
                imgFiles.add(files[i]);
            } else {
                Log.d("mytag","noImgIdx:"+i);
            }
        }
        myView.filePath = files[index].toString();
        textView.setText((index+1)+"/"+(imgFiles.size()));
    }

    @Override
    public void onClick(View v) {
        if(v == btnPrev){
            if(index > 0) {
                --index;
            } else {
                index = imgFiles.size() -1;
            }
        } else if(v == btnNext) {
            if(index < imgFiles.size() - 1) {
                ++index;
            } else {
                index = 0;
            }
        }
        Log.d("mytag", "index: "+index);
        myView.filePath = imgFiles.get(index).toString();
        myView.invalidate(); // 무효화하다. -> 다시 그리기 요청
        textView.setText((index+1)+"/"+(imgFiles.size()));
    }
}