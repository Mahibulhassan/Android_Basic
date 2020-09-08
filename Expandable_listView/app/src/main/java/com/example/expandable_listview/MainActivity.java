package com.example.expandable_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView list;
    List <String> listdataheader;
    HashMap<String,List<String>>chielddata;
    private CustomAdapter customadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preparelist();

        list=(ExpandableListView)findViewById(R.id.expanableid);

        customadapter = new CustomAdapter(this,listdataheader,chielddata);
        list.setAdapter(customadapter);

    }

    public void preparelist(){
        String [] header = getResources().getStringArray(R.array.number);
        String [] children=getResources().getStringArray(R.array.spelling);
        listdataheader = new ArrayList<>();
        chielddata = new HashMap<>();
        for(int i=0;i<header.length;i++){
            listdataheader.add(header[i]);
            List<String> value = new ArrayList<>();
            value.add(children[i]);
            chielddata.put(listdataheader.get(i),value);

        }
    }
}