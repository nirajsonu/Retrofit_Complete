package com.neeraj.task.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.neeraj.task.dao.model.UserModel;

public class UserDao extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user";
    private static final String TABLE = "user_details";


    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String MOBILE = "mobile_no";

    public UserDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE + "(" + USERNAME + " TEXT," + PASSWORD + " TEXT, " + MOBILE + " TEXT(10));";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
    public long insert_Record(UserModel record)
    {
     SQLiteDatabase db=getWritableDatabase();
     ContentValues values=new ContentValues();
     values.put(USERNAME,record.getUsername());
     values.put(PASSWORD,record.getPassword());
     values.put(MOBILE,record.getMobile_no());
     return db.insert(TABLE,null,values);
    }
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from user_details where username=? and password=?",new String[]{username,password});
        if(c.getCount()>0) return true;
        else return false;
    }

}