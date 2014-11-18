package com.flatironschool.codedemosqlite.Models;

/**
 * Created by altyus on 11/18/14.
 */
public class Person {
    private int mId;
    private String name;
    private int age;
    private String address;

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

    public int getId() {
        return mId;
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
