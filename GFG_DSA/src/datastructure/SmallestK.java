/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class SmallestK {

    public static int Sort(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    /*public static void bubbleSort(int arr[]) {
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
    }*/
    // Using QuickSelect for efficient performance
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // hàm phân mảng (partition) 
    public static int partition(int[] arr, int left, int right) {
        //Choose a random pivot for improvin average performance (pivot : phần tử trục) 
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivot = arr[pivotIndex];

        //Swap the pivot to the end for partition 
        // Chuyen truc ve cuoi de thuc hanh phan hoach
        swap(arr, pivotIndex, right);
        // phân hoạch danh sách 
        // phần tử nhỏ hơn trục được đẩy lên phía trước 
        // phần tử lớn hơn hoặc bằng thì để ra phía sau 
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        // swap the pivot back to its correct position
        // đưa trục về đúng vị trí
        
        swap(arr, i, right);
        return i;
    }

    public static int findKthSmallest(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Invalid K value");
        }

        //QuickSelect
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int pivotIndex = partition(arr, left, right);
            if (pivotIndex == k - 1) {
                return arr[pivotIndex];
            }
            else if (pivotIndex < k - 1) {
                left = pivotIndex + 1;
            }
            else {
                right = pivotIndex - 1;
            }
        }
        throw new IllegalArgumentException("Invalid K value");
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 6};
        int k = findKthSmallest(arr, 3);
        System.out.println(k);

    }
}
