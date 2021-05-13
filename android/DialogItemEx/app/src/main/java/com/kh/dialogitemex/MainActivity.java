package com.kh.dialogitemex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String[] items = {"강아지", "고양이", "토끼"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("목록 다이얼로그");
        dlg.setIcon(R.mipmap.ic_launcher);

        // 항목
        dlg.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which : items의 인덱스
                String text = items[which];
                btn.setText(text);
            }
        });
        // 닫기 버튼
        dlg.setPositiveButton("닫기",null);
        // 보이기
        dlg.show();
    }
}