package com.example.zoom_controll_damo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private ZoomControls control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=(ImageView)findViewById(R.id.viedid);
        control=(ZoomControls)findViewById(R.id.controlid);

        control.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x=img.getScaleX();
                float y=img.getScaleY();
                img.setScaleX((float)x+1);
                img.setScaleY((float)y+1);
            }
        });

        control.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x=img.getScaleX();
                float y=img.getScaleY();
                if(x>1 && y>1) {
                    img.setScaleX((float) x - 1);
                    img.setScaleY((float) y - 1);
                }
            }
        });

    }
}