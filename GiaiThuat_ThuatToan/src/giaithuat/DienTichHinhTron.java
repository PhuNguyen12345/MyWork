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
public class DienTichHinhTron {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double maxRadius = 0;
        System.out.println("Number of points :");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Points " + (i + 1) + ":");
            double x = Double.parseDouble(sc.nextLine());
            double y = Double.parseDouble(sc.nextLine());

            double radius = Math.round(Math.sqrt(x * x + y * y));
            if (radius > maxRadius) {
                maxRadius = radius;
            }

        }
        double area = Math.PI * maxRadius * maxRadius;
        System.out.println("Area of circle including all points and O (0;0) : " + area);
    }
}
