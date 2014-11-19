package com.flatironschool.codedemosqlite.Models;

import java.util.List;

/**
 * Created by altyus on 11/18/14.
 */
public class Person {
    private long mId;
    private String name;
    private int age;
    private String address;

    private List<Dog>dogs;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(int id, String name, int age, String address) {
        mId = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public long getId() {
        return mId;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
