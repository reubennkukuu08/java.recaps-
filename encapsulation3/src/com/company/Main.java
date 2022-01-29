package com.company;

public class Main {

    public static void main(String[] args) {
	EncapTest obj = new EncapTest();
	obj.setAge(20);
	obj.setName("Reuben");
	obj.setIdNum("QWER5678");

        System.out.println("Name: " + obj.getName());
		System.out.println(" Age: " + obj.getAge());
		System.out.println( " ID Number: " + obj.getIdNum());
    }
}
