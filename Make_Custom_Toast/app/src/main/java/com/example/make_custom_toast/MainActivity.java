package com.example.make_custom_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static com.example.make_custom_toast.R.id.layoutid;

public class MainActivity extends AppCompatActivity {
     private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inlit = getLayoutInflater();
               View custom= inlit.inflate(R.layout.custom_toast, (ViewGroup) findViewById(layoutid));
               Toast tost = new Toast(MainActivity.this);
               tost.setDuration(Toast.LENGTH_SHORT);
               tost.setView(custom);
               tost.show();

            }
        });
    }
}