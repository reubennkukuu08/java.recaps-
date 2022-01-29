package com.company;

public class Main {

    static int powerOfTwo(int n){
        if (n==0){
            return 1;
        }else {
            var power = 2*powerOfTwo(n-1);
            return power;
        }
    }
    public static void main(String[] args) {
	powerOfTwo(4);
    }
}
