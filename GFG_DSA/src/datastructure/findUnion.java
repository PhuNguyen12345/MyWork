/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author ASUS
 */
public class findUnion {
   /* public static ArrayList<Integer> printUnion(int arr1[], int arr2[], int m, int n) {
        //basic way : Using TreeSet 
        TreeSet<Integer> set = new TreeSet<>();
        
        //remove duplicates from arr1 and arr2 
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            set.add(i);
        }
        
        //Loading set to array list
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : set) {
            list.add(i);
        }
        return list;
    }
    */
    // two-pointers
    
    public static int printUnion(int arr1[], int arr2[], int m, int n) {
        //basic way : Using TreeSet 
        TreeSet<Integer> set = new TreeSet<>();
        
        //remove duplicates from arr1 and arr2 
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            set.add(i);
        }
        
        //Loading set to array list
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : set) {
            list.add(i);
        }
        return list.size();
    }
    
    /*public static int printUnion(int[] arr1, int[] arr2, int m, int n) {
      int i = 0;
      int j = 0;
      while (i < m && j < n) {
          if (arr1[i] < arr2[j]) {
              System.out.print(arr1[i++] +" ");
          }
          else if (arr1[i] > arr2[j]) {
              System.out.print(arr2[j++]+" ");
          }
          else {
              System.out.print( arr2[j++] + " ");
              i++;
          }
      }
      while (i < m) 
            System.out.print(arr1[i++] + " ");
      while (j < n) {
          System.out.print(arr2[j++] + " ");
      }
      
      return 0;
    } */
    
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6};
        int arr2[] = {2,3,5,7};
        int m = arr1.length;
        int n = arr2.length;
       int size =  printUnion(arr1, arr2, m, n);
        System.out.println(size + "");
    }
}
