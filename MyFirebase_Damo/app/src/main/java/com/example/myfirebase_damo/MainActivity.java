package com.example.myfirebase_damo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button signin;
    private EditText signinemail,signinpassword;
    private TextView signuptext;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign in Activity");

        //Finging Button , text,
        signin=(Button)findViewById(R.id.signinbuttonid);
        signinemail=(EditText)findViewById(R.id.signinemailedittextid);
        signinpassword=(EditText)findViewById(R.id.signinpasswordedittextid);
        signuptext=(TextView)findViewById(R.id.signuptextid);
        progressbar=(ProgressBar)findViewById(R.id.progressbarid);

        //Adding onclick Listener
        signin.setOnClickListener(this);
        signuptext.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.signinbuttonid:



                break;
            case R.id.signuptextid:
                Intent intent = new Intent(getApplicationContext(),Signupactivity.class);
                startActivity(intent);
                break;
        }

    }


}