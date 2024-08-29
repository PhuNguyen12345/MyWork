/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpleLinkedListRedo;

import simplyLinkedList.*;

/**
 *
 * @author ASUS
 */
// Linear DSA
class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + " -> ";
    }

}

class LinkedList {

    Node Head;
    Node Tail;

    public LinkedList() {
        Head = null;
        Tail = null;
    }

    public boolean isEmpty() {
        return (Head == null);
    }

    /*public void insertAfter(Node new_ele, Node pred) { //phương thức chèn một node tên là new_ele vào sau node cho trước là pred
        if (pred != null) {
            new_ele.next = pred.next;
            pred.next = new_ele;
        } else {
            new_ele.next = Head;
            Head = new_ele;
        }

        if (pred == Tail) {
            Tail = new_ele;
        }
    }*/
 /* public void insertAfter(Node new_ele, Node pred) {
        if (pred != null) {
           new_ele.next = pred.next;
           pred.next = new_ele;
        }
        
        else {
            new_ele.next = Head;
            Head = new_ele;
        }
        
        if (pred == Tail) {
            Tail = new_ele;
        }
    }*/
    public void insertAfter(Node new_ele, Node pred) {
        if (pred != null) {
            new_ele.next = pred.next;
            pred.next = new_ele;
        } else {
            new_ele.next = Head;
            Head = new_ele;
        }

        if (pred == Tail) {
            Tail = new_ele;
        }
    }

    //addFirst
    public void addToTail(int x) {
        Node new_ele = new Node(x);
        insertAfter(new_ele, Tail);
    }

    //addLast
    public void addToHead(int x) {
        Node new_ele = new Node(x);
        insertAfter(new_ele, null);
    }

    /* @Override
    public String toString() {
        String s = "";
        Node t = Head;
        while (t != null) {
            s = s + t;
            t = t.next;
        }
        return s;
    } */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node t = Head;
        while (t != null) {
            sb.append(t.data);
            if (t.next != null) {
                sb.append(" -> ");
            }
            t = t.next;
        }

