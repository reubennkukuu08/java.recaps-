package com.company;
import java.io.File;

public class Main {

    public static void main(String[] args) {

	     File obj = new File("C:\\Users\\MAJOR R\\Documents\\myFile.pdf");
	     if (obj.delete()){
             System.out.println("Deleted the file: " + obj.getName());
         }else{
             System.out.println("Failed to delete the file.");
         }

    }
}
