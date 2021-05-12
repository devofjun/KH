package com.kh.viewflipperself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnStop;
    ViewFlipper viewFlipper;
    //boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        viewFlipper = findViewById(R.id.viewFlipper);
        //nextView nv = new nextView();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setFlipInterval(1000);
                viewFlipper.startFlipping();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.stopFlipping();
            }
        });
    }
    /* 안드로이드의 쓰레드는 좀 다르다.
    class nextView implements Runnable {

        @Override
        public void run() {
            try {
                while(flag) {
                    Thread.sleep(1000);
                    viewFlipper.showNext();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
     */
}