package com.company;

public class EncapTest {
    private String name;
    private String idNum;
    private int age;

    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public String getIdNum(){
        return idNum;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setIdNum(String newIdNum){
        this.idNum = newIdNum;
    }

}

