/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

/**
 *
 * @author ASUS
 */
public class missingNumber {
    public static int missingInteger(int arr[], int n) {
        int sum = 0;
        for (int i = 0 ; i < n - 1; i++) {
            sum += arr[i];
        }
        
        int expectSum = (n * (n + 1)) /2;
        return expectSum - sum;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,5};
        int n = 4;
        System.out.println(missingInteger(arr, n));
    }
}
