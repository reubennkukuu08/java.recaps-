package com.company;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please input the size of the array: ");
        int size = s.nextInt();
        int [] grades= new int[size];

        System.out.println("Please input the array elements: ");
        for (int i = 0; i<grades.length; i++){
            System.out.print(i + ": ");
            grades[i] = s.nextInt();
        }
        System.out.println(Arrays.toString(grades)); //---outside the loop

    }
}
