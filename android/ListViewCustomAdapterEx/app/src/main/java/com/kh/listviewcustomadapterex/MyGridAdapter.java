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
    int[] poster;
    String[] title;
    String[] director;

    public MyGridAdapter(Context context, int cell_view, ArrayList<MovieVo> mvList) {
        this.context = context;
        this.cell_view = cell_view;
        this.poster = poster;
        this.title = title;
        this.director = director;
    }

    @Override
    public int getCount() {
        return poster.length;
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
            lnLayout.setBackgroundColor(Color.parseColor("#a5ea89"));
        } else {
            lnLayout.setBackgroundColor(Color.parseColor("#89a5ea"));
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(poster[position]);
        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        tvTitle.setText(title[position]);
        TextView tvDirector = convertView.findViewById(R.id.tvDirector);
        tvDirector.setText("감독 : "+director[position]);
        return convertView;
    }
}
