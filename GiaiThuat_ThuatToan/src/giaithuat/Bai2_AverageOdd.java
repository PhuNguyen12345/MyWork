/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaithuat;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Bai2_AverageOdd {

    public static double AverageOdd(int a[]) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                sum += a[i];
                count++;
            }
        }
        sum = sum / 3;
        double avr = Math.round(sum * 100.0) / 100.0;
        return avr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input length :");
        int n = sc.nextInt();
        sc.nextLine();
        int a[] = new int[n];
        System.out.println("Input array :");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        double avr = AverageOdd(a);
        System.out.println("Result :" + avr);
    }
}
