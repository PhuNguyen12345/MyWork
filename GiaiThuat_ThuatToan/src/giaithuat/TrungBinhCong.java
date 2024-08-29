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
public class TrungBinhCong {

    public static double tbc(int a[]) {
        int b = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            b += a[i];
            count++;
        }
        double tbc = (double) b / count;
        return tbc;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array's length : ");
        int n = sc.nextInt();
        sc.nextLine();
        int a[] = new int[n];
        System.out.println("Input array : ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        double tbc = tbc(a);
        System.out.println("Average :" + tbc);
    }
}
