package com.example.lecturadeficherosyfiltradosstream;

public class Persona {
    private String name;
    private String city;
    private int age;

    public Persona(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        if(name == ""){
            name = "NoName";
        }
        /*// This function doesnt works.
        if(age == Integer.parseInt("")){
            age = 0;
        }
         */

        return
                "Name: " + name +
                ". City: " + city +
                ". Age: " + age;
    }
}
