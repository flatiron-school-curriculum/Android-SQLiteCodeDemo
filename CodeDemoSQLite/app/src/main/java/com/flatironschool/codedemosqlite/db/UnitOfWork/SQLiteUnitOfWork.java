package com.flatironschool.codedemosqlite.db.UnitOfWork;

import android.database.sqlite.SQLiteDatabase;

import com.flatironschool.codedemosqlite.db.DBOpenHelper;

/**
 * Created by altyus on 11/18/14.
 */
public class SQLiteUnitOfWork implements UnitOfWork {
    private DBOpenHelper mDBOpenHelper;
    private SQLiteDatabase mDatabase;

    public SQLiteUnitOfWork(DBOpenHelper DBOpenHelper) {
        mDBOpenHelper = DBOpenHelper;
        mDatabase = mDBOpenHelper.getWritableDatabase();
    }

    public SQLiteDatabase getDatabase() {
        return mDatabase;
    }

    @Override
    public void commit() {
        try {
            if (mDatabase.inTransaction()) {
                mDatabase.setTransactionSuccessful();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mDatabase.inTransaction()){
                mDatabase.endTransaction();
            }
            mDBOpenHelper.close();
        }
    }

    @Override
    public UnitOfWork startTransaction(Transaction transaction) {
        mDatabase.beginTransaction();
        try {
            transaction.execute();
        } catch (Exception e){
            mDatabase.endTransaction();
        }

        return this;
    }
}
