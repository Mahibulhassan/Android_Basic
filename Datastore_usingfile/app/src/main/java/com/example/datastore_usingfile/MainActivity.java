package com.example.datastore_usingfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext= (EditText)findViewById(R.id.edittextid);
        button=(Button)findViewById(R.id.buttonid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text= edittext.getText().toString();
                if(text!=null){
                    savedata(text);

                }else
                {
                    Toast.makeText(MainActivity.this, "Please Enter Your Notes...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        readfile();
    }

    void savedata (String text){
        try {
            FileOutputStream fileoutputstream = openFileOutput("note.txt", Context.MODE_PRIVATE);
            fileoutputstream.write(text.getBytes());
            fileoutputstream.close();
            Toast.makeText(MainActivity.this, "File written..", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


     public void readfile(){
         try {
             FileInputStream input = openFileInput("note.txt");
             InputStreamReader reader = new InputStreamReader(input);
             BufferedReader bufferedReader = new BufferedReader(reader);
             String line;
             StringBuffer stringbuffer = new StringBuffer();

             while((line =bufferedReader.readLine())!=null){
                 stringbuffer.append(line+"\n");
             }
             edittext.setText(stringbuffer.toString());

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }

     }


}