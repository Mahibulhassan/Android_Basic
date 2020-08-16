package com.example.button_with_listner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;
    Button buton1,buton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         text=(TextView)findViewById(R.id.text1);
        buton1=(Button)findViewById(R.id.Buton1);
         buton2=(Button)findViewById(R.id.buton2);
         buton1.setOnClickListener(this);
         buton2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

            if(v.getId()==R.id.Buton1){
                text.setText("This is 1st Button");
            }
            else
            {
                text.setText("This is 2nd Button");
            }

    }
}