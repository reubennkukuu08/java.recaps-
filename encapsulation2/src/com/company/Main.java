package com.company;

public class Main {

    public static void main(String[] args) {
	EncapTest encap = new EncapTest();
	encap.setAge(21);
	encap.setName("Nkukuu");
	encap.setIdNum("R38625254");

        System.out.println("Name: " + encap.getName() +" Age: " + encap.getAge() +" Id Number: " + encap.getIdNum());
    }
}
