package com.kh.autocompletetextviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView auto;
    MultiAutoCompleteTextView multi;
    String[] items = {"CSI-뉴욕","CSI-라스베가스","CSI-마이애미","Friends","Fringe","Lost"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auto = findViewById(R.id.auto);
        multi = findViewById(R.id.multi);

        // Array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                items
        );
        auto.setAdapter(adapter);

        // 토큰은 기본적으로 (,) 밖에 안되지만 새로운 클래스에서 Tokenizer 인터페이스를 구현하면 바꿀수있다.
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        // MultiAutoCompleteTextView는 토큰을 지정해주지 않으면 아예 동작하지 않는다.
        multi.setTokenizer(token);
        multi.setAdapter(adapter);
    }
}