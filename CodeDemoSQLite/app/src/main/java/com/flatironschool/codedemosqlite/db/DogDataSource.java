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
    private DogOpenHelper mDogOpenHelper;
    private Context mContext;

    public DogDataSource(Context context) {
        mContext = context;
    }

    //open Database
    public void open(){
        mDatabase = mDogOpenHelper.getWritableDatabase();
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
            values.put(DogOpenHelper.COLUMN_NAME, dog.getName());
            values.put(DogOpenHelper.COLUMN_AGE, dog.getAge());
            values.put(DogOpenHelper.COLUMN_BREED, dog.getBreed());
            mDatabase.insert(DogOpenHelper.TABLE_DOG, null, values);
            mDatabase.setTransactionSuccessful();
        }finally {
            mDatabase.endTransaction();
        }
    }

    //Get all dogs
    public Cursor selectAllDogs(){
        Cursor cursor = mDatabase.query(DogOpenHelper.TABLE_DOG,
                new String[]{
                        DogOpenHelper.COLUMN_NAME,
                        DogOpenHelper.COLUMN_BREED,
                        DogOpenHelper.COLUMN_AGE},
                null, // Where clause
                null, //Where Params
                null, //GroupBy
                null, //Having
                null //OrderBy
                );

        return cursor;
    }
}
