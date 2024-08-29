/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

/**
 *
 * @author ASUS
 */
public class Reverse {
    public static String reverseWord(String str) {
        StringBuilder sb = new StringBuilder();
        char[] al = str.toCharArray();
        for (int i = al.length -1; i >= 0; i--) {
            sb.append(al[i]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s = "Me may beo";
        String str = reverseWord(s);
        System.out.println(str);
    }
}
