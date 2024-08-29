/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

/**
 *
 * @author ASUS
 */
public class Rearrange {

    public static void rearrange(int[] arr, int n) {
        /*int j = 0;
        int temp;
        for (int i = 0 ; i < n;  i++) {
            if (arr[i] >= 0) {
                if (i != j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }*/
       //ok 
       
        int temp[] = new int[n];
        
        //traversal array and store positive element in temp
        
        int j = 0;
        for (int i = 0 ; i < n; i++) {
            if (arr[i] >= 0) {
                temp[j++] = arr[i];
            }
        }
        //if array contains all positive or all negative
        if (j == n || j == 0) {
            return;
        }
        
        //store negative elements in temp
        for (int i = 0 ; i < n; i++) {
            if (arr[i] < 0) {
                temp[j++] = arr[i];
            }
        }
        
        //copy contents of temp to arr
        for (int i = 0 ; i < n; i++) {
            arr[i] = temp[i];
        }
        
       //Using stack 
    }

    public static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {-1, 2, -3, -4, 4, -5, 5};
        int n = arr.length;
        rearrange(arr, n);
        print(arr, n);
    }
}
