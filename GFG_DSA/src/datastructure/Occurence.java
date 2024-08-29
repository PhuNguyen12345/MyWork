/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

/**
 *
 * @author ASUS
 */
public class Occurence {
    public static int findFrequency(int arr[], int x) {
        int count = 0;
        for (int i = 0 ; i < arr.length ;i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,2,2,2,4};
        int count = findFrequency(arr, 2);
        System.out.println(""+count);
    }
}
