package com.example.progress_bar_damo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressbar;
    public int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressbar = (ProgressBar)findViewById(R.id.prgoressbarid);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                dowork();

            }
        });

        thread.start();
    }

    public void dowork(){

        for(progress=10;progress<=100;progress+=10) {

            try {
                Thread.sleep(1000);
                progressbar.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}