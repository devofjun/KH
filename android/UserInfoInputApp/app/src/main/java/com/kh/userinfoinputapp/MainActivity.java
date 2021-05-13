package com.kh.userinfoinputapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView txtName,txtEmail;
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
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("사용자 정보 입력");
        dlg.setIcon(R.mipmap.ic_launcher);
        dialogView = View.inflate(MainActivity.this, R.layout.view_dialog, null);
        dlg.setView(dialogView);
        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialogName = dialogView.findViewById(R.id.edtName);
                dialogEmail = dialogView.findViewById(R.id.edtEmail);

                txtName.setText(dialogName.getText().toString());
                txtEmail.setText(dialogEmail.getText().toString());

                Toast toast = new Toast(MainActivity.this);
                toastView = View.inflate(MainActivity.this, R.layout.view_toast, null);
                toast.setView(toastView);
                toast.show();
            }
        });
        dlg.setNegativeButton("취소",null);
        dlg.show();
    }
}