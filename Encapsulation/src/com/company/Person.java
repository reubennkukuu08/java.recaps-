package com.company;

public class Person {
    private String name; //restricted access

    public String getName() {
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

}
