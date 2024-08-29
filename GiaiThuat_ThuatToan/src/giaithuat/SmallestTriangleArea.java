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

/*
1. Nhập điểm vào : Lấy tất cả điểm
2. Kiểm tra bộ ba điểm : Sử dụng vòng lặp kiểm tra tát cả các bộ ba điểm có thể tạo thành
3. Tính diện tích tam giác : Area = 1/2* |x1*(y2 - y3) + x2*(y3-y1) + x3*(y1 -y2)|
4. Tìm diện tích nhỏ nhất : So sánh và cập nhật diện tích nhỏ nhất trong số các diện tích đã tính
 */
public class SmallestTriangleArea {
    // Hàm tính diện tích tam giác từ tọa độ 3 điểm.

    public static double triangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of points :");
        int n = sc.nextInt();

        if (n < 3) {
            System.out.println("At least 3 points are needed to create a triangle");
            return;
        }

        ArrayList<double[]> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter coordinates of point (" + (i + 1) + ")" + ":");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points.add(new double[]{x, y});
        }

        double minArea = Double.MAX_VALUE;
        boolean found = false;

        // Kiem tra cac bo 3 diem
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    double[] p1 = points.get(i);
                    double[] p2 = points.get(j);
                    double[] p3 = points.get(k);
                    double area = triangleArea(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]);

                    if (area > 0) {
                        minArea = Math.min(minArea, area);
                        found = true;
                    }
                }
            }
        }

        if (found) {
            System.out.println("Smallest area :" + minArea);
        } else {
            System.out.println("Triangle with smallest area not found!");
        }
    }

}
