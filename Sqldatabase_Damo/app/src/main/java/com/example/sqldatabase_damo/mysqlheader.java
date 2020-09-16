package com.example.sqldatabase_damo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class mysqlheader extends SQLiteOpenHelper {

    private static final String Databasename = "Student.db";
    private static final String Table_name = "student_table";
    private static final String Id = "_Id";
    private static final String Name = "Name";
    private static final String Gender = "Gender";
    private static final String Age = "Age";
    private static final int version =3;
    Context context;

    public mysqlheader(Context context) {
        super(context, Databasename, null, version);
        this.context= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try
        {
            Toast.makeText(context,"Oncreate Mathod is Created.",Toast.LENGTH_SHORT).show();
            db.execSQL("CREATE TABLE "+Table_name+" ("+Id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Name+" VARCHAR(200), "+Age+" INTEGER, "+Gender+" VARCHAR(25) ); ");
        }catch(Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context,"On upgrade is called ",Toast.LENGTH_SHORT).show();
            db.execSQL("DROP Table if exists "+Table_name);
            onCreate(db);

        }catch (Exception e){

            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }
    }

    public long insertdata(String name, String age, String gender){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name,name);
        contentValues.put(Age,age);
        contentValues.put(Gender,gender);
        long tableid = sqLiteDatabase.insert(Table_name,null,contentValues);
        return tableid;
    }

    public Cursor getdata(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+Table_name,null);
        return cursor;
    }

    public boolean updatedata(String name, String age, String gender , String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name,name);
        contentValues.put(Age,age);
        contentValues.put(Gender,gender);
        contentValues.put(Id,id);
        sqLiteDatabase.update(Table_name,contentValues,Id+" = ?",new String[] {id});
        return true;
    }

    public int deletedata(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(Table_name,Id+" = ?",new String[] {id});
    }


}
