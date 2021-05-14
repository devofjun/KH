package com.kh.sdcardex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnRead;
    EditText edtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRead = findViewById(R.id.btnRead);
        edtxt = findViewById(R.id.edtxt);

        // 파일 액세스 작업을 허용할지를 묻는 창이 나온다.
        ActivityCompat.requestPermissions(this,
                new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //readFile();
                try {
                    FileInputStream inFs = new FileInputStream("/storage/emulated/0/sd_test.txt");
                    byte[] txt = new byte[inFs.available()];
                    inFs.read(txt);
                    edtxt.setText(new String(txt));
                    inFs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void readFile() {

        String fileTitle = "sd_test.txt";
        File file = new File(Environment.getExternalStorageDirectory(), fileTitle);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String result = "";
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }

            //System.out.println( "불러온 내용 : " + result);
            edtxt.setText(result);
            reader.close();
        } catch (FileNotFoundException e1) {

        } catch (IOException e2) {

        }

    }
}