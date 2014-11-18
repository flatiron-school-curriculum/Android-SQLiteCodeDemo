package com.flatironschool.codedemosqlite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flatironschool.codedemosqlite.Models.Dog;

/**
 * Created by altyus on 11/17/14.
 */
public class DogDataSource {
    private SQLiteDatabase mDatabase;
    private DBOpenHelper mDBOpenHelper;

    public DogDataSource(Context context) {
        mDBOpenHelper = new DBOpenHelper(context);
    }

    //open Database
    public void open(){
        mDatabase = mDBOpenHelper.getWritableDatabase();
    }

    //close Database
    public void close(){
        mDatabase.close();
    }

    //Create Dog
    public void insertDog(Dog dog){
        mDatabase.beginTransaction();

        try {
            ContentValues values = new ContentValues();
            values.put(DBOpenHelper.COLUMN_NAME, dog.getName());
            values.put(DBOpenHelper.COLUMN_AGE, dog.getAge());
            values.put(DBOpenHelper.COLUMN_BREED, dog.getBreed());
            mDatabase.insert(DBOpenHelper.TABLE_DOG, null, values);
            mDatabase.setTransactionSuccessful();
        }finally {
            mDatabase.endTransaction();
        }
    }

    //Get all dogs
    public Cursor selectAllDogs(){
        Cursor cursor = mDatabase.query(DBOpenHelper.TABLE_DOG,
                new String[]{
                        DBOpenHelper.COLUMN_ID,
                        DBOpenHelper.COLUMN_NAME,
                        DBOpenHelper.COLUMN_BREED,
                        DBOpenHelper.COLUMN_AGE},
                null, // Where clause
                null, //Where Params
                null, //GroupBy
                null, //Having
                null //OrderBy
                );

        return cursor;
    }
}
