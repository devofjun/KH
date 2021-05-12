package com.kh.toastex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 메서드명 외에는 똑같이 작성(권장되지 않음, 테스트용도)
    public void buttonClicked(View v) {
        // 토스트 생성
        Toast toast = Toast.makeText(this,"토스트",Toast.LENGTH_SHORT);

        // 화면 크기 구하기
        // 아래 display.getWidth()와 display.getHeight은 deprecated 됨
        //Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        //int width = display.getWidth() - 100; // 화면 벗어나지 않게 100을 뺌
        //int height = display.getHeight() - 100;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels - 100;
        int height = displayMetrics.heightPixels - 100;
        // 랜덤좌표
        int xOffset = (int)(Math.random() * width);
        int yOffset = (int)(Math.random() * height);
        // 메세지 위치 지정
        toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);

        // 토스트 보이기
        toast.show();
    }

}