package com.kh.self4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Edit1, Edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnDiv2;
    TextView textResult;
    String num1, num2;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        Edit1 = findViewById(R.id.Edit1);
        Edit2 = findViewById(R.id.Edit2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnDiv2 = findViewById(R.id.btnDiv2);

        textResult = findViewById(R.id.textResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(!num1.equals("") && !num2.equals("")) {
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과: " + result);
                } else {
                    Toast.makeText(getApplicationContext(), "입력이 필요함", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(!num1.equals("") && !num2.equals("")) {
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과: " + result);
                } else {
                    Toast.makeText(getApplicationContext(), "입력이 필요함", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(!num1.equals("") && !num2.equals("")) {
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과: " + result);
                } else {
                    Toast.makeText(getApplicationContext(), "입력이 필요함", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(!num1.equals("") && !num2.equals("")) {
                    if(!num1.equals("0") && !num2.equals("0")) {
                        result = Double.parseDouble(num1) / Double.parseDouble(num2);
                        textResult.setText("계산 결과: " + result);
                    } else {
                        Toast.makeText(getApplicationContext(), "0으로 나눌수없음", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "입력이 필요함", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDiv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(!num1.equals("") && !num2.equals("")) {
                    if(!num1.equals("0") && !num2.equals("0")) {
                        result = Double.parseDouble(num1) % Double.parseDouble(num2);
                        textResult.setText("계산 결과: " + result);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "입력이 필요함", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}