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
public class John_BinarySearch {
    public static int binarySearch(int[] numbers, int numberToFind) {
        int low = 0;
        int high = numbers.length - 1;
        
        while (low <= high) {
            int midPosition = (low + high)/2;
            int midNumber = numbers[midPosition];
            
            if (numberToFind == midNumber) {
                return midPosition;
            }
            
            if (numberToFind < midNumber) {
                high = midPosition - 1; 
            }
            else {
                low = midPosition + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] ints = {1,2,4,5,7,9,11};
        int found = binarySearch(ints, 11);
        System.out.println(""+found);
        System.out.println(""+Arrays.binarySearch(ints, 11));
    }
}
