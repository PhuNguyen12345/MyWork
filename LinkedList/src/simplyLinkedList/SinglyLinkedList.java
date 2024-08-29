/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simplyLinkedList;


/**
 *
 * @author ASUS
 */
class Node {

    int data; //dulieu = info
    Node next; //link

    public Node(int data) {
        this.data = data;
        next = null;
    }

    @Override
    public String toString() {
        return data + " - "; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
// Node referemce ( a class that contains the node) -> Wrapper class for Node -> allow passed by reference >< passed by value

class refNode {

    Node node;

    public refNode(Node n) {
        node = n;
    }
}

class LinkedList {

    Node Head;
    Node Tail;

    // pred = predecessor node
    public Node search(int x, refNode pred) {
        Node curr = Head;
        pred.node = null;

        while (curr != null) {
            if (curr.data == x) {
                break;
            } else {
                pred.node = curr;
                curr = curr.next;
            }
        }
        return curr;
    }

    public LinkedList() {
        Head = Tail = null;
    }

    public boolean isEmpty() {
        return Head == null;
    }

    public void insertAfter(Node new_ele, Node pred) { //phương thức chèn một node tên là new_ele vào sau node cho trước là pred
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

    public void addToTail(int x) {
        Node new_ele = new Node(x);
        insertAfter(new_ele, Tail);
    }

    public void addToHead(int x) {
        Node new_ele = new Node(x);
        insertAfter(new_ele, null);
    }

    public void addBefore(int newVal, int x) {
        refNode pred = new refNode(null);
        Node pos = search(x, pred);

        if (pos == null) {
            return;
        } else {
            Node newNode = new Node(newVal);
            insertAfter(newNode, pred.node);
        }
    }

    public void removeAfter(Node pred) {
        Node temp;
        if (pred != null) {
            temp = pred.next;
            pred.next = temp.next;
        } else { //xoa nut dau (delete head) 
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

    public void deleteItem(int x) {
        refNode pred = new refNode(null);
        Node pos = search(x, pred);
        if (pos == null) {
            return;
        } else {
            removeAfter(pred.node);
        }
    }

    public void deleteAfter(int x) {
        refNode pred = new refNode(null);
        Node pos = search(x, pred);
        if (pos == null) {
            return;
        } else {
            removeAfter(pos);
        }
    }

    public void deleteTail() {
        if (isEmpty()) {
            return;
        }
        refNode pred = new refNode(null);
        Node pos = search(Tail.data, pred);
        if (pos == null) {
            return;
        }
        removeAfter(pred.node);
    }

    public void addAfter(int newVal, int x) {
        refNode pred = new refNode(null);
        Node pos = search(x, pred);

        if (pos == null) {
            return;
        } else {
            Node newNode = new Node(x);
            insertAfter(newNode, pos);
        }
    }

    @Override
    public String toString() {
        String s = "";
        Node t = Head;
        while (t != null) {
            s = s + t;
            t = t.next;
        }
        /*for (Node t = Head; t != null; t = t.next ) {
            s += t;
        }*/
        return s; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public LinkedList(int a[]) {
        Head = Tail = null;
        for (int x : a) {
            addToTail(x);
        }
    } //constructor

    public boolean isIncreaseSorted() {
        Node t = Head;
        while (t.next != null) {
            if (t.data > t.next.data) {
                return false;
            }
            t = t.next;
        }
        return true;
    } //sort method

    public void reverse() {
        // ngắt nút đầu ( 67 phải chỉ đến nul))
        // 67 33 21 64 49
        /*    t   sau 
        67   33    21   84 49
        ngắt đầu ra : 67 -> null
                      33 -> 67 -> null
                            t   sau 
                            21   84  49
                 21 -> 33 -> 67 -> null
                            t   sau 
                            84  49 
                 84 -> 21 -> 33 -> 67 -> null
                            t   sau 
                            49  null
                 49 -> 84 -> 21 -> 33 -> 67 -> null;
                                t    
                                null (dừng) 
         */
        Node t = Head.next; //chỉ đến nút thứ 2 trỏ đi
        Tail = Head.next = null; // ngăt chỉ giữ lại nút đầu

        while (t != null) {
            Node sau = t.next; //giữ lại sau của t
            insertAfter(t, null); //chèn nút t vào đầu
            t = sau; //tiếp tục với nút sau của t.. đến khi t là null
        }

    }

    public void insertionSort() {
        if (isEmpty()) {
            return;
        }
        Node curr = Head.next;
        Tail = Head.next = null;
        while (curr != null) {
            Node sau = curr.next;
            Node pos = Head;
            refNode pred = new refNode(null);
            // tìm nút đầu tiên từ trái sao cho : có dữ liệu lớn hơn curr.data 
            while (curr != null && pos.data < curr.data) {
               pred.node = pos;
               pos = pos.next;

              
            }
            // chen vao sau pred
            insertAfter(curr, pred.node);
            curr = sau; // tiep tuc voi node sau cua curr
        }

    }
}

 public class SinglyLinkedList {
       public static void main(String[] args) {
             // TODO code application logic here
            LinkedList L = new LinkedList();
            L.addToTail(6);
            L.addToTail(3);
            L.addToTail(4);
            L.addToTail(1);
            System.out.println(L); // 6 - 3 - 4 - 1

            L.addToTail(2);
            System.out.println(L);
            LinkedList L2 = new LinkedList(new int[]{1, 5, 3});

            L.insertionSort();
            System.out.println("insertionSort : " + L);
            L.deleteHead();
            System.out.println("After delete head :" + L);
            if (L.isIncreaseSorted()) {
                System.out.println("Sorted");
            } else {
                System.out.println("UnSorted");
            }

            refNode pred = new refNode(null);
            Node pos = L.search(4, pred);
            if (pos == null) {
                System.out.println("Not found");
            } else if (pred.node == null) {
                System.out.println("The node is : " + pos);
                System.out.println("Node is a Head.");
            } else {
                System.out.println("The node is : " + pos);
                System.out.println("The predecessor is : " + pred.node);
            }
       }
   }
