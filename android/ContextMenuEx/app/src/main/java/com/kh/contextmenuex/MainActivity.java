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

        registerForContextMenu(btn1);
        registerForContextMenu(btn2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        if(v == btn1) {
            menu.setHeaderTitle("배경색 변경");
            inflater.inflate(R.menu.menu1, menu);
        } else if (v == btn2) {
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