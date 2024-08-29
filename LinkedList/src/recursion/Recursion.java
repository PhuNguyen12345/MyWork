/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion;

import java.io.IOException;

/**
 *
 * @author ASUS
 */
// Wiki: 
/*
- A recursive definition or inductive definition is one that defines something
in terms of itself(that is, recursively). 
- For it to work, the definition in any given case must be well-founded, avoiding
infinite regress
- Consists of 2 part : 
//base case (neo) : doesn't contain a reference to its own type
//inductive case (quy nap - truy ho) : a reference to its own type
 */
public class Recursion {

    public static int factor(int i) {
        System.out.println(i + "! =");
        if (i == 0) {
            return 1;
        }
        int f = factor(i - 1);
        System.out.println(f + " * " + i + " = " + (f * i));
        return (f * i);
    }

    /* public static int josephus(int n,int k) {
        if (n == 1) return 1;
        return (josephus(n-1, k) + k - 1)%n + 1;
    }
     */
    public static int josephus(int n, int k) {
        int i = 1, ans = 0;
        while (i <= n) {
            ans = (ans + k) % i;
            i++;
        }
        return ans + 1;
    }
    
    public static double addReciprocals(int n) {
        if (n == 1) return 1;
        return addReciprocals(n-1) + 1.0/n;
    }

    public static void reverseString() throws IOException {
        char c = (char) System.in.read();
        if (c != '\n') {
            reverseString();
            System.out.print(c + " ");
        }
    }

    public static void DecBin(int n) {
        if (n / 2 != 0) {
            DecBin(n / 2);
        }

        System.out.print("" + n % 2);
    }

    /*public static int combinator(int n, int k) {
        if (k == 0 || k == 1) {
            return 1;
        }
        return combinator(n-1, k) + combinator(n - 1, k - 1);
        
        // Công thức : C(n,k) = C(n-1,k) + C(n-1,k-1) 
        //Công thức khác : C(n,k) = n!/(k!*(n-k)!) 
    }
     */
    public static void HanoiTower(int n, char from, char to, char aux) {
        // n ; Number of discs
        // Let's set the color of disks from topmost to bottom : purple -> green -> blue -> red 
        // from : from rod
        //to : to rod
        // aux : auxillary rod (lie between from and to) 

        //We want to move 4 disks from A to C -> function HanoiTower(4,A,C,B) 
        //rules : Move 1 disk at a time + the bigger disk can't lie above the smaller disk 
        //Let's divide the job: 
        // Move 3 disks at topmost to B and the bottommost (red)  disk to C then swap back the 3 topmost disks back to C 
        //Or : HanoiTower(3,A,B,C) + Move the red disk to C + HanoiTower(3,B,C,A) 
        //To do that, we have to divide it into smaller jobs : 
        //To move 3 disks to B, we have to move the 2 topmost-disks to C, move the bottom (blue) disks to B then swap back 2 top disks to B 
        //Or : HanoiTower(2,A,C,B) + Move the blue disk to B + HanoiTower(2,C,B,A) 
        //Use the same logic : we have to swap one disk only, let's choose the topmost disk (purple) and move it to B, move green disk to C and swap purple back to B 
        //Or : HanoiTower(1,A,B,C) + Move the green disk to rod C + HanoiTower(1,B,C,A)
        //We can use the logic as : 
        //HanoiTower(n-1,from,aux,to) + HanoiTower(n-1,aux,to,from) 
        //Therefore we can have the recursion...
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to + "  ");
            return;
        } //base type : moving one disk - only one disk to move 
        HanoiTower(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to + " ");
        HanoiTower(n - 1, aux, to, from);
    }

    public static int calculateMoves(int n) {
        return (int) Math.pow(2, n) - 1;
    }

    public static int combinator(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }

        if (k > n - k) {
            k = n - k; //C(n,k) = C(n,n-k) 
        }

        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    public static int Fibo(int n) {
        if (n < 2) {
            return n;
        }
        return Fibo(n - 1) + Fibo(n - 2);
    }

    public static void main(String[] args) throws IOException {
        //System.out.println("" +factor(4));
        //reverseString();
        //System.out.println("" + josephus(5, 2)); //total : 5, first one killed : 2
        //DecBin(14);
        // int fibo = Fibo(5);
        //System.out.println(""+fibo);

        //int combinator = combinator(5, 1);
        //System.out.println("" + combinator);
        int n = 3;
        HanoiTower(n, 'a', 'c', 'b');
        System.out.println("Number of moves : "+calculateMoves(n));
        
        System.out.println("The sum of first 5 reciprocals : " +Math.round(addReciprocals(5)*100.0)/100.0);

    }

}
