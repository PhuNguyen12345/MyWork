/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class HackerRank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (sc.hasNext()) {
            System.out.println( i + " " +sc.nextLine());
            i++;
        }
        sc.close();
    }
    
}
