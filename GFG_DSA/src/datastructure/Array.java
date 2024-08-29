/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Array {

    public static boolean searchEle(List<Integer> arr, int x) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == x) {
                return true;
            }
        }
        return false;
    }

    public static void insertEle(List<Integer> arr, int y, int pos) {
        int n = arr.size();
        arr.add(0);
        

    }
    
    public static int findEle(List<Integer> arr, int x) {
        for (int i = 0; i < arr.size();i++) {
            if (arr.get(i) == x) {
                return i;
            }
        }
        return -1;
    }
    
    public static void deleteEle(List<Integer> arr, int z) {
       int pos = findEle(arr, z);
       for (int i = pos; i < arr.size() - 1 ; i++) {
           arr.set(i, arr.get(i+1));
       }
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        boolean found = searchEle(arr, 1);
        System.out.println("" + found);
        insertEle(arr, 6, 1);
        System.out.println(arr.toString());
    }
}
