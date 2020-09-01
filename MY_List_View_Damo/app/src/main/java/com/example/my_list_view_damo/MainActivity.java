package com.example.my_list_view_damo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.listviewid);
        final String [] str=getResources().getStringArray(R.array.country_name);

        ArrayAdapter<String>adapter= new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,R.id.textviewid,str);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Name = str[position];
                Toast.makeText(MainActivity.this,Name+" "+position,Toast.LENGTH_SHORT).show();
            }
        });

    }
}