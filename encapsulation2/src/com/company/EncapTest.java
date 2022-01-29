package com.company;

public class EncapTest {
    private String name;
    private String idNum;
    private int age;

    public  int getAge(){ return age; }
    public  String getName(){ return name; }
    public  String getIdNum(){
        return idNum;
    }

    public void setAge(int age){ this.age = age; }
    public void setName(String name){
        this.name = name;
    }
    public void setIdNum(String idNum){
        this.idNum = idNum;
    }
}
