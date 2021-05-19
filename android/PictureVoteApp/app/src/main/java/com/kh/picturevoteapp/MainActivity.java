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
    // 이미지뷰에 대한 아이디값 배열
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
    // 투표 배열
    int [] voteCounts = new int[9];
    // 최대 투표수
    final int MAX_COUNT = 5;

    // 토스트
    Toast toast;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }

    private void setUI() {
        // 이미지뷰
        for(int i=0; i<imageViews.length; i++){
            imageViews[i] = findViewById(ivIDs[i]);
            imageViews[i].setOnClickListener(this);
        }
        // 버튼
        btnVote = findViewById(R.id.btnVote);
        btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로운 액티비티를 생성할 준비
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                // 액티비티에 넘겨줄 데이터
                intent.putExtra("imgNames", imgNames);
                intent.putExtra("VoteCounts", voteCounts);
                // 액티비티 실행 = 새로운 창 열기
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        for(int i=0; i<imageViews.length; i++){
            // 클릭된 이미지 찾기
            if (v == imageViews[i]){
                // 해당 이미지의 투표수 올리기 (최대 5)
                if(voteCounts[i] < MAX_COUNT) {
                    ++voteCounts[i];
                    String message = imgNames[i] + ": 총 " + voteCounts[i] + "표";
                    // 토스트 메세지를 최신 메세지로 출력시키기
                    try{
                        // 설정되지 않은 토스트를 캔슬시키면 오류가 발생하기 때문에 try에서 실행함.
                        toast.cancel();
                    } catch(Exception e) {
                    } finally {
                        // 메세지설정과 출력하기는 꼭 해야하기 때문에 finally에서 실행함.
                        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                // 클릭된 이미지 찾았으니 for문 종료
                break;
            }
        }
    }
}