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
public class Bai1_indayso {

    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input array's length :");
        n = Integer.parseInt(sc.next());
        sc.nextLine();
        int a[] = new int[n];
        System.out.println("Input array :");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Output: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
