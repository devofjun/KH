package com.kh.bidirectionintentex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    Button btnAdd, btnSub;
    final int SECOND_CODE = 1001;
    final int THIRED_CODE = 1002;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edtNum1.getText().toString();
                String str2 = edtNum2.getText().toString();
                // 공백이 제거된 문자열 반환 str1.trim() 이런 메소드를 써서 숫자가 정상적으로 입력됐는지 가릴수 있다.
                // 하지만 귀찮으니 parseInt하는 부분을 try에서 실행하고 숫자 변환이 안되면 메세지 나오게 했음.
                try{
                    int num1 = Integer.parseInt(str1);
                    int num2 = Integer.parseInt(str2);
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("num1", num1);
                    intent.putExtra("num2", num2);
                    // result를 받기위한 startActivity 메소드
                    startActivityForResult(intent, SECOND_CODE);
                } catch(NumberFormatException e){
                    Toast.makeText(MainActivity.this, "입력값 확인바람", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edtNum1.getText().toString();
                String str2 = edtNum2.getText().toString();

                try{
                    int num1 = Integer.parseInt(str1);
                    int num2 = Integer.parseInt(str2);
                    Intent intent = new Intent(getApplicationContext(), ThiredActivity.class);
                    intent.putExtra("num1", num1);
                    intent.putExtra("num2", num2);
                    // result를 받기위한 startActivity 메소드
                    startActivityForResult(intent, THIRED_CODE);
                } catch(NumberFormatException e){
                    Toast.makeText(MainActivity.this, "입력값 확인바람", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    // 오버라이드 할때 Nullable 뜨면 그냥 지우면됨.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 어떤 액티비티를 불렀었는지 확인하기 위한 코드 : requestCode
        if(requestCode == SECOND_CODE) {
            if (resultCode == RESULT_OK) {
                Log.d("mytag", "second정상종료됐음");
                int result = data.getIntExtra("result", 0);
                Toast.makeText(MainActivity.this, "결과: " + result, Toast.LENGTH_SHORT).show();
            }
        } else if(requestCode == THIRED_CODE) {
            if(resultCode == RESULT_OK) {
                Log.d("mytag", "thired정상종료됐음");
                int result = data.getIntExtra("result", 0);
                Toast.makeText(MainActivity.this, "결과: " + result, Toast.LENGTH_SHORT).show();
            }
        }
    }
}