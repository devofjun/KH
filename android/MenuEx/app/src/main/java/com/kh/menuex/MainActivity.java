package com.kh.menuex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 이 activity의 제목 설정
        setTitle("배경색 바꾸기");
        baseLayout = findViewById(R.id.baseLayout);
        btn = findViewById(R.id.btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴전개자 가져옴
        MenuInflater inflater = getMenuInflater();
        // (직접만든 메뉴, 타겟이 될 엑티비티의 메뉴);
        inflater.inflate(R.menu.menu1,menu);
        // 직접만든 메뉴를 타겟 메뉴에 그렸으니 super에 정의된 메소드를 이용해서 메뉴를 생성한다.
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 선택된 메뉴 아이템의 아이디
        int id = item.getItemId();
        switch(id) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.btnRotate:
                btn.setRotation(btn.getRotation()+45);
                break;
            case R.id.btnScale:
                btn.setScaleX(btn.getScaleX()*2);
                btn.setScaleY(btn.getScaleY()*2);
                break;
        }
        // 나머지 동작(메뉴닫기?)은 그대로 실행하기위해 super의 메소드를 호출한다.
        return super.onOptionsItemSelected(item);
    }
}