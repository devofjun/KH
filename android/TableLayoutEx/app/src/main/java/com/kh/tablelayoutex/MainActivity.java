package com.kh.tablelayoutex;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button[] btnNums = new Button[10];
    int[] numsId = {
            R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
            R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9
    };

    EditText edt1, edt2;

    Button btnAdd, btnSub, btnMul, btnDiv;

    TextView resultTV;

    View.OnClickListener lis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button)v;
            String str = btn.getText().toString();

            if(edt1.isFocused()){
                String text = edt1.getText().toString();
                if(text.equals("") && !str.equals("0")){
                    edt1.setText(str);
                } else if(!text.equals("") && !str.equals("0")) {
                    edt1.setText(text + str);
                } else if(!text.equals("") && str.equals("0")) {
                    edt1.setText(text + str);
                }
            } else if (edt2.isFocused()) {
                String text = edt2.getText().toString();
                if(text.equals("") && !str.equals("0")){
                    edt2.setText(str);
                } else if(!text.equals("") && !str.equals("0")) {
                    edt2.setText(text + str);
                } else if(!text.equals("") && str.equals("0")) {
                    edt2.setText(text + str);
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btnAdd = findViewById(R.id.addBtn);
        btnSub = findViewById(R.id.sumBtn);
        btnMul = findViewById(R.id.mulBtn);
        btnDiv = findViewById(R.id.divBtn);
        resultTV = findViewById(R.id.resultTV);


        for(int i=0; i<numsId.length; i++){
            btnNums[i] = findViewById(numsId[i]);
            btnNums[i].setOnClickListener(lis);
        }
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str1 = edt1.getText().toString();
        String str2 = edt2.getText().toString();
        Log.d("mytag",str1);
        Log.d("mytag",str2);
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        if(v == btnAdd){
            //Log.d("mytag","더하기");
            int result = num1 + num2;
            resultTV.setText("계산결과: " + String.valueOf(result));
        } else if(v == btnSub) {
            //Log.d("mytag","빼기");
            int result = num1 - num2;
            resultTV.setText("계산결과: " + String.valueOf(result));
        } else if(v == btnMul) {
            //Log.d("mytag","곱하기");
            int result = num1 * num2;
            resultTV.setText("계산결과: " + String.valueOf(result));
        } else if(v == btnDiv) {
            //Log.d("mytag","나누기");
            int result = num1 / num2;
            resultTV.setText("계산결과: " + String.valueOf(result));
        }
    }
}