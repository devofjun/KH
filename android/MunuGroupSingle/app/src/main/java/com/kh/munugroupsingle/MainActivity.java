package com.kh.munugroupsingle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements TextWatcher{
    EditText editText1;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        img = findViewById(R.id.img);
        editText1.addTextChangedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.mnDog:
                img.setImageResource(R.drawable.dog);
                item.setChecked(true);
                break;
            case R.id.mnCat:
                img.setImageResource(R.drawable.cat);
                item.setChecked(true);
                break;
            case R.id.mnRabbit:
                img.setImageResource(R.drawable.rabbit);
                item.setChecked(true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String str = editText1.getText().toString();
        if(!str.equals("")) {
            int angle = Integer.parseInt(str);
            img.setRotation(angle);
        } else {
            img.setRotation(0);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}