package com.kh.self10_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    RadioButton rbAdd, rbSub, rbMul, rbDiv;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        rbAdd = findViewById(R.id.rbAdd);
        rbSub = findViewById(R.id.rbSub);
        rbMul = findViewById(R.id.rbMul);
        rbDiv = findViewById(R.id.rbDiv);
        btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edtNum1.getText().toString();
                String str2 = edtNum2.getText().toString();
                int num1 = 0;
                int num2 = 0;

                if (str1 != null && str1.trim().length() != 0){
                    num1 = Integer.parseInt(str1);
                }
                if (str2 != null && str2.trim().length() != 0) {
                    num2 = Integer.parseInt(str2);
                }

                char operator = ' ';
                if(rbAdd.isChecked() == true){
                    operator = '+';
                } else if(rbSub.isChecked() == true) {
                    operator = '-';
                } else if(rbMul.isChecked() == true) {
                    operator = '*';
                } else if(rbDiv.isChecked() == true) {
                    operator = '/';
                }

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("num1", num1);
                intent.putExtra("num2", num2);
                intent.putExtra("operator", operator);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            int result = data.getIntExtra("result", 0);
            String message = "결과" + result;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}