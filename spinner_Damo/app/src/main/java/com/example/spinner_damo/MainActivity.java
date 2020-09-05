package com.example.spinner_damo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.spinner_damo.R.id.spinnerid;

public class MainActivity extends AppCompatActivity {
    String [] str;
    private Spinner spinner;
    private TextView text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(spinnerid);
        text=(TextView)findViewById(R.id.textviewid);
        button=(Button)findViewById(R.id.buttonid);
        str= getResources().getStringArray(R.array.countryname);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.custon_view,R.id.sampleid,str);

        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = spinner.getSelectedItem().toString();
                text.setText(value);
            }
        });
    }
}