/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaithuat;

/**
 *
 * @author ASUS
 */
public class RectangleArea {
    public static double rectangleArea(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] xs = {p1[0], p2[0] ,p3[0] ,p4[0]};
        int[] ys = {p1[1], p2[1], p3[1], p4[1]};
        
        int length = Math.abs(xs[0] - xs[1]);
        int width = Math.abs(ys[0] - ys[1]);
        
        return (length * width);
    }
    // so phan tu khac nhau trong mot array
    public static int distinct(int[] array) {
        int count = 0;
        for (int i = 0 ; i < array.length ;i++) {
            boolean isDistinct = true;
            for (int j = 0 ; j < i ; j++) {
                if (array[i] == array[j]) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct) {
                count++;
            }
        }
        return count;
    }
    
    public static boolean isRectangle(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] xs = {p1[0], p2[0], p3[0], p4[0]};
        int[] ys = {p1[1], p2[1], p3[1], p4[1]};
        
        return (distinct(xs) == 2 && distinct(ys) == 2 );
    }
}
