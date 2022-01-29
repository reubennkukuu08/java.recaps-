package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int num1,num2,result;
	String op;
        System.out.println("***SIMPLE CALCULATOR***");
        System.out.println();
        System.out.println("Input the first number: ");
        num1 = s.nextInt();
        System.out.println("Input operator: ");
        op = s.next();
        System.out.println("Input the second number: ");
        num2 = s.nextInt();

       switch (op){
           case "+" :
               result = num1 + num2;
               System.out.println("The result is: " + result);
               break;

           case "-" :
               result = num1 - num2;
               System.out.println("The result is: " + result);
               break;

           case "*" :
               result = num1 * num2;
               System.out.println("The result is: " + result);
               break;

           case "/" :
               result = num1 / num2;
               System.out.println("The result is: " + result);
               break;

           default:
               System.out.println("Invalid operator!");
       }
    }
}
