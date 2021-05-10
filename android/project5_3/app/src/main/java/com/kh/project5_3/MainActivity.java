package com.kh.project5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT
        );

        EditText editText = new EditText(this);
        editText.setText("test");
        linear.addView(editText);

        Button button = new Button(this);
        button.setText("버튼입니다.");
        button.setBackgroundColor(Color.YELLOW);
        linear.addView(button);

        TextView tv = new TextView(this);
        tv.setText("test");
        linear.addView(tv);
        setContentView(linear,params);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable str = editText.getText();
                tv.setText(str);
            }
        });

    }
}