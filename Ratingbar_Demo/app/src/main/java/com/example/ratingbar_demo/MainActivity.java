package com.example.ratingbar_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RatingBar ratingbar;
    private TextView  text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingbar=(RatingBar)findViewById(R.id.ratinbarid);
        text=(TextView)findViewById(R.id.textid);

        text.setText("Value is : "+ratingbar.getProgress());

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                text.setText("Value is : "+rating);
            }
        });
    }
}