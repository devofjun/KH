package com.kh.prac7_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    View toastView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(MainActivity.this);
                toastView = View.inflate(MainActivity.this, R.layout.view_toast, null);
                toast.setView(toastView);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                // 화면크기 구하기
                ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
                int width = displayMetrics.widthPixels - 100;
                int height = displayMetrics.heightPixels - 100;
                // 랜덤좌표
                int xOffset = (int)(Math.random() * width);
                int yOffset = (int)(Math.random() * height);
                // 메세지 위치 지정
                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                toast.show();
            }
        });
    }
}