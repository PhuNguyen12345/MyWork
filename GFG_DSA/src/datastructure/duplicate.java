/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ASUS
 */
public class duplicate {

    public static ArrayList<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] count = new int[n];

       for (int i : nums) {
           if (i >= 0 && i < n) {
               if (++count[i] > 1) {
                   if (!list.contains(i)) {
                       list.add(i);
                   }
               }
           }
       }
       if (list.isEmpty()) {
           list.add(-1);
       }
        Collections.sort(list);
       return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 19, 20 ,1, 5, 8 };
        ArrayList<Integer> arrayList = findDuplicates(arr);
        for (int i : arrayList) {
            System.out.print(i + " ");
        }
    }
}
