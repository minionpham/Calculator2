package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
Button btnxoa;
ListView lvhistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        lvhistory=findViewById(R.id.lvhistory);
        btnxoa=findViewById(R.id.btnxoa);
        DataAdapter adapter=new DataAdapter(this,Trunggian.kqpheptinh);
        lvhistory.setAdapter(adapter);
         btnxoa.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Trunggian.kqpheptinh.clear();
                 adapter.notifyDataSetChanged();
             }
         });
    }
}