        return sb.toString();
    }

    // getting the size of the linked list using number of nodes
    public int getSize() {
        int count = 0;
        Node curr = Head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public int[] toArray() {
        int size = getSize();
        int[] array = new int[size];

        Node curr = Head;
        int index = 0;

        while (curr != null) {
            array[index] = curr.data;
            curr = curr.next;
            index++;
        }
        return array;
    }

    public LinkedList(int[] a) {
        Head = Tail = null;
        for (int x : a) {
            addToTail(x);
        }
    }

    public boolean isIncreaseSorted() {
        Node curr = Head;
        while (curr != null) {
            if (curr.data > curr.next.data) {
                return false;
            }
        }
        return true;
    }
    // vd : 67 -> 33 -> 24-> 19 -> 17
    public void reverse() {
        Node t = Head.next; // t == 33
        Tail = Head.next = null; //khoa duoi (lock the tail) ( chi con 67 trong linkedlist)  

        while (t != null) {
            Node sau = t.next;
            insertAfter(t, null);
            t = sau;
        }
    }
    
    public Node search(int x, refNode PredPtr) {
        Node curr = Head;
        while (curr != null) {
            if (curr.data == x) {
                break;
            }
            else {
                PredPtr.node = curr;
                curr = curr.next;
            }
        }
        return curr;
    }
    
    public void addBefore(int newVal, int x) {
        refNode pred = new refNode(null);
        Node pos = search(x, pred);
        
        if (pos == null) {
            return;
        }
        else {
            Node newNode = new Node(newVal);
            insertAfter(newNode, pred.node);
        }
    }
    
    public void addAfter(int newVal, int x) {
        refNode pred = new refNode(null);
        Node pos = search(x, pred);
        
        if (pos == null) {
            return;
        }
        else {
            Node newNode = new Node(newVal);
            insertAfter(newNode, pos);
        }
    }
    // remove the node after the node pointed by Pred
    public void removeAfter(Node pred) {
        Node temp;
        if (pred != null) {
            temp = pred.next;
            if (temp != null) {
                pred.next = temp.next;
            }
        }
        else {
            temp = Head;
            Head = temp.next;
        }
        
        if (temp == Tail) {
            Tail = pred;
        } 
    }
    
    public void deleteHead() {
        removeAfter(null);
    }
    
    public void deleteTail() {
        if (isEmpty()) {
            return;
        }
        
        refNode pred = new refNode(null);
        Node pos = search(Tail.data, pred);
        if (pos == null) return;
        else {
            removeAfter(pred.node.next);
        }
    }
    
    public void deleteItem(int x) {
        if (isEmpty()) 
            return;
        
        refNode pred = new refNode(null);
        Node pos = search(x, pred);
        if (pos == null) {
            return;
        }
        else {
            removeAfter(pred.node);
        }
    }
    
    public void deleteAfterX (int x) {
        if (isEmpty()) {
            return;
        }
        
        refNode pred = new refNode(null);
        Node pos = search(x, pred);
        
        if (pos == null) {
            return;
        }
        else {
            removeAfter(pos);
        }
    }
    
  /* public void insertionSort() {
        
        if (isEmpty()) {
            return;
        }
        // Cô lập hoá node trong linkedList
        Node curr = Head.next;
        Tail = Head.next = null;
        
        while (curr != null) {
            Node then = curr.next;
            Node pos = Head;
            refNode pred = new refNode(null);
            while (curr != null && pos.data < curr.data) {
                pred.node = pos;
                pos = pos.next;
            }
            insertAfter(curr, pred.node);
            curr = then;
        }
       
    }*/ //xảy ra NullPointer khi giá trị head không phải lớn nhất 
    
    public void insertionSort() {
        if (isEmpty()) {
        return;
    }
    // gia su la mot linkedlist co gia tri la 4 - 3 - 1 - 2 -null
    // Initialize the sorted part with the first node
    Node sorted = Head; // sorted = 4
    Node curr = Head.next; //curr = 3
    sorted.next = null;  // Break the list, so sorted is a single-node list
    // sau buoc nay thi ta co 2 linked list : 
    // sorted : 4 -> null
    // remaining list (list con lai sau khi tach : 3 -> 1 -> 2 -> null
    while (curr != null) {
        // vong lap dau : curr = 3
        Node then = curr.next;
        // then = 1
        // If the current node should be the new head of the sorted list
        if (curr.data <= sorted.data)  { //luc nay se la 3 < 4
            curr.next = sorted; //curr.next = Head (head luc nay thuoc linkedlist ten sorted)\
            // sorted sau do tro thanh 3 -> 4 -> null
            sorted = curr; //Head = curr 
            // curr = Head.next = 1
            // remaining list : 1 -> 2 -> null
            // tiep tuc.....
        } else {
            // Otherwise, find the correct position to insert
            //truong hop nay xay ra khi curr = 2, tuc la sorted.data = 1
            // sorted list luc nay la 1 -> 3 -> 4 -> null
            // remaining list : 2 -> null
            Node pos = sorted;
            while (pos.next != null && pos.next.data < curr.data) {
                pos = pos.next;
            } //tuy nhien la vi curr < pos.next.data (pos la sorted, tuc la post.next.data = sorted.next = 3) 
            insertAfter(curr, pos); // insert so 2 after pos = 1 (pos la sorted) 
        }

        curr = then; // curr se day sang curr.next ( curr = curr.next) (den null thi se stop) 
    }

    // Update the head to the new sorted list
    Head = sorted;

    // Update the tail
    Node temp = Head;
    while (temp.next != null) {
        temp = temp.next;
    }
    Tail = temp;


    } //ok 
    
    
    public void insertionSortBeta() {
        if (isEmpty()) {
            return;
        }
        
        Node curr = Head.next;
        Tail = Head.next = null;
        while (curr != null) {
            Node pos = Head;
            refNode pred = new refNode(null);
            Node then = curr.next;
            if (curr != null && pos.data < curr.data) /*cai culin nay gay ra nullpointer khi pos == null  )*/ {
                pred.node = pos;
                pos = pos.next;
            }
            insertAfter(curr, pred.node);
            curr = then;
            
        }
    } //sai cmnr
} 
    
class refNode {
    Node node;
    public refNode(Node node) {
        this.node = node;
    }
}



public class singleLinkedList {

    public static void main(String[] args) {
        LinkedList L = new LinkedList(new int[]{3, 2, 1, 4, 5});
        System.out.println(L);
        refNode pred = new refNode(null);
        Node pos = L.search(5, pred);
        if (pos != null) {
            if (pred.node == null) System.out.println("Found at head");
            else System.out.println("The predecessor is : " +pred.node.data);
        }
        else {
            System.out.println("Not found !");
        }
        L.addBefore(6, 3);
        L.addAfter(9, 5);
        System.out.println(L);
         L.insertionSort(); 
        System.out.println("Sorted " +L);
        System.out.println(L);
        L.deleteItem(3);
        L.deleteTail();
        System.out.println(L);
    }
}
