/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

import java.util.Random;

/**
 *
 * @author ASUS
 */
public class John_QuickSort {
    
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int medianOfThree(int arr[],int low, int high) {
        int mid = (low + high)/2;
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low]> arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);
        swap(arr, mid, high);
        return arr[high];
    }
    
    public static void quicksort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    public static void quickSort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        
        int pivotIndex = new Random().nextInt(high - low) + low;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        int leftPointer = partition(low, high, arr, pivot);
        
        quickSort(arr, low, leftPointer - 1);
        quickSort(arr, leftPointer + 1, high);
        
    }

    public static int partition(int low, int high, int[] arr, int pivot) {
        int leftPointer = low;
        int rightPointer = high;
        while (leftPointer < rightPointer) {
            
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer ) {
                leftPointer++;
            }
            
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
            
        }
        swap(arr, leftPointer, high);
        return leftPointer;
    }
    
    
    public static void print(int arr[]) {
        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr= new int[100];
        
        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        quicksort(arr);
        print(arr);
    }
}
