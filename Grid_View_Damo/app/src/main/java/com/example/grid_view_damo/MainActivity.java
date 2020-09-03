package com.example.grid_view_damo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private GridView grid;
    String [] countryname;
    int [] flags ={R.drawable.bangladesh,R.drawable.india,R.drawable.nepal,R.drawable.bhutan,R.drawable.pakistan,
                    R.drawable.australia,R.drawable.saudi,R.drawable.bahrain};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid= (GridView)findViewById(R.id.gradviewid);
        countryname = getResources().getStringArray(R.array.country_name);

        customadapter adapter = new customadapter(this,countryname,flags);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String value = countryname[position];

        Toast.makeText(this,value ,Toast.LENGTH_SHORT).show();

    }
}