package com.company;

public class Main {

    public static void main(String[] args) {
	SinglyLinkedList sLL = new SinglyLinkedList();
	sLL.createSinglyLikedList(5);
        System.out.println(sLL.head.value);
    sLL.insertInLinkedList(6,1);
        System.out.println(sLL.head.next.value);

    }
}
