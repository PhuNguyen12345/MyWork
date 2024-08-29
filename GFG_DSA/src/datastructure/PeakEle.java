/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class PeakEle {

    public static void Output(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*   public static void bubbleSort(int arr[]) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /*public static int peakElement(int[]arr, int n) {
       bubbleSort(arr);
       System.out.println("Peak Element :");
       return arr[arr.length - 1];
   }*/
    // peakElement = element that have value bigger than its neighbors
    public static int peakElement(int[] arr, int n) {
        if (n == 1) {
            return 0;
        }
        if (arr[0] >= arr[1]) {
            return 0;
        }
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                return i;
            }
        }
        return 0;

        // Simple implementation
    }

    public static int findPeakUtil(int arr[], int low, int high, int n) {
        // index of middle elements
        int mid = low + (high - low) /2;
        
        //Compare middle element with its neighbors
        if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n-1 || arr[mid + 1] <= arr[mid])) {
            return mid;
        }
        // if middle element is not peak
        // and its left meighbor
        // greater than it, then left half
        // must have a peak element 
        else if (mid > 0 && arr[mid - 1] > arr[mid]) 
            return findPeakUtil(arr, low, (mid - 1), n);
        
        // if middle element is not peak
        // and its right neighbor
        // greater than it, then right half,
        // must have a peak element
        else 
            return findPeakUtil(arr, (mid+1), high, n);
    }
    
    //a wrapper class over recursive function
    public static int findPeak(int arr[], int n) {
        return findPeakUtil(arr, 0, n - 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {1, 3, 2, 6, 4, 5, 7};
        int peak = findPeak(arr, 7);
        System.out.println("" + peak);
        // output must be 3 or 6

    }
}
