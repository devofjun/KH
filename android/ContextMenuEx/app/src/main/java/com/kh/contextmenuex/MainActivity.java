package com.kh.contextmenuex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    LinearLayout baseLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        baseLayout = findViewById(R.id.baseLayout);

        // 버튼에 대한 롱클릭 설정
        registerForContextMenu(btn1);
        registerForContextMenu(btn2);
    }

    // 롱클릭이 되었을때
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // 메뉴 전개자
        MenuInflater inflater = getMenuInflater();
        // 어떤 버튼이 롱클릭 되었는지에 따라 다른 메뉴 전개
        if(v == btn1) {
            // 보여질 메뉴 제목 설정
            menu.setHeaderTitle("배경색 변경");
            // 만들어 놓은 메뉴 전개
            inflater.inflate(R.menu.menu1, menu);
        } else if (v == btn2) {
            // 만들어 놓은 메뉴 전개2
            inflater.inflate(R.menu.menu2,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.itemRotate:
                btn2.setRotation(btn2.getRotation()+45);
                break;
            case R.id.itemSize:
                btn2.setScaleX(btn2.getScaleX()*2);
                btn2.setScaleY(btn2.getScaleY()*2);
                break;
        }


        return super.onContextItemSelected(item);
    }
}