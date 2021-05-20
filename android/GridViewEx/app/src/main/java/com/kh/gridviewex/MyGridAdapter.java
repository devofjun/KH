package com.kh.gridviewex;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyGridAdapter extends BaseAdapter {

    Context context;
    int cell_view; // res/layout/cell_view.xml
    int[] data;

    public MyGridAdapter(Context context, int cell_view, int[] data) {
        this.context = context;
        this.cell_view = cell_view;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
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
        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(data[position]);
        return convertView;
    }
}
