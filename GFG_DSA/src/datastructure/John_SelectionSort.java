/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class John_SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    
    public static void selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            //shouldn't pass to the last element, nothing to swap
            int min = arr[i];
            int indexMin = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    indexMin = j;
                }
            }
            swap(arr, i, indexMin);
        }
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
