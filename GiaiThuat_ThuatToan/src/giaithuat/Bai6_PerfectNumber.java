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
public class Bai6_PerfectNumber {

    public static boolean isPerfect(int n) {
        if (n < 0) {
            return false;
        }
        return Math.sqrt(n) * Math.sqrt(n) == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        boolean perfect = isPerfect(n);
        System.out.println("Is Perfect Number ? " + perfect);
    }
}
