package com.example.datastore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText user,password;
    private TextView textview;
    private Button save,load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.edittextid);
        password=(EditText)findViewById(R.id.edittextid2);
        textview=(TextView)findViewById(R.id.textid);
        save=(Button)findViewById(R.id.saveid);
        load=(Button)findViewById(R.id.loadid);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.saveid){
            String username = user.getText().toString();
            String pass = password.getText().toString();
            if(username.equals("") && pass.equals("")){
                Toast.makeText(this,"First Fill The Text",Toast.LENGTH_SHORT).show();
            }
            else {
                SharedPreferences sharedpreferences = getSharedPreferences("Username", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("username", username);
                editor.putString("password", pass);
                editor.commit();

                Toast.makeText(this,"Data Save Successfully",Toast.LENGTH_SHORT).show();
                user.setText("");
                password.setText("");
            }
        }
        else if(v.getId()==R.id.loadid){

            SharedPreferences sharedpreferences = getSharedPreferences("Username", Context.MODE_PRIVATE);
            if(sharedpreferences.contains("username")&& sharedpreferences.contains("password")){
                String username = sharedpreferences.getString("username","Data NOt Found");
                String password = sharedpreferences.getString("password","Data NOt Found");
                textview.setText(username+"\n"+password);
            }
        }

    }
}