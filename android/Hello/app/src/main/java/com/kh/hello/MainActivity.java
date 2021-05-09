package com.kh.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { // JFrame을 상속받은거라고 생각

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); // xml를 말하는것
        setContentView(R.layout.activity_re);
        // xml작업이 일어난 이후에 btn1을 가져올수 있다.
        btn1 = (Button)findViewById(R.id.btn1); // (Button)은 생략가능
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "버튼을 눌렀어요",Toast.LENGTH_LONG).show();
            }
        });
    }
}