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
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10
    };

    String[] mvTitle = {
            "토이스토리4", "호빗: 다섯 군대 전투", "제이슨 본", "반지의 제왕", "정직한 후보",
            "나쁜 녀석들: 포에버", "겨울 왕국 2", "알라딘", "극한직업", "스파이더맨: 파 프롬 홈",
            "토이스토리4", "호빗: 다섯 군대 전투", "제이슨 본", "반지의 제왕", "정직한 후보",
            "나쁜 녀석들: 포에버", "겨울 왕국 2", "알라딘", "극한직업", "스파이더맨: 파 프롬 홈",
            "토이스토리4", "호빗: 다섯 군대 전투", "제이슨 본", "반지의 제왕", "정직한 후보",
            "나쁜 녀석들: 포에버", "겨울 왕국 2", "알라딘", "극한직업", "스파이더맨: 파 프롬 홈"
    };

    String[] mvDirector = {
            "조시 쿨리", "피터 잭슨", "폴 그린그래스", "피터 잭슨", "장유정",
            "아딜 엘 아르비", "크리스 벅", "존 머스커", "이병헌", "존 왓츠",
            "조시 쿨리", "피터 잭슨", "폴 그린그래스", "피터 잭슨", "장유정",
            "아딜 엘 아르비", "크리스 벅", "존 머스커", "이병헌", "존 왓츠",
            "조시 쿨리", "피터 잭슨", "폴 그린그래스", "피터 잭슨", "장유정",
            "아딜 엘 아르비", "크리스 벅", "존 머스커", "이병헌", "존 왓츠"
    };
    ArrayList<MovieVo> mvList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ArrayList.add 영화정보 클래스
        for(int i=0; i<drawables.length; i++){
            MovieVo vo = new MovieVo(drawables[i], mvTitle[i], mvDirector[i]);
            mvList.add(vo);
        }
        // 그리드뷰 id
        gridView = findViewById(R.id.gridView);
        // 그리드뷰의 셀을 어댑터를 통해서 그린다.
        gridView.setAdapter(new MyGridAdapter(this, R.layout.cell_view, mvList));
        // 아이템 리스너
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 다이얼로그를 띄우기 위한 전개자
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_view, null);
                // 전개될 다이얼로그의 이미지 id 가져오기
                ImageView poster = dialogView.findViewById(R.id.ivPoster);
                // 다이얼로그에 이미지 넣기
                poster.setImageResource(mvList.get(position).getImgResource());

                // 다이얼로그 생성
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(mvList.get(position).getMovieName()); // 다이얼로그 제목 = 영화제목
                dialog.setView(dialogView);
                dialog.setPositiveButton("닫기", null);
                dialog.show();
            }
        });
    }
}