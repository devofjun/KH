package com.kh.menujavaex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int RED = 1;
    final int GREEN = 2;
    final int BLUE = 3;
    final int ROTATE = 4;
    final int SCALE = 5;

    LinearLayout baseLayout;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseLayout = findViewById(R.id.baseLayout);
        btn = findViewById(R.id.btn);
    }

    // 옵션 메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴
        menu.add(Menu.NONE,RED,Menu.NONE,"배경색(빨강)");
        menu.add(Menu.NONE,GREEN,Menu.NONE,"배경색(초록)");
        menu.add(Menu.NONE,BLUE,Menu.NONE,"배경색(파랑)");
        // 서브메뉴
        SubMenu subMenu = menu.addSubMenu("버튼 변경");
        // 서브메뉴 선택하면 id값은 0이 된다.
        subMenu.add(Menu.NONE,ROTATE,Menu.NONE,"버튼45도 변경");
        subMenu.add(Menu.NONE,SCALE, Menu.NONE, "버튼2배 확대");

        return super.onCreateOptionsMenu(menu);
    }

    // 옵션메뉴 선택
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == RED) {
            baseLayout.setBackgroundColor(Color.RED);
        } else if(id == GREEN) {
            baseLayout.setBackgroundColor(Color.GREEN);
        } else if(id == BLUE) {
            baseLayout.setBackgroundColor(Color.BLUE);
        } else if(id == ROTATE) {
            btn.setRotation(btn.getRotation() + 45);
        } else if(id == SCALE) {
            btn.setScaleX(btn.getScaleX()*2);
            btn.setScaleY(btn.getScaleY()*2);
        }
        return super.onOptionsItemSelected(item);
    }
}