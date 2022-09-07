package com.upwards.uidemo.models;

public class Person {
    String name;
    String dob;
    int profileImage;

    public Person(String name, String dob, int profileImage) {
        this.name = name;
        this.dob = dob;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public int getProfileImage() {
        return profileImage;
    }
}
