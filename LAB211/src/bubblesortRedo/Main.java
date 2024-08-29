/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bubblesortRedo;

import java.util.Scanner;


/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Utility util = new Utility();
        int size = util.getIntInRange("Enter number of elements", 1, Integer.MAX_VALUE);
        int arr[] = new int[size];
        util.Randomizer(arr);
        System.out.println("Unsorted Array : ");
        util.display(arr);
        sc.nextLine();
        System.out.println("Sorted array : ");
        util.bubbleSort(arr);
        util.display(arr);
        
    }
}
