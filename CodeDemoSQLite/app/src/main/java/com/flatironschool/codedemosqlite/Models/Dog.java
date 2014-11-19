package com.flatironschool.codedemosqlite.Models;

/**
 * Created by altyus on 11/17/14.
 */
public class Dog {

    private long mId;
    private String mName;
    private int mAge;
    private String mBreed;

    private long mOwnerId;
    private Person mOwner;

    public Dog(String name, int age, String breed) {
        mName = name;
        mAge = age;
        mBreed = breed;
    }

    public Dog(String name, int age, String breed, long id) {
        mName = name;
        mAge = age;
        mBreed = breed;
        mId = id;
    }

    public Dog(String name, int age, String breed,long id, Person owner) {
        mId = id;
        mName = name;
        mAge = age;
        mBreed = breed;
        mOwner = owner;
    }

    public Dog(String name, int age, String breed,long id, long ownerId, Person owner) {
        mId = id;
        mName = name;
        mAge = age;
        mBreed = breed;
        mOwnerId = ownerId;
        mOwner = owner;
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public String getBreed() {
        return mBreed;
    }

    public long getId() {
        return mId;
    }

    public Person getOwner() {
        return mOwner;
    }

    public void setOwner(Person owner) {
        mOwner = owner;
    }

    public void setOwnerId(long ownerId) {
        mOwnerId = ownerId;
    }

    public long getOwnerId() {
        return mOwnerId;
    }
}
