package com.example.cheackbox_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView show;
    private CheckBox milk,water,drink,up7;
    private Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buy=(Button)findViewById(R.id.buttonid);
        show=(TextView)findViewById(R.id.showid);
        milk=(CheckBox)findViewById(R.id.milkid);
        water=(CheckBox)findViewById(R.id.waterid);
        drink=(CheckBox)findViewById(R.id.drinkid);
        up7=(CheckBox)findViewById(R.id.upid);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder str =new StringBuilder();

                if(milk.isChecked()){
                    String vlue = milk.getText().toString();
                    str.append(vlue + " Is Ordered...\n");
                    show.setText(str);
                }

                if(water.isChecked()){
                    String vlue = water.getText().toString();
                    str.append(vlue + " Is Ordered...\n");
                    show.setText(str);
                }

                if(drink.isChecked()){
                    String vlue = drink.getText().toString();
                    str.append(vlue + " Is Ordered...\n");
                    show.setText(str);
                }

                if(up7.isChecked()){
                    String vlue = up7.getText().toString();
                    str.append(vlue + " Is Ordered...\n");
                    show.setText(str);
                }


            }
        });
    }
}