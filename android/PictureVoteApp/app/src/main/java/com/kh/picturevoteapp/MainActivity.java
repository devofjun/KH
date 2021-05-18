package com.kh.picturevoteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnVote;
    ImageView[] imageViews = new ImageView[9];
    int[] ivIDs = {
            R.id.iv1, R.id.iv2, R.id.iv3,
            R.id.iv4, R.id.iv5, R.id.iv6,
            R.id.iv7, R.id.iv8, R.id.iv9,
    };
    String[] imgNames = {
            "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
            "이레느깡 단 베르앙", "잠자는 소녀", "테라스의 두 자매",
            "피아노 레슨", "피아노 앞의 소녀들", "해변에서"
    };
    int [] voteCounts = new int[9];
    final int MAX_COUNT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }

    private void setUI() {
        // 이미지뷰 등록
        for(int i=0; i<imageViews.length; i++){
            imageViews[i] = findViewById(ivIDs[i]);
            imageViews[i].setOnClickListener(this);
        }
        btnVote = findViewById(R.id.btnVote);
        btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("imgNames", imgNames);
                intent.putExtra("VoteCounts", voteCounts);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        //Log.d("mytag", v.toString());
        for(int i=0; i<imageViews.length; i++){
            if (v == imageViews[i]){
                //Log.d("mytag", ""+i);
                if(voteCounts[i] < MAX_COUNT) {
                    ++voteCounts[i];
                    String message = imgNames[i] + ": 총 " + voteCounts[i] + "표";
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}