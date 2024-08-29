/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

/**
 *
 * @author ASUS
 */
public class binary_search {
    // recursion 
    public static int binarySearch(int[] arr, int n, int low, int high) {
        // low = 0; 
        //high = arr.length - 1;
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) /2;
         if (arr[mid] == n) {
            return mid;
        }
        
        if (n > arr[mid]) {
           return binarySearch(arr, n, mid + 1, high);
        }
        else {
          return  binarySearch(arr, n, low, mid - 1);
        }
        
     }
    
     public static int binarySearch(int[] arr, int n) {
         return binarySearch(arr, n, 0, arr.length - 1);
     }
    
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,8,9};
        int found = binarySearch(arr, 6, 0, arr.length - 1);
        int found1 = binarySearch(arr, 6);
        System.out.println(""+found1);
    }
}
