package com.flatironschool.codedemosqlite.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.flatironschool.codedemosqlite.Models.Person;

/**
 * Created by altyus on 11/18/14.
 */
public class PersonDataSource {
    private SQLiteDatabase mDatabase;

    public PersonDataSource(SQLiteDatabase database) {
       mDatabase = database;
    }

    //Create Person
    public long insertPerson(final Person person) {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.PERSON_COLUMN_NAME, person.getName());
        values.put(DBOpenHelper.PERSON_COLUMN_AGE, person.getAge());
        values.put(DBOpenHelper.PERSON_COLUMN_ADDRESS, person.getAddress());
        long id = mDatabase.insert(DBOpenHelper.TABLE_PERSON, null, values);
        person.setId(id);
        return id;
    }
}
