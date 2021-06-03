package com.kh.mediaplayerex;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch switch1;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch1 = findViewById(R.id.switch1);

        player = MediaPlayer.create(this,R.raw.song1);

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switch1.isChecked()) {
//                    player = MediaPlayer.create(MainActivity.this,R.raw.song1);
//                    player.start();
                } else {
                    // 중지
                    // player.stop();
                    // 미디어플레이어를 중지하면 다시 create를 해줘야 다시 미디어를 재생시킬수있다.

                }
            }
        });
    }
}