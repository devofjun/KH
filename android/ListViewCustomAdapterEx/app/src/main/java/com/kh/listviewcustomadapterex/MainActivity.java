package com.kh.listviewcustomadapterex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    int[] drawables = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10
    };

    String[] mvTitle = {
            "토이스토리4", "호빗: 다섯 군대 전투", "제이슨 본", "반지의 제왕", "정직한 후보",
            "나쁜 녀석들: 포에버", "겨울 왕국 2", "알라딘", "극한직업", "스파이더맨: 파 프롬 홈"
    };

    String[] mvDirector = {
            "조시 쿨리", "피터 잭슨", "폴 그린그래스", "피터 잭슨", "장유정",
            "아딜 엘 아르비", "크리스 벅", "존 머스커", "이병헌", "존 왓츠"
    };
    ArrayList<MovieVo> mvList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<drawables.length; i++){
            MovieVo vo = new MovieVo(drawables[i], mvTitle[i], mvDirector[i]);
            mvList.add(vo);
        }

        gridView = findViewById(R.id.gridView);

        gridView.setAdapter(new MyGridAdapter(this, R.layout.cell_view, drawables, mvTitle, mvDirector));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_view, null);
                ImageView poster = dialogView.findViewById(R.id.ivPoster);
                poster.setImageResource(drawables[position]);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(mvTitle[position]);
                dialog.setView(dialogView);
                dialog.setPositiveButton("닫기", null);
                dialog.show();
            }
        });
    }
}