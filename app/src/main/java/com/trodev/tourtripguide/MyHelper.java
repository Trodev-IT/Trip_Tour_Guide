package com.trodev.tourtripguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.trodev.tourtripguide.models.ModelRecords;

import java.util.ArrayList;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table on that db
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //upgrade database if there any structure changed

        //drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);

        //create table again
        onCreate(db);

    }

    //insert record
    public long insertRecord(String name, String bio, String phone,
                             String ticket, String date, String addedTime, String updateTime) {   //String image,
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        //id will be inserted automatically
        values.put(Constants.C_NAME, name);
        // values.put(Constants.C_IMAGE, image);
        values.put(Constants.C_BIO, bio);
        values.put(Constants.C_PHONE, phone);
        values.put(Constants.C_TICKET, ticket);
        values.put(Constants.C_DATE, date);
        values.put(Constants.C_ADDED_TIMESTAMP, addedTime);
        values.put(Constants.C_UPDATE_TIMESTAMP, updateTime);


        long id = db.insert(Constants.TABLE_NAME, null, values);

        //close db
        db.close();

        return id;

    }

    //insert record
    public void updateRecord(String id, String name, String bio, String phone,
                             String ticket, String date, String addedTime, String updateTime) {   //String image,
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        //id will be inserted automatically
        values.put(Constants.C_NAME, name);
        // values.put(Constants.C_IMAGE, image);
        values.put(Constants.C_BIO, bio);
        values.put(Constants.C_PHONE, phone);
        values.put(Constants.C_TICKET, ticket);
        values.put(Constants.C_DATE, date);
        values.put(Constants.C_ADDED_TIMESTAMP, addedTime);
        values.put(Constants.C_UPDATE_TIMESTAMP, updateTime);


        db.update(Constants.TABLE_NAME, values, Constants.C_ID +" = ?",  new String[]{id});

        //close db
        db.close();

    }

    //get all data
    public ArrayList<ModelRecords> getAllRecords(String orderBy)
    {
        ArrayList<ModelRecords> recordsList = new ArrayList<>();

        String selectQuery = "SELECT  *  FROM  " + Constants.TABLE_NAME + "  ORDER BY  "  + orderBy;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through all record and add to list
        if(cursor.moveToFirst())
        {
            do{
                ModelRecords modelRecords = new ModelRecords(
                        "" +cursor.getInt(cursor.getColumnIndex(Constants.C_ID) ) ,
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_NAME) ),
                        //                ""+cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_BIO) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_PHONE) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_TICKET) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_DATE) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_ADDED_TIMESTAMP) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_UPDATE_TIMESTAMP))
                );

                //add records to list
                recordsList.add(modelRecords);
            } while (cursor.moveToNext());
        }

        //close db
        db.close();

        //return the list
        return recordsList;
    }

    //search data
    public ArrayList<ModelRecords> searchAllRecords(String query)
    {
        ArrayList<ModelRecords> recordsList = new ArrayList<>();

        String selectQuery = "SELECT  *  FROM  " + Constants.TABLE_NAME + "  WHERE   "  + Constants.C_NAME + "  LIKE '%" + query + " %' ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through all record and add to list
        if(cursor.moveToFirst())
        {
            do{
                ModelRecords modelRecords = new ModelRecords(
                        "" +cursor.getInt(cursor.getColumnIndex(Constants.C_ID) ) ,
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_NAME) ),
//                       ""+cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_BIO) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_PHONE) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_TICKET) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_DATE) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_ADDED_TIMESTAMP) ),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_UPDATE_TIMESTAMP))
                );

                //add records to list
                recordsList.add(modelRecords);
            } while (cursor.moveToNext());
        }

        //close db
        db.close();

        //return the list
        return recordsList;
    }

    //delete data using id
    public void deleteData(String id)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Constants.TABLE_NAME, Constants.C_ID +" = ? ", new String[]{id});
        db.close();
    }

    //delete all data from table
    public void deleteAllData()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "  +  Constants.TABLE_NAME);
        db.close();
    }

    //get number of record
    public int getRecordsCount()
    {
        String countQuery = "SELECT * FROM " + Constants.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        return count;

    }

}
