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
public class Bai4_TamGiacCan {

    public static boolean isoceles(int xa, int ya, int xb, int yb, int xc, int yc) {
        double ab = Math.sqrt(Math.pow((xb - xa), 2) + Math.pow((yb - ya), 2));
        double bc = Math.sqrt(Math.pow((xc - xb), 2) + Math.pow((yc - yb), 2));
        double ac = Math.sqrt(Math.pow((xc - xa), 2) + Math.pow((yc - ya), 2));
        if ((ab != bc) && (bc != ac) && (ac != ab)) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xa, xb, xc;
        int ya, yb, yc;
        System.out.println("Enter A's coordinates :");
        xa = sc.nextInt();
        sc.nextLine();
        ya = sc.nextInt();
        System.out.println("Enter B's coordinates :");
        xb = sc.nextInt();
        sc.nextLine();
        yb = sc.nextInt();
        System.out.println("Enter C's coordinates :");
        xc = sc.nextInt();
        sc.nextLine();
        yc = sc.nextInt();

        boolean isIsoceles = isoceles(xa, ya, xb, yb, xc, yc);
        System.out.println("is Isoceles ? " + isIsoceles);
    }
}
