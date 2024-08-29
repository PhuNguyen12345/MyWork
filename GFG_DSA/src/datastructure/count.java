/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ASUS
 */
//List of 2 numbers having the sum = 0
public class count {
    //time-consuming yet effective
    /*
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int num : arr) {
            int complement = -num;
            if (seen.contains(complement)) {
                ArrayList<Integer> pair = new ArrayList<>(Arrays.asList(Math.min(num, complement), Math.max(num, complement)));
                if (!result.contains(pair)) {
                    result.add(pair);
                }
            }
            seen.add(num);
        }

        result.sort((a, b) -> a.get(0) - b.get(0));
        return result;
    }
    */
    
    //optimized 
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<ArrayList<Integer>> resultSet = new HashSet<>(); 

        for (int num : arr) {
            int complement = -num;
            if (seen.contains(complement)) {
                ArrayList<Integer> pair = new ArrayList<>(Arrays.asList(Math.min(num, complement), Math.max(num, complement)));
                //if (!result.contains(pair)) {
                //    result.add(pair);
                //}
                resultSet.add(pair);
            }
            seen.add(num);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(resultSet);
        result.sort((a, b) -> a.get(0) - b.get(0));
        return result;
    }

    // k = number of pair 
    /* public static int getPairsCount(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }*/ 
    
    

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, -1, -2, -3};
        ArrayList<ArrayList<Integer>> pairs = getPairs(arr);
        System.out.println(pairs);
    }
}
