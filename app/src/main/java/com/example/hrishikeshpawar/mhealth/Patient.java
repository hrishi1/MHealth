package com.example.hrishikeshpawar.mhealth;

/**
 * Created by Hrishikesh Pawar on 22-03-2018.
 */

public class Patient {

    public String name, address, gender, photoUrl, contact;
    int age;


    public Patient(String name, String address, String gender, int age, String contact, String photoUrl)
    {
        this.name=name;
        this.address=address;
        this.gender=gender;
        this.age=age;
        this.contact=contact;
        this.photoUrl=photoUrl;
    }
}