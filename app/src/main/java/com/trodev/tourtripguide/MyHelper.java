package com.trodev.tourtripguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(@Nullable Context context) {
        super(context, Constant.DB_NAME, null, Constant.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table on that db
        db.execSQL(Constant.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //upgrade database if there any structure changed

        //drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + Constant.TABLE_NAME);

        //create table again
        onCreate(db);

    }

    //insert record
    public long insertRecord(String name, String image, String bio, String phone,
                             String ticket, String date, String addedTime, String updateTime) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        //id will be inserted automatically
        values.put(Constant.C_NAME, name);
        values.put(Constant.C_IMAGE, image);
        values.put(Constant.C_BIO, bio);
        values.put(Constant.C_PHONE, phone);
        values.put(Constant.C_TICKET, ticket);
        values.put(Constant.C_DATE, date);
        values.put(Constant.C_ADDED_TIMESTAMP, addedTime);
        values.put(Constant.C_UPDATE_TIMESTAMP, updateTime);


        long id = db.insert(Constant.TABLE_NAME, null, values);

        //close db
        db.close();

        return id;

    }

}
