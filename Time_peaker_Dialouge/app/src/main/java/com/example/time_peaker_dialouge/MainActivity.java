package com.example.time_peaker_dialouge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private TimePickerDialog picker;
    private TimePicker time;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text =(TextView)findViewById(R.id.textid);

        button=(Button)findViewById(R.id.buttonid);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        TimePicker time = new TimePicker(this);

        int Hour =time.getHour();
        int Min = time.getMinute();

        picker =new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                text.setText("Miute is: "+minute+" / "+"Hour is : "+hourOfDay);

            }
        },Hour,Min,true);

        picker.show();

    }
}