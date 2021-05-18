package com.kh.bidirectionintentex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button btnReturn;
    int result =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnReturn = findViewById(R.id.btnReturn);
        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);
        result = num1 + num2;
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 위에서 getIntent로 받은 인텐트가 아니고 새로 만든 인텐트
                // MainActivity는 하나의 파일이라고 생각하면 된다.
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("result", result);
//                startActivity(intent);
                // intent(MainActivity)로 RESULT_OK 결과를 준다.
                // MainActivity라고 지정해준 이유는 여러 Activity가 열려 있을 수 있기 때문에 지정해줘야한다.
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}