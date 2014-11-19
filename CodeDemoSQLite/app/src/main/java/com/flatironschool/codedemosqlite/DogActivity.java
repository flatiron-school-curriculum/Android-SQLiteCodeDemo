package com.flatironschool.codedemosqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.flatironschool.codedemosqlite.Models.Dog;
import com.flatironschool.codedemosqlite.Models.Person;
import com.flatironschool.codedemosqlite.db.DBOpenHelper;
import com.flatironschool.codedemosqlite.db.DogDataSource;
import com.flatironschool.codedemosqlite.db.PersonDataSource;
import com.flatironschool.codedemosqlite.db.UnitOfWork.SQLiteUnitOfWork;
import com.flatironschool.codedemosqlite.db.UnitOfWork.UnitOfWork;

import java.util.ArrayList;
import java.util.List;


public class DogActivity extends ActionBarActivity {

    private PersonDataSource mPersonDataSource;
    private DogDataSource mDogDataSource;

    private SQLiteUnitOfWork mUnitOfWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);


    }

    @Override
    protected void onPause() {
        super.onPause();
        mUnitOfWork = null;
    }

    @Override
    protected void onResume() {
        super.onResume();

        Dog dog1 = new Dog("Fido", 2, "Border Collie");
        Dog dog2 = new Dog("Billy", 3, "Phoenix");
        Dog dog3 = new Dog("Brandy", 4, "Husky");

        final List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);


        final Person al = new Person("Al", 27, "11 Broadway, NY, NY");

        mUnitOfWork = new SQLiteUnitOfWork(new DBOpenHelper(this));


        mUnitOfWork.startTransaction(new UnitOfWork.Transaction() {
            @Override
            public void execute() {
                PersonDataSource personDataSource = new PersonDataSource(mUnitOfWork.getDatabase());
                DogDataSource dogDataSource = new DogDataSource(mUnitOfWork.getDatabase());
                personDataSource.insertPerson(al);

                for (Dog dog: dogs){
                    dog.setOwnerId(al.getId());
                    dogDataSource.insertDog(dog);
                }
            }
        }).commit();

//        mUnitOfWork.startTransaction(new UnitOfWork.Transaction() {
//            @Override
//            public void execute() {
//                PersonDataSource personDataSource = new PersonDataSource(mUnitOfWork.getDatabase());
//            }
//        }).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_person, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
