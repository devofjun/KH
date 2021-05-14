package com.kh.sdcarddirex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    String  filePath = "/sdcard/mydir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // 폴더 생성 메소드
    // onClick 속성사용
    public void makeDir(View v) {
        File f = new File(filePath);
        if(!f.exists()) {
            f.mkdir();
            //f.mkdirs() 여러 디렉토리가 한번에 만들어져야 할 때 사용함
            Toast.makeText(this, "폴더가 생성됨", Toast.LENGTH_SHORT).show();
        }
    }

    // 폴더 삭제 메소드
    // onClick 속성사용
    public void removeDir(View v) {
        File f = new File(filePath);
        if(f.exists()) {
            f.delete();
            Toast.makeText(this, "폴더가 삭제됨", Toast.LENGTH_SHORT).show();
        }
    }
}