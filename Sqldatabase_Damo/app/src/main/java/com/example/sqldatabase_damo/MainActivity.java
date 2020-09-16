package com.example.sqldatabase_damo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nametext,agetext,gendertext,idtext;
    private Button loadbutton,addbutton,updatebutton,deletebutton;

    mysqlheader mysql ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametext= (EditText)findViewById(R.id.edittextnameid);
        agetext= (EditText)findViewById(R.id.edittextageid);
        idtext= (EditText)findViewById(R.id.edittextidid);
        gendertext= (EditText)findViewById(R.id.edittextgenderid);

        loadbutton=(Button)findViewById(R.id.loaddbuttonid);
        addbutton=(Button)findViewById(R.id.addbuttonid);
        deletebutton=(Button)findViewById(R.id.deletebuttonid);
        updatebutton=(Button)findViewById(R.id.updatebuttonid);

        mysql = new mysqlheader(this);
        SQLiteDatabase database = mysql.getWritableDatabase();

        addbutton.setOnClickListener(this);
        loadbutton.setOnClickListener(this);
        updatebutton.setOnClickListener(this);
        deletebutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.addbuttonid){
            String name = nametext.getText().toString();
            String age = agetext.getText().toString();
            String gender = gendertext.getText().toString();
            long rowid= mysql.insertdata(name,age,gender);
            if(rowid != -1){
                Toast.makeText(this,"Row inserted "+rowid,Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Unsuccessfull Insertion.",Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId()==R.id.loaddbuttonid){
            Cursor cursor = mysql.getdata();
            if(cursor.getCount()==0){
                showdata("Error","NO data Found");
                return ;
            }

            StringBuffer stringBuffer = new StringBuffer();
            while(cursor.moveToNext()){
                stringBuffer.append("ID : "+cursor.getString(0)+"\n");
                stringBuffer.append("Name : "+cursor.getString(1)+"\n");
                stringBuffer.append("Age : "+cursor.getString(2)+"\n");
                stringBuffer.append("Gender : "+cursor.getString(3)+"\n\n\n");
            }
            showdata("Student Details",stringBuffer.toString());
        }else if(v.getId()==R.id.updatebuttonid){

            String id = idtext.getText().toString();
            String name = nametext.getText().toString();
            String age = agetext.getText().toString();
            String gender = gendertext.getText().toString();

            boolean isupdate =mysql.updatedata(name,age,gender,id);

            if(isupdate==true){
                Toast.makeText(this,"Data is Updated.",Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this,"Data is not updated.",Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId()==R.id.deletebuttonid){

            String id = idtext.getText().toString();
            int check = mysql.deletedata(id);
            if(check>0){
                Toast.makeText(this,"Data is Deleted.",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Data is not Deleted.",Toast.LENGTH_SHORT).show();
            }
        }


    }



    public void showdata(String dataresult, String message) {
        AlertDialog.Builder bulder = new AlertDialog.Builder(this);
        bulder.setTitle(dataresult);
        bulder.setMessage(message);
        bulder.setCancelable(true);
        bulder.show();
    }

}