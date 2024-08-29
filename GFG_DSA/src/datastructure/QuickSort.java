/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

/**
 *
 * @author ASUS
 */
public class QuickSort {

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int medianOfThree(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        swap(arr, mid, high);
        return arr[high];
    }
    //medianOfThree: trung vị 3 phần tử 
    //vd : 8,2,4,9,3,6,7
    // [low, mid, high] = [8,9,7];
    // 8 > 7 -> swap(8,7) -> [7,9,8]
    // 9 > 8 -> swap(9,8) -> [7,8,9] -> median = trungvi = 8
    // de lay pivot la median, swap(mid, high) = [7,9,8] -> pivot = 8

    //this function takes last element as pivot
    //places the pivot element at its correct position
    //in sorted array, and places all smaller to left
    //of pivot and all greater elements to the right 
    public static int partition(int arr[], int low, int high) {
        //method to reposition pivot,smaller, and larger elements

        //choosing pivot 
        int pivot = medianOfThree(arr, low, high);

        //index of smaller element and indicates the right position
        // of pivot 
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            //if current element is smaller than pivot 
            if (arr[j] < pivot) {
                //increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    //two-list quicksort
    /*
    public static void quickSort(int[] arr, int low, int high) {
       if (low < high) {
           int pi = partition(arr, low, high);
           //pivot 
           
           quickSort(arr, low, (pi - 1));
           quickSort(arr, (pi + 1), high);
       }
    }*/

    //tail recursion 
    public static void quickSort(int[] arr, int low, int high) {
        while(low < high) {
            int pi = partition(arr, low, high);
            if (pi - low < high - pi) {
                quickSort(arr, low, pi - 1);
                low = pi + 1;
            }
            else {
                quickSort(arr, pi +1, high);
                high = pi - 1;
            }
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 3, 4, 9, 7};
        quickSort(arr, 0, 6);
        print(arr);
    }
}
