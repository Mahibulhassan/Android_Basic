package com.example.menu_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.settingid)
        {
            Toast.makeText(MainActivity.this,"Settings Selected..",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.feedid)
        {
            Toast.makeText(MainActivity.this,"Feedback Selected..",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.aboutid)
        {
            Toast.makeText(MainActivity.this,"About Selected..",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.Shareid)
        {
            Toast.makeText(MainActivity.this,"Share id Selected..",Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }
}