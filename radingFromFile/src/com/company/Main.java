package com.company;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Main {

    public static void main(String[] args) {
	try{
	    File obj = new File("C:\\Users\\MAJOR R\\documents\\test.txt");
        Scanner obj2 = new Scanner(obj);
        String data = obj2.nextLine();
        while (obj2.hasNext()){
            System.out.println(data);
        }
    }
	catch (FileNotFoundException e){
        System.out.println("File not found!");

    }
    }
}
