/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaithuat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class SmallestTriangle {

    //cong thuc tinh dien tich tam giac qua toa do (x,y)
    public static double Area(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of points :");
        int n = sc.nextInt();

        ArrayList<double[]> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter coordinates of points (" + (i + 1) + ") :");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points.add(new double[]{x, y});
        }

        double minArea = Double.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    double[] p1 = points.get(i);
                    double[] p2 = points.get(j);
                    double[] p3 = points.get(k);
                    double area = Area(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]);

                    if (area > 0) {
                        minArea = Math.min(area, minArea);
                        found = true;
                    }
                }
            }
        }

        if (found) {
            System.out.println("Smallest area : " + minArea);
        } else {
            System.out.println("Smallest area not found!");
        }
        sc.close();
    }
}
