package com.example.share_feedback_damo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedBack_Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText text1,text2;
    private Button send,clean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_);

        text1=(EditText)findViewById(R.id.idittext1);
        text2=(EditText)findViewById(R.id.idittext2);

        send=(Button)findViewById(R.id.sendid);
        clean=(Button)findViewById(R.id.cleanid);
        send.setOnClickListener(this);
        clean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try{
            String name = text1.getText().toString();
            String massage=text2.getText().toString();

            if(v.getId()==R.id.cleanid){
                text1.setText("");
                text2.setText("");
            }
            if(v.getId()==R.id.sendid){

                Intent inten = new Intent(Intent.ACTION_SEND);
                inten.setType("text/email");
                inten.putExtra(Intent.EXTRA_EMAIL,new String [] {"mahibulhassan842@gmail.com"});
                inten.putExtra(Intent.EXTRA_SUBJECT,"Feedback From App");
                inten.putExtra(Intent.EXTRA_TEXT,"Name: "+name+"\n Message : "+massage);
                startActivity(Intent.createChooser(inten,"Feedback With"));

            }
        }catch (Exception e){

            Toast.makeText(this, "First Fill the Feedback Page.", Toast.LENGTH_SHORT).show();
        }
    }
}