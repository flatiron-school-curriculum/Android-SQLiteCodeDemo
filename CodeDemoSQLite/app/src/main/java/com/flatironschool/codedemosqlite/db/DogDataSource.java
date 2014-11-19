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

    public DogDataSource(SQLiteDatabase database) {
        mDatabase = database;
    }

    //Create Dog
    public long insertDog(Dog dog){
            ContentValues values = new ContentValues();
            values.put(DBOpenHelper.DOG_COLUMN_NAME, dog.getName());
            values.put(DBOpenHelper.DOG_COLUMN_AGE, dog.getAge());
            values.put(DBOpenHelper.DOG_COLUMN_BREED, dog.getBreed());
            values.put(DBOpenHelper.DOG_COLUMN_PERSON_ID, dog.getOwnerId());

        return mDatabase.insert(DBOpenHelper.TABLE_DOG, null, values);

    }

    //Get all dogs
    public Cursor selectAllDogs(){
        Cursor cursor = mDatabase.query(DBOpenHelper.TABLE_DOG,
                new String[]{
                        DBOpenHelper.DOG_COLUMN_ID,
                        DBOpenHelper.DOG_COLUMN_NAME,
                        DBOpenHelper.DOG_COLUMN_BREED,
                        DBOpenHelper.DOG_COLUMN_AGE,
                        DBOpenHelper.DOG_COLUMN_PERSON_ID},
                null, // Where clause
                null, //Where Params
                null, //GroupBy
                null, //Having
                null  //OrderBy
        );

        return cursor;
    }
}
