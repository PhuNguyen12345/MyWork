/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class tail_iteration {
    /*
    * There is only one recursive call at the very end of a method implementaion 
    * Lần gọi đệ quy cuối cùng của method được gọi là đuôi (tail) 
    - We can implement by a loop (khử) 
    - The tail recursion is commonly integrated at the end of the loop 
    
    * The recursive call is not at the very end of a method implementaion = non-tail
    ( * Lần gọi đệ quy nhưng không phải là cuối cùng của method = non-tail)
    Convert by : 
    - Pushed to a stack (stated after the recursion) in recursive calls. 
    So we can pop the parts from stack to process later. 
    - Accumulating (tích luỹ) data before the tail recursion call 
    
    */
    
    //From the reverse method : 
    public static void tailReverse(int n) {
        if (n == 0) return; //base 
        System.out.print(n % 10);
        tailReverse(n/10);
    }
    
    public static void loopReverse(int n) {
        while (n != 0) {
            System.out.print(n % 10);
            n = n / 10;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tailReverse(12345);
        sc.nextLine();
        loopReverse(123546);
    }
}
