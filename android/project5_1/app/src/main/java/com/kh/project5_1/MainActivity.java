package com.kh.project5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // xml의 root element
        LinearLayout linear = new LinearLayout(this);
        linear.setBackgroundColor(Color.GREEN);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        // 버튼생성
        Button button = new Button(this);
        button.setText("버튼입니다.");
        button.setBackgroundColor(Color.MAGENTA);
        // 버튼동작구현
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"코드로 생성한 버튼입니다.", Toast.LENGTH_SHORT).show();
            }
        });
        // 레이아웃에 버튼 추가
        linear.addView(button);
        // 레이아웃 추가
        setContentView(linear,params);
    }
}