package com.example.edittext_withlistner_addition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private Button button1,button2;
     private EditText edittext1,edittext2;
     private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.addid);
        button2=(Button)findViewById(R.id.subid);
        edittext1=(EditText)findViewById(R.id.text1);
        edittext2=(EditText)findViewById(R.id.text20);
        textview=(TextView)findViewById(R.id.textid);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
     try{
         String s1=edittext1.getText().toString();
         String s2=edittext2.getText().toString();

         double d1=new Double(s1);
         double d2=new Double(s2);

         if(v.getId()==R.id.addid){
             double sum=d1+d2;
             textview.setText("Result is : "+sum);
         }
         else
         {
             double sum=d1-d2;
             textview.setText("Result is : "+sum);
         }
     }catch(Exception e){
         Toast.makeText(this,"Enter number first..",Toast.LENGTH_SHORT).show();
     }

    }
}