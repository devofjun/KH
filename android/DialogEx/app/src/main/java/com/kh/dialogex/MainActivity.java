package com.kh.dialogex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View v) {
        // 다이얼로그 생성
        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        // 다이얼로그 설정
        dlg.setTitle("알림");
        dlg.setMessage("삭제하시겠습니까?");
        dlg.setIcon(R.mipmap.ic_launcher);
        // 확인버튼, 리스너
        dlg.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "삭제했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        // 아니오 버튼
        dlg.setNegativeButton("NO",null);
        // cancel 버튼(잘 쓰이지 않음)
        dlg.setNeutralButton("cancel",null);
        // 다이얼로그 보이기
        dlg.show();
    }
}