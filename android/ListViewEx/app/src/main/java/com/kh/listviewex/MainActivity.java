package com.kh.listviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] list = {
            "연결", "T 로밍 & 서비스", "소리 및 진동", "알림", "디스플레이",
            "배경화면", "테마", "홈 화면", "잠금화면", "개인정보 보호"
    };
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("mytag", "position: "+position);
                try{
                    toast.cancel();
                } catch (Exception e){}
                finally {
                    toast = Toast.makeText(getApplicationContext(), list[position], Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}