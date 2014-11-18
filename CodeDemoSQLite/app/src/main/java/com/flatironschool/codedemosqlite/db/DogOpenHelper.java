package com.flatironschool.codedemosqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by altyus on 11/17/14.
 */
public class DogOpenHelper extends SQLiteOpenHelper {
    private Context mContext;

    public static final String TABLE_DOG = "DOG";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_AGE = "AGE";
    public static final String COLUMN_BREED = "BREED";

    private static final String DB_NAME = "dogs.db";
    private static final int DB_VERSION = 1;

    private static final String DB_CREATE =
            "CREATE TABLE " + TABLE_DOG + " (" +
                    COLUMN_NAME + " VARCHAR(255), "+
                    COLUMN_AGE + " INTEGER, "+
                    COLUMN_BREED + " VARCHAR(255) )";

    public DogOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
