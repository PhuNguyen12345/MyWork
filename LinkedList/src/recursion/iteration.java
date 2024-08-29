/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion;

/**
 *
 * @author ASUS
 */
public class iteration {

    public static int fibonacci(int n) {
        int truoc = 0;
        int sau = 1;
        int tong = 0;
        for (int i = 2; i <= n; i++) {
            tong = truoc + sau;
            truoc = sau;
            sau = tong;
        }
        return tong;
    }

    public static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }
    
    public static int loopBinarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        
        while (low <= high) {
            int midPosition = low + (high - low)/2;
            int midNumber = a[midPosition];
            
            if (x == midNumber) {
                return midPosition;
            }
            
            if (x < midNumber) {
                high = midPosition - 1;
            }
            
            else {
                low = midPosition + 1;
            }
        }
        return -1;
    }
    
    
    public static int loopPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        int mid = low + (high - low)/2 ;
        
        for (int i = 0 ; i <= mid; i++) {
            if (s.charAt(i) != s.charAt(high - i)) {
                return 0;
            }
        }
        return 1;
    }
    
    public static int tailPalindrome(String s, int left, int right) {
        if (left >= right) {
            return 1;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return 0;
        }
        return tailPalindrome(s, left + 1, right - 1);
    }
    
    //Factorial using non-tail to tail recursion using acculator 
    public static int factorTail(int n, int ac) {
        if (n == 1) return ac;
        return factorTail(n, ac*n);
    }
    
    public static int reverseTail(int n, int ac) {
        if (n == 0) return ac;
        return reverseTail(n/10, ac*10 + n%10);
    }
    
    public static int sum_nonTail(int[] a, int n) {
        if (n == 0) return 0;
        return sum_nonTail(a, n - 1) + a[n-1];
    }
    
    public static int max(int arr[], int low, int high) {
        if (low == high) return arr[low];
        int mid = low + (high - low)/2;
        int m1 = max(arr, low, mid);
        int m2 = max(arr, mid + 1, high);
        if (m1 < m2) {
            return m2;
        }
        return m1;
        
    }
    
    
    

    public static void main(String[] args) {
        System.out.println("Fibonacci cua 5 :" + fibonacci(5));
        System.out.println("Factorial cua 6 : " +factorial(6));
        int[] arr= {1,3,5,7,10,12,13};
        int found = loopBinarySearch(arr, 13);
        System.out.println(""+found);
        System.out.println(""+loopPalindrome("abba"));
        String s = "abbc";
        System.out.println(""+tailPalindrome(s, 0, s.length() - 1));
        System.out.println(""+reverseTail(1972, 0));
        int a[] = {1,2,3,4,5,6};
        System.out.println(""+sum_nonTail(a, 5));
        int a2[] = {1,2,3,4,5,6,7};
        System.out.println(""+max(a2, 0, a2.length - 1));
    }

}
