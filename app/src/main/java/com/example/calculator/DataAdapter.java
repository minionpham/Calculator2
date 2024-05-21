package com.example.calculator;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<String> arrayList;
    public DataAdapter(Activity activity,ArrayList<String> arrayList){
        this.activity=activity;
        this.arrayList=arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View view=inflater.inflate(R.layout.item_history,null);
        TextView textView=view.findViewById(R.id.tvhistory);
        textView.setText(arrayList.get(position));
        return view;
    }
}
