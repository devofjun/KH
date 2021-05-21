package com.kh.listviewcustomadapterex;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyGridAdapter extends BaseAdapter {

    Context context;
    int cell_view; // res/layout/cell_view.xml
    ArrayList<MovieVo> mvList;

    // 생성자(유지될 context, 그리려는 뷰, 그려질 목록)
    public MyGridAdapter(Context context, int cell_view, ArrayList<MovieVo> mvList) {
        this.context = context;
        this.cell_view = cell_view;
        this.mvList = mvList;
    }

    @Override
    public int getCount() {
        return mvList.size();
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
        if(convertView == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(cell_view, null);
        }
        LinearLayout lnLayout = convertView.findViewById(R.id.lnLayout);
        if(position%2 == 0) {
            lnLayout.setBackgroundColor(Color.parseColor("#D5F5E3"));
        } else {
            lnLayout.setBackgroundColor(Color.parseColor("#D6EAF8"));
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(mvList.get(position).getImgResource());
        //
        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        tvTitle.setText(mvList.get(position).getMovieName());
        // 감독 이름
        TextView tvDirector = convertView.findViewById(R.id.tvDirector);
        tvDirector.setText("감독 : "+mvList.get(position).getDirector());
        return convertView;
    }
}
