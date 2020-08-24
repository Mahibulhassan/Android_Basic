package com.example.datepikker_dialouge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.DatePicker;

import static com.example.datepikker_dialouge.R.id.buttonid;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button button;
    private TextView textview;
    private DatePickerDialog picker = new DatePickerDialog(this);
    private DatePicker date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button)findViewById(buttonid);
        textview=(TextView)findViewById(R.id.textid);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        StringBuilder str = new StringBuilder();
        date = new DatePicker(this);
        int Year=date.getYear();
        int Month=date.getMonth();
        int Day = date.getDayOfMonth();

        picker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                textview.setText(dayOfMonth+" / "+month+" / "+year);

            }
        },Year,Month,Day);

        picker.show();


    }
}