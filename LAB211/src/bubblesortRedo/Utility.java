/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bubblesortRedo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Utility {

    public int getIntInRange(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int result =0;
        do {
            try {
                System.out.println(msg);
                String input = sc.nextLine();
                if (checkInt(input) != -1 ) {
                    return checkInt(input);
                }
                result = Integer.parseInt(input);
                if (result > max || result < min) {
                    System.err.println("Invalid number. Must between "+min +" and "+max);
                    continue;
                }
                return result;
            } catch(Exception e) {
                System.err.println("Invalid number format. Try again");
            }
        } while(true);            
          
    } 

    public int[] Randomizer(int arr[]) {
        int size = arr.length;
        Random rd = new Random();
        for (int i = 0 ; i < size; i++) {
            arr[i] = rd.nextInt(10);
        }
        return arr;
    }

    public int checkInt(String input) {
        if (input.matches("\\d+[\\.][0]+")) {
            return Integer.parseInt(input.substring(0, input.indexOf(".")));
        }
        return -1;
    }

    public void bubbleSort(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public void display(int arr[]) {
        int size = arr.length;
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
    }
}
