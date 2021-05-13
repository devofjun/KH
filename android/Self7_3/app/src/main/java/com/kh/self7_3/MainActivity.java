package com.kh.self7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    EditText txtName,txtEmail;
    Button btnClick;
    View dialogView, toastView;
    EditText dialogName, dialogEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        btnClick = findViewById(R.id.btnClick);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
    private void showDialog() {
        // 생성, 설정
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("사용자 정보 입력");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                txtName.setText(dialogName.getText());
                txtEmail.setText(dialogEmail.getText());
            }
        });
        dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = new Toast(MainActivity.this);
                toastView = View.inflate(MainActivity.this, R.layout.view_toast, null);
                toast.setView(toastView);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                // 화면크기 구하기
                ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
                int width = displayMetrics.widthPixels - 100;
                int height = displayMetrics.heightPixels - 100;
                // 랜덤좌표
                int xOffset = (int)(Math.random() * width);
                int yOffset = (int)(Math.random() * height);
                // 메세지 위치 지정
                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                toast.show();
            }
        });

        // 뷰 설정
        dialogView = View.inflate(MainActivity.this, R.layout.view_dialog, null);
        dialogName = dialogView.findViewById(R.id.edtName);
        dialogEmail = dialogView.findViewById(R.id.edtEmail);
        dialogName.setText(txtName.getText());
        dialogEmail.setText(txtEmail.getText());
        // 뷰 보이기
        dlg.setView(dialogView);
        // 보이기
        dlg.show();
    }
}