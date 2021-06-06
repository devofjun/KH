package com.example.ui_android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdaper extends BaseAdapter {
    Context context;
    int cell_view; // res/layout/cell_view.xml
    ArrayList<UIVO> voList;

    // 생성자(유지될 context, 그리려는 뷰, 그려질 목록)
    public MyListAdaper(Context context, int cell_view, ArrayList<UIVO> voList) {
        this.context = context;
        this.cell_view = cell_view;
        this.voList = voList;
    }

    @Override
    public int getCount()  {
        return voList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(cell_view, null);
        }
        // cell의 레이아웃의 아이디 -> 각 아이템마다 색 변경
        LinearLayout lnLayout = convertView.findViewById(R.id.cellLayout);
        if(position%2 == 0) {
            lnLayout.setBackgroundColor(Color.parseColor("#c0c0c0"));
        } else {
            lnLayout.setBackgroundColor(Color.parseColor("#dcdcdc"));
        }
        //Log.d("test",voList.get(position)+"");
        // 각각의 TextView 의 text 에 데이터를 voList 의 데이터를 넣음.
        // 학번
        TextView cellSNO = convertView.findViewById(R.id.cellSNO);
        cellSNO.setText(voList.get(position).getSNO());
        // 이름
        TextView cellSNAME = convertView.findViewById(R.id.cellSNAME);
        cellSNAME.setText(voList.get(position).getSNAME());
        // 학년 -> 문자로 변환 후 출력
        TextView cellSYEAR = convertView.findViewById(R.id.cellSYEAR);
        cellSYEAR.setText(String.valueOf(voList.get(position).getSYEAR()));
        // 성별
        TextView cellGENDER = convertView.findViewById(R.id.cellGENDER);
        cellGENDER.setText(voList.get(position).getGENDER());
        // 전공
        TextView cellMAJOR = convertView.findViewById(R.id.cellMAJOR);
        cellMAJOR.setText(voList.get(position).getMAJOR());
        // 점수 -> 문자로 변환 후 출력
        TextView cellSCORE = convertView.findViewById(R.id.cellSCORE);
        cellSCORE.setText(String.valueOf(voList.get(position).getSCORE()));
        return convertView;
    }

}
