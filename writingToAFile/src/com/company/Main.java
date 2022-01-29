package com.company;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
	try{
        PrintWriter obj = new PrintWriter("C:\\Users\\MAJOR R\\Documents\\myFile2.txt");
        obj.println("This is my First file in Java. I written it using the PrintWriter class.");
        obj.close();
    }catch(IOException e){
        System.out.println("An Error has occurred!");
        }
        System.out.println("Success!");
    }
}
