package com.example.share_feedback_damo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        inflater.inflate(R.menu.custom_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.settingid)
        {

        }
         if(item.getItemId()==R.id.feedbackid){
             Intent inten = new Intent(getApplicationContext(),feedBack_Activity.class);
             startActivity(inten);
        }
         if(item.getItemId()==R.id.shareid){

             Intent intent = new Intent(Intent.ACTION_SEND);
             intent.setType("type/plain");
             String sub = "This is learnig app..";
             String body = "Sharing is careing";
             intent.putExtra(Intent.EXTRA_SUBJECT,sub);
             intent.putExtra(Intent.EXTRA_TEXT,body);
             startActivity(Intent.createChooser(intent,"Share With"));
         }


        return super.onOptionsItemSelected(item);
    }
}