/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class SubarrayWithGivenSum {

    // function to find a continuous sub-array which adds up
    // to a given number
    public static ArrayList<Integer> subarraySum(int[] arr, int n, long sum) {
        // to store the result 
        /* ArrayList<Integer> res = new ArrayList<>();
        // Using a flag to indicate if the subarray is found 
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            // initialize the current sum
            int currentSum = arr[i];

            //Check if the single element is the sum 
            if (currentSum == sum) {
                res.add(i + 1);
                res.add(i + 1);
                flag = true;
                break;
            } else {
                //try all subarrays starting with 'i' 
                for (int j = i + 1; j < n; j++) {
                    currentSum += arr[j];
                    if (currentSum == sum) {
                        res.add(i + 1);
                        res.add(j + 1);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        if (flag) {
            return res;
        }
        res.add(-1);
        return res;
         */
 /*
       ArrayList<Integer> res = new ArrayList<>();
       boolean flag = false;
       //Using flag to indicate true sub arrays
       for (int i = 0 ; i < arr.length ;i++) {
           int currentSum = arr[i];
           
           //check if single element is sum
           if (currentSum == sum) {
               res.add(i+1);
               res.add(i+1);
               flag = true;
               break;
           }
           else {
               // try all other substrings
               for (int j = i + 1 ; j < n ;j++) {
                   currentSum += arr[j];
                   if (currentSum == sum) {
                       res.add(i+1);
                       res.add(j+1);
                       flag = true;
                       break;
                   }
               }
               if (flag) break;
           }
       }
       if (flag) return res;
       //If not, the res should return -1 indicating there's no sum 
       res.add(-1);
       return res;
         */ //not used due to complexity O(N2) 

        //Sliding windows 
        int last = 0;
        int start = 0;
        long currsum = 0;
        boolean flag = false;
        ArrayList<Integer> res = new ArrayList<>();

        //iterate over the array 
        for (int i = 0; i < n; i++) {
            //store the sum up to current element
            currsum += arr[i];

            //check if current sum is greater than or equal to given number
            if (currsum >= sum) {
                last = i;

                //start from starting index till current index 
                while (sum < currsum && start < last ) {
                    //subtract the element from left 
                    currsum -= arr[start];
                    ++start;
                }
                
                //if current sum becomes equal to given number 
                if (currsum == sum) {
                    res.add(start + 1);
                    res.add(last + 1);
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            res.add(-1);
        }
        return res;
    }

public static void main(String[] args) {
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 23;
        ArrayList<Integer> result = subarraySum(arr, n, sum);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
