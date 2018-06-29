package com.lucrortek.datastructure;


public class ReverseLinkedListApp {
    static class Node {
        int data;
        Node next;

        public Node(int i) {
            data = i;
            next = null;

        }

        @Override
        public String toString() {
            return Integer.toString(data);
        }
    }


    static class LinkedList {
        private Node head;
        private Node tail;

        public LinkedList(Node headNode) {
            this.head = headNode;
            this.tail = null;
            head.next = tail;
        }

        public void add(Node newNode) {
            if (tail == null) {
                tail = newNode;
                head.next = tail;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }

        }

        public void reverse() {
            Node prev=null;
            Node cur=head;
            Node next=null;


            while (cur!= null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            head = prev;
        }


        public void print() {

            System.out.println("print list");

            Node curNode = head;
            while (curNode != null) {
                System.out.println(curNode);
                curNode=curNode.next;
            }

        }

    }

    public static void main(String[] args) {

        Node head = new Node(1);
        LinkedList linkedList = new LinkedList(head);

        Node newNode = new Node(2);
        linkedList.add(newNode);

        newNode = new Node(3);
        linkedList.add(newNode);

        linkedList.print();
        linkedList.reverse();

        linkedList.print();


    }


}
