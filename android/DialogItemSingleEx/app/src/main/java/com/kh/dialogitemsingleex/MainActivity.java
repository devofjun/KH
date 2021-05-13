package com.kh.dialogitemsingleex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String[] items = {"강아지","고양이","토끼"};
    int checkedItem = 0;
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

    private void showDialog() {
        // 다이얼로그 생성
        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        dlg.setTitle("선택 다이얼로그");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            // 확인버튼을 눌렀을때 글자를 바꿈
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btn.setText(items[checkedItem]);
            }
        });

        // 라디오버튼생성
        dlg.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checkedItem = which;
            }
        });

        // 다이얼로그 보이기
        dlg.show();
    }
}