package com.example.my_list_view_damo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.listviewid);
        String [] str=getResources().getStringArray(R.array.country_name);
        ArrayAdapter<String>adapter= new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,R.id.textviewid,str);
        list.setAdapter(adapter);

    }
}