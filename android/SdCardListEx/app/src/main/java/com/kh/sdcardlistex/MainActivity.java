package com.kh.sdcardlistex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edtxt;
    String filePath = "/sdcard";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        edtxt = findViewById(R.id.edtxt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File f = new File(filePath);
                File[] files = f.listFiles();
                edtxt.append("");
                for(File aFile : files) {
                    String str = "";
                    // 파일의 크기
                    long len = aFile.length();
                    // 파일의 수정날짜
                    long mod = aFile.lastModified();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

                    if (aFile.isDirectory()) {
                        str = "[D]"+ aFile.toString() + " | ";
                        str += len + " | ";
                        str += sdf.format(mod) + "\n";
                    } else if(aFile.isFile()) {
                        str = "[F]"+ aFile.toString() + " | ";
                        str += len + " | ";
                        str += sdf.format(mod) + "\n";
                    }
                    edtxt.append(str);
                }
            }
        });

    }
}