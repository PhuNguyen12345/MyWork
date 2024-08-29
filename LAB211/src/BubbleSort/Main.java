/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BubbleSort;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Utility util = new Utility();
        int size = util.getIntRange("Enter number of elements", 1, Integer.MAX_VALUE);
        int arr[] = new int[size];
        util.Randomizer(size, arr);
        System.out.println("Unsorted array : ");
        util.display(arr);
        System.out.println("Sorted array : ");
        util.bubbleSort(arr);
        util.display(arr);
        
    }
}
