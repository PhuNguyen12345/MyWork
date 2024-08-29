/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Int_t0_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n >= -100 && n <= 100) {
            String s = Integer.toString(n);
            if ( s != null) {
                System.out.println("Good job");
            }
        }
        else {
            System.out.println("Wrong answer");
        }
    }
}
