package com.company;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the customer's Salary: ");
        int salary = scanner.nextInt();
        double newSal, rate = 0.05;
        newSal = salary + (rate*salary);
	try{
	    PrintWriter obj = new PrintWriter("C:\\Users\\MAJOR R\\Documents\\myFile3.txt");
	    obj.println("John Kamau, Ksh 10000, 500");
        obj.close();

        PrintWriter obj2 = new PrintWriter("C:\\Users\\MAJOR R\\Documents\\myFile3.txt");
        obj2.println("John Kamau" +", New Salary: " + newSal );
        obj2.close();

        File obj1 = new File("C:\\Users\\MAJOR R\\Documents\\myFile3.txt");
        Scanner s = new Scanner(obj1);
        String data = s.nextLine();
        System.out.println(data);


    }catch(IOException e){
        System.out.println("An error has occurred!");
    }

    }
}
