package com.example.radio_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textview;
    private RadioButton radiobuton;
    private RadioGroup rbuton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbuton=(RadioGroup)findViewById(R.id.radioid);
        textview=(TextView)findViewById(R.id.textid);
        button=(Button)findViewById(R.id.selectid);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int select = rbuton.getCheckedRadioButtonId();
                radiobuton =(RadioButton) findViewById(select);
                String str = radiobuton.getText().toString();
              //  textview.setText(str+" is selected....");

                Toast.makeText(MainActivity.this,str +" is selected ",Toast.LENGTH_SHORT).show();
            }
        });

    }
}