/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SelectionSort;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Utility util = new Utility();
        Scanner sc = new Scanner(System.in);
        int size = util.getIntRange("Enter number of elements : ", 1, Integer.MAX_VALUE);
        int arr[] = new int[size];
        util.Randomizer(arr);
        System.out.println("Unsorted array : ");
        util.Display(arr);
        sc.nextLine();
        System.out.println("Sorted array : ");
        util.SelectionSort(arr);
        util.Display(arr);
    }
}
