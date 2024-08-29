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
public class StaticInitializer {
    
    public static int area(int B, int H) throws Exception {
        if (B < 0 || H < 0) {
            throw new Exception("Breadth and Heigh must be positive");
        }
        return B * H;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int area = 0;
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        try {
            area = area(a,b);
            System.out.println(area);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
