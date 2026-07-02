package org.xpd.example;

public class Driver {
    String firstName;
    String lastName;
    int age;
    public Driver(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
