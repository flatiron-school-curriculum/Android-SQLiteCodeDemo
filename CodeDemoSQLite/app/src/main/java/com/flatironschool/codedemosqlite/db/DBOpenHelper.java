package com.flatironschool.codedemosqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by altyus on 11/17/14.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String TABLE_DOG = "DOG";
    public static final String DOG_COLUMN_ID = "_id";
    public static final String DOG_COLUMN_NAME = "NAME";
    public static final String DOG_COLUMN_AGE = "AGE";
    public static final String DOG_COLUMN_BREED = "BREED";
    public static final String DOG_COLUMN_PERSON_ID = "person_id";
    private static final String DB_NAME = "dogs.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_PERSON = "PERSON";
    public static final String PERSON_COLUMN_ID = "_id";
    public static final String PERSON_COLUMN_NAME = "NAME";
    public static final String PERSON_COLUMN_AGE = "AGE";
    public static final String PERSON_COLUMN_ADDRESS = "ADDRESS";

    private static final String DOG_DB_CREATE =
            "CREATE TABLE " + TABLE_DOG + " (" +
                    DOG_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    DOG_COLUMN_NAME + " TEXT, "+
                    DOG_COLUMN_AGE + " INTEGER, "+
                    DOG_COLUMN_BREED + " TEXT, "+
                    DOG_COLUMN_PERSON_ID + " INTEGER, "+
                    "FOREIGN KEY (" + DOG_COLUMN_PERSON_ID + ") REFERENCES "+ TABLE_PERSON + "("+ PERSON_COLUMN_ID + ") )";

    private static final String PERSON_DB_CREATE =
            "CREATE TABLE " + TABLE_PERSON + " (" +
                    PERSON_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    PERSON_COLUMN_NAME + " TEXT, "+
                    PERSON_COLUMN_AGE + " INTEGER, "+
                    PERSON_COLUMN_ADDRESS + " TEXT )";

    public DBOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA FOREIGN_KEYS=ON");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DOG_DB_CREATE);
        db.execSQL(PERSON_DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
