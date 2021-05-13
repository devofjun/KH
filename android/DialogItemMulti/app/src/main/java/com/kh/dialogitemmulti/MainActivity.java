package com.kh.dialogitemmulti;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String[] items = {"강아지","고양이","토끼"};
    boolean[] checkeds = {true, false, false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
    }
    public void showDialog(View v) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("체크박스 아이템");
        dialog.setIcon(R.mipmap.ic_launcher);

        // 체크박스 아이템 - 여러개 선택
        dialog.setMultiChoiceItems(items, checkeds, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // checkeds[which] = isChecked;
                // -> 자동 처리됨
            }
        });

        dialog.setPositiveButton("닫기", null);

        dialog.show();
    }
}