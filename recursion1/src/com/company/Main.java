package com.company;

public class Main {
    static void firstMethod(){
        secondMethod();
        System.out.println("I am the first Method");
    }
    static void secondMethod(){
        thirdMethod();
        System.out.println("I am the second Method");
    }
    static void thirdMethod(){
        fourthMethod();
        System.out.println("I am the third Method");
    }
    static void fourthMethod(){
    System.out.println("I am the fourth Method");
    }
    public static void main(String[] args) {
	firstMethod();
    }
}
