/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stackvsqueue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
class node {

    int data;
    node next;

    public node(int x) {
        data = x;
    }
}

class Stack {

    node dau;

    public Stack() {
        dau = null;
    }

    boolean isEmpty() {
        return dau == null;
    }

    void push(int x) {
        node t = new node(x);
        t.next = dau;
        dau = t;
    }

    int pop() {
        int x = dau.data;
        dau = dau.next;
        return x;
    }

    int top() {
        return dau.data;
    }

    /*void traverse() throws Exception {
        node result = dau;
        while (!isEmpty()) {
            System.out.print("stack : " + result.data + " -> ");
            result = result.next;
        }
        if (isEmpty()) {
            throw new Exception("Empty stack");
        }
    }*/
    void traverse() {
        for (node i = dau; i != null; i = i.next) {
            System.out.println(" -> " + i.data);
        }
    }

    void clear() {
        dau = null;
    }

}

class Queue {

    node dau;
    node duoi;

    public Queue() {
        dau = null;
    }

    boolean isEmpty() {
        return dau == null;
    }

    int deque() {
        int x = dau.data;
        dau = dau.next;
        return x;
    }

    void enqueue(int x) {
        node t = new node(x);
        t.next = null;
        if (isEmpty()) {
            dau = t;
        } else {
            duoi.next = t;
        }
        duoi = t;
    }

    void traverse() {
        for (node i = dau; i != null; i = i.next) {
            System.out.print(" " + i.data);
        }
    }
}

class MyQueue {

    ArrayList<Integer> arr;

    public MyQueue() {
        arr = new ArrayList();
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public void enQueue(int x) {
        arr.add(x);
    }

    public int deQueue() {
        return arr.remove(0);
    }

    @Override
    public String toString() {
        return arr.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}

class cirArrQueue {

    int[] arr;
    int Head, Tail;
    int numEle;
    int ind;

    public cirArrQueue(int size) {
        arr = new int[size]; //size = 8 -> index = 0,1,2,3,..,8

    }

    public void enQueue(int x) {
        if (isFull()) {
            System.out.println("The queue is Full. ");
            return;
        }
        // 
        arr[Tail] = x; 
        Tail = (Tail + 1) % arr.length; //enqueue vao sau size - 1
        //arr[Tail] = x; sai vi tri, khien cho gia tri tail cuoi mat va gia tri Head bi chen so 0
        //vi du : size = 8, int = 0 -> 7
        // Sau khi vi tri so 7 da co san thi phai enqueue vao vi tri 0
        // (Tail + 1 ) % length = ( 7 + 1 ) / 8= 0 --> Tail chuyen ve 0 va enqueue vao 0

        numEle++;
    }

    public void enQueue(int[] x) {

        for (int a : x) {
            if (isFull()) {
                System.out.println("The queue is Full");
                return;
            }
            arr[Tail] = a;
            Tail = (Tail + 1) % arr.length;
            numEle++;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The queue is Empty. ");
            return Integer.MAX_VALUE; //random
        }
        int x = arr[Head];
        Head = (Head++) % arr.length;
        numEle--;
        if (numEle == 0) {
            Head = 0;
            Tail = 1;
        }
        return x;
    }

    public void reset() {
        Head = 0;
        Tail = 1;
        numEle = 0; //Reset the number of Ele
       // for (int i = 0 ; i < arr.length ;i++) {
         //   arr[i] = 0;
            //reset all value
        //}
    }

    @Override
    public String toString() {
        String result = Head + " - " + Tail + " - " + numEle + " : ";
        for (int c = 1, ind = Head; c <= numEle; c++, ind = (ind + 1) % arr.length) {
            result += arr[ind] + " - ";

        }
        return result; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public boolean isFull() {
        return (numEle == arr.length);
    }

    public boolean isEmpty() {
        return (numEle == 0);
    }
}

public class StackVsQueue {

    public static void main(String[] args) throws Exception {
        /* Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(5);
        if (s.isEmpty()) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("Popping !!");
            while (!s.isEmpty()) {
                System.out.print(s.pop());
            }
        }
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Nhap vao so can doi : ");
        int n = sc.nextInt();
        Stack t = new Stack();
        while (n > 0) {
            t.push(n % 2);
            n = n / 2;
        }
        while (!t.isEmpty()) {
            System.out.print(t.pop());
        }*/
 /* Scanner sc = new Scanner(System.in);
       Queue q = new Queue();
       for (int i = 0 ; i < 100 ;i++) {
           q.enqueue(i+1);
       }
         while (!q.isEmpty()) {
           System.out.print(" -> " +q.deque());
       }*/

 /*  Scanner sc = new Scanner(System.in);
        System.out.println("Input a read number less than 1 in decimal to binary : ");
        double d = sc.nextDouble();
        Queue Q = new Queue();
        while (d != 0) {
            d *= 2;
            int r = (int) d;
            Q.enqueue(r);
            d -= r;
        }
        while (!Q.isEmpty()) {
            System.out.println(Q.deque());
        } */
 /*MyQueue mq = new MyQueue();
        mq.enQueue(12);
        mq.enQueue(3);
        mq.enQueue(19);
        mq.deQueue();
        System.out.println(mq);*/
        cirArrQueue cq = new cirArrQueue(8);
        cq.enQueue(12);
        cq.enQueue(13);
        cq.enQueue(14);
        cq.enQueue(new int[]{1, 2, 3, 4});
        cq.reset();
        System.out.println(cq);
    }
}
