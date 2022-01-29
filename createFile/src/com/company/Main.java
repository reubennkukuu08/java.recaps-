package com.company;
import java.io.File;
import java.io.IOException;
public class Main {

    public static void main(String[] args) {
       try{
           File obj = new File("C:\\Users\\MAJOR R\\Documents\\myFile.pdf");
           if (obj.createNewFile()){
               System.out.println("File created. " + obj.getName());
           }else{
               System.out.println("File already exist.");
           }
       } catch (IOException e){
           System.out.println("An error has occurred");
       }

    }
}
