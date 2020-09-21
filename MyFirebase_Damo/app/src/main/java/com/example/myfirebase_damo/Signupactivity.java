package com.example.myfirebase_damo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signupactivity extends AppCompatActivity implements View.OnClickListener {
    private Button signup;
    private EditText signupemail,signuppassword,signupname;
    private TextView signintext;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        this.setTitle("Sign up Activity");

        //Fire base auth
        mAuth = FirebaseAuth.getInstance();

        //Finding Button, edit text

        signup=(Button)findViewById(R.id.signupbuttonid);
        signupemail=(EditText)findViewById(R.id.signupemailedittextid);
        signuppassword=(EditText)findViewById(R.id.signuppasswordedittextid);
        signupname=(EditText)findViewById(R.id.signupnameedittextid);
        signintext =(TextView)findViewById(R.id.signintextid);
        progressbar=(ProgressBar)findViewById(R.id.progressba2ndrid);

        //Adding listner....
        signup.setOnClickListener(this);
        signintext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.signintextid:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                break;

            case R.id.signupbuttonid:
                Userregister();
                break;


        }

    }

    private void Userregister() {
        String email = signupemail.getText().toString();
        String password = signuppassword.getText().toString();

        //Email and password validity test..

        if(email.isEmpty())
        {
            signupemail.setError("Enter an Email Address");
            signupemail.requestFocus();
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signupemail.setError("Enter a Valid Email Address");
            signupemail.requestFocus();
            return ;
        }

        if(password.isEmpty())
        {
            signupemail.setError("Enter an Email Address");
            signupemail.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signupemail.setError("Enter a Valid Email Address");
            signupemail.requestFocus();
            return ;
        }
        progressbar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressbar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Resister is Successfull",Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getApplicationContext(),"Resister is not Successfull",Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

}