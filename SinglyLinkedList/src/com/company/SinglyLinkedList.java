package com.company;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLikedList(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;

        return head;
    }

    //insert method singlyLinkedList
    public void insertInLinkedList(int nodeValue, int location){
        Node node = new Node();
        node.value = nodeValue;

        if (head == null){
            createSinglyLikedList(nodeValue);
            return;
        }else if (location == 0){
            node.next = head;
            head = node;
        }else if (location >= size){
            node.next = null;
            tail.next = node;
            tail = node;
        }else{
            Node currentNode = head;
            int index = 0;
            while (index < location-1){
                currentNode = currentNode.next;
                index++;
            }
            Node nextNode = currentNode.next;
            currentNode.next =  node;
            node.next = nextNode;
        }
        size++;
    }
}
