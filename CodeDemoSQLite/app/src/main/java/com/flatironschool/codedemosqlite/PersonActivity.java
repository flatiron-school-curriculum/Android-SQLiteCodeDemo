package com.flatironschool.codedemosqlite;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.flatironschool.codedemosqlite.Models.Dog;
import com.flatironschool.codedemosqlite.db.DogDataSource;
import com.flatironschool.codedemosqlite.db.DogOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class PersonActivity extends ActionBarActivity {

    private DogDataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        mDataSource = new DogDataSource(this);

    }

    @Override
    protected void onPause() {
        super.onPause();


        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mDataSource.open();

        mDataSource.insertDog(new Dog("Fido", 2, "Collie"));

        Cursor cursor = mDataSource.selectAllDogs();

        List<Dog> dogs = new ArrayList<Dog>();

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int nameIndex = cursor.getColumnIndex(DogOpenHelper.COLUMN_NAME);
            int ageIndex = cursor.getColumnIndex(DogOpenHelper.COLUMN_AGE);
            int breedIndex = cursor.getColumnIndex(DogOpenHelper.COLUMN_BREED);

            String name = cursor.getString(nameIndex);
            int age = cursor.getInt(ageIndex);
            String breed = cursor.getString(breedIndex);

            Dog dog = new Dog(name, age, breed);
            dogs.add(dog);

            cursor.moveToNext();
        }




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
