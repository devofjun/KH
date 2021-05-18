package com.kh.picturevoteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    ImageView topImg;
    TextView topImgName;
    int[] imgIds = {
            R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9
    };

    TextView[] textViews = new TextView[9];
    RatingBar[] ratingBars = new RatingBar[9];
    Button btnReturn;
    int[] tvIds = {
            R.id.tv1,R.id.tv2,R.id.tv3,
            R.id.tv4,R.id.tv5,R.id.tv6,
            R.id.tv7,R.id.tv8,R.id.tv9,
    };
    int[] rBardIds = {
            R.id.rBar1,R.id.rBar2,R.id.rBar3,
            R.id.rBar4,R.id.rBar5,R.id.rBar6,
            R.id.rBar7,R.id.rBar8,R.id.rBar9,
    };
    String[] imgNames;
    int[] voteCounts;

    int topRating = 0;
    int topRatingIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // MainActivity에서 보내진 부가정보 얻기
        Intent intent = getIntent();
        imgNames = intent.getStringArrayExtra("imgNames");
        voteCounts = intent.getIntArrayExtra("VoteCounts");
//        for(int i=0; i< imgNames.length; i++){
//            Log.d("mytag", imgNames[i]+": "+voteCounts[i]);
//        }

        setUI();
    }
    private void setUI() {
        for(int i=0; i<tvIds.length; i++){
            textViews[i] = findViewById(tvIds[i]);
            ratingBars[i] = findViewById(rBardIds[i]);
            textViews[i].setText(imgNames[i]);
            ratingBars[i].setRating(voteCounts[i]);
            if(topRating < voteCounts[i]){
                topRating = voteCounts[i];
                topRatingIdx = i;
            }
        }

        topImgName = findViewById(R.id.topImgName);
        topImg = findViewById(R.id.topImg);
        topImgName.setText(imgNames[topRatingIdx]);
        topImg.setImageResource(imgIds[topRatingIdx]);

        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}