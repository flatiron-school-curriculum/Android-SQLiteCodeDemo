package com.flatironschool.codedemosqlite.db.UnitOfWork;

/**
 * Created by altyus on 11/18/14.
 */
public interface UnitOfWork {
    void commit();
    UnitOfWork startTransaction(Transaction transaction);
    public interface Transaction {
        void execute();
    }
}
