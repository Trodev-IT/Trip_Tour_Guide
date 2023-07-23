package com.trodev.tourtripguide;

public class Constant {

    //db name
    public  static final String DB_NAME = "MY_RECORDS_DB";
    public static final int DB_VERSION  =  1 ;
    public static final String TABLE_NAME = "MY_RECORDS_TABLE";
    public static final String C_ID = "ID";
    public static final String C_NAME = "NAME"; // place name
    public static final String C_IMAGE = "IMAGE"; // ticket image
    public static final String C_BIO= "BIO"; //journey place bio
    public static final String C_PHONE = "PHONE"; //manager number
    public static final String C_DATE = "DATE"; // journey date
    public static final String C_TICKET = "TICKET"; //ticket number

    public static final String C_ADDED_TIMESTAMP = "ADDED_TIME_STAMP"; // added time
    public static final String C_UPDATE_TIMESTAMP = "UPDATE_TIME_STAMP"; // update time

    // create table query

    public static final String CREATE_TABLE = "CREATE TABLE  " + TABLE_NAME + "("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + C_NAME + " TEXT,"
            + C_IMAGE + " TEXT,"
            + C_BIO + " TEXT,"
            + C_PHONE + " TEXT,"
            + C_DATE + " TEXT,"
            + C_TICKET + " TEXT,"
            + C_ADDED_TIMESTAMP + " TEXT,"
            + C_UPDATE_TIMESTAMP + " TEXT"
            + ")" ;

}
