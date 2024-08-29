/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BubbleSort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Utility {

    public int getIntRange(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        do {
            try {
                System.out.println(msg);
                String input = sc.nextLine();
                if (checkInt(input) != -1) return checkInt(input);
                result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.err.println("Invalid number. Must between "+min + " and " +max);
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.err.println("Invalid number format, try again !");
            }
        } while (true);

    }

    public int[] Randomizer(int size, int arr[]) {
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(10);
        }
        return arr;
    }
    // ham check int cho phep tach so thap phan de lay so nguyen 
    public int checkInt(String input) {
        if (input.matches("\\d+[\\.][0]+")) {
            // trong string thi "\\" ~ "\"
            return Integer.parseInt(input.substring(0, input.indexOf(".")));
        }
        return -1;
    }
    
    public void bubbleSort(int[] arr) {
        int size = arr.length;
        for (int i = 0 ; i < size - 1; i++) {
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
            }
            else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
    }
}
