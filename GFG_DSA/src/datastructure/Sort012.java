/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

/**
 *
 * @author ASUS
 */
public class Sort012 {
    public static void sort012(int a[], int n) {
        // code here
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        //count the occurence of 0,1,2 
        for (int i = 0 ; i < n; i++) {
            if (a[i] == 0) {
                c0 += 1;
            }
            else if (a[i] == 1) {
                c1 += 1;
            }
            else {
                c2 += 1;
            }
        }
        // place the element based on its occurence 
        int idx = 0;
        //place all the 0s
        for (int i = 0 ; i < c0 ;i++) {
            a[idx++] = 0;
        }
        
        //place all the 1s
        for (int i = 0 ; i < c1 ;i++) {
            a[idx++] = 1;
        }
        
        //place all the 2s
        for (int i = 0; i < c2 ;i++) {
            a[idx++] = 2;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {0,1,0,0,1,2,1};
        sort012(arr, 7);
        for (int i = 0 ; i < arr.length ;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
