package com.kh.readraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnRead;
    EditText edtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRead = findViewById(R.id.btnRead);
        edtxt = findViewById(R.id.edtxt);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // /res/raw/raw_test.txt
                // /res : 파일명(소문자, _, 숫자), 확장자는 따지지 않는다.
                // 이건 왜 try catch문을 안써도 되는가?
                InputStream inputS = getResources().openRawResource(R.raw.raw_test);
                try {
                    // inputS.available()입력 스트림에서 읽을 수 있는 바이트수를 반환한다.
                    // "Hello 안녕하세요" => 6바이트+15바이트 = 21바이트
                    byte[] txt = new byte[inputS.available()];
                    //Log.d("test",inputS.available()+"");
                    inputS.read(txt);
                    edtxt.setText(new String(txt));
                    inputS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}