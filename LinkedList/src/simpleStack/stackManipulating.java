/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpleStack;

import java.util.Stack;

/**
 *
 * @author ASUS
 */
public class stackManipulating {

    public static String changeBinary(int dec, int base) {
        String result = "";
        Stack<Integer> S = new Stack<>();
        // while dec is not 0 
        while (dec != 0) {
            int remainder = dec % base;
            S.push(remainder); //push into stack
            dec = dec / base; //keep the loop goes on
        }
        //char digits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while (!S.isEmpty()) {
            int n = S.pop();
            // result += digits[n];
            String sub = "";
            if (n < 10) {
                sub += n;
            } else {
                sub = ((char) n - 10 + 'A') + "";
            }
            result += sub;
        }
        return result;
    }

    // kiemm tra xem co phai la so hay khong
    public static boolean isOperand(String token) {
        if (token.matches("[0-9]+")) {
            return true;
        }
        return false;
    }

    public static double compute(String a, String b, String operator) {
        double val = 0;
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        switch (operator) {
            case "+":
                val = a1 + b1;
                break;
            case "-":
                val = a1 - b1;
                break;

            case "*":
                val = a1 * b1;
                break;

            case "/":
                val = a1 / b1;
                break;

            case "%":
                val = a1 % b1;
                break;
        }
        return val;
    }

    public static String Compute(String a, String b, String operator) {
        String value = "";
        double val = 0;
        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        switch (operator) {
            case "+":
                val = a1 + b1;
                break;
            case "-":
                val = a1 - b1;
                break;

            case "*":
                val = a1 * b1;
                break;

            case "/":
                val = a1 / b1;
                break;

            case "%":
                val = a1 % b1;
                break;
        }
        return value + val;
    }

    // evaluate a String based on post-fix 
    public static double Evaluate(String PE) {
        double value = 0;
        Stack<String> S = new Stack<>();
        // SCan each token in PE
        // Split PE to substring - tokens
        String[] tokens = PE.split(" ");
        for (String token : tokens) {
            System.out.println("" + token);
            if (isOperand(token)) {
                S.push(token); //neu la so thi push vao stack
            } else {
                // pop 2 operands from stack
                String a = S.pop();
                String b = S.pop();
                S.push(Compute(a, b, token));
                // 
            }
        }
        return Double.parseDouble(S.pop());
    }

    // dấu "(" thì push
    // operand (các số) thì pop
    // gặp dấu tính (operator) thì push
    // dấu ")" in ra đến khi gặp dấu "(" sau đó peek dấu "("
    /*public static void infixToPostfix(String infix) {
      String postfix = "";
      Stack<String> S = new Stack<>();
      String[] tokens = infix.split(" ");
      for (String token : tokens) {
          if (isOperand(token)) postfix += " " + token;
          else if (token.equals("(")) S.push(token);
          else if (token.equals(")")) {
              while (!S.peek().equals("(")) postfix = " " + S.pop();
              S.pop();
          } else {
              // neu token la operator O, thi (1) lay va in ra cac toan tu tren
              // dau stack chung nao do uu tien cua chung >= do uu tien cua t
              while (!S.isEmpty() && priority(token) <= priority(S.peek())) 
                  postfix = " " + S.pop();
              S.push(token);
          }
      }
        System.out.println("" + postfix);
    } */
    
    // dấu "(" thì push
    // operand (các số) thì pop
    // gặp dấu tính (operator) thì push
    // dấu ")" in ra đến khi gặp dấu "(" sau đó peek dấu "("
    // Vi du ta co mot ham infix : 
    // ( 1 + 5 ) - ( 3 - 2 ) * ( 8 / ( 4 - 1 ) ) - 2
    //--> Ham postfix cua no : 1 5 + 3 2 - 8 4 1 - / * - 2 - 
    // ta push dau "(" vao dau tien 
    // sau do so 1 va so 5 se duoc pop ra ngoai
    // khi gap dau ")" thi se lay va in ra den khi gap dau "(" 
    // sau do lay dau "(" nhung khong in
    // tiep theo la push dau "-" va dau "(" 
    // tiep tuc la pop 3 2 va push dau "-" vao khi gap dau ")"
    // tiep theo thuc hien nhu buoc truoc cho den khi gap dau "*
    // den dau "*" thi co the cho vao dau stack
    // tuy nhien gia su dau "*" thay bang dau "+", phep "/" phai duoc thuc hien truoc
    // vi vay, can mot bien the hien do uu tien ( priority) ( chi lay khi do uu tien >= do uu tien cua dau co trong stack ) 
    // do uu tien cua dau "(" va ")" se la nho nhat, do uu tien dau "*" va "/" la lon nhat
    public static void infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        String[] tokens = infix.split(" ");
        Stack<String> S = new Stack<>();
        for (String token : tokens) {
            if (isOperand(token)) {
                postfix.append(token).append(" ");
            }
            else if(token.equals("(")) {
                S.push(token);
            }
            else if (token.equals(")")) {
                while (!S.isEmpty() && !S.peek().equals("(")) {
                    postfix.append(S.pop()).append(" ");
                }
                if (!S.isEmpty()) S.pop(); // pop the "("
                
            }
            else{
                // (1) Lay va in ra cac toan tu tren dau stack sao cho 
                // do uu tien cua chung <= do uu tien cua t
                //(2) push token vao stack 
                while (!S.isEmpty() && priority(token) <= priority(S.peek())) { 
                   postfix.append(S.pop()).append(" ");
                }
                S.push(token);
            }
        }
        // pop all the remaining operators in the stack 
          while (!S.isEmpty()) {
              postfix.append(S.pop()).append(" ");
          }
          System.out.println(postfix.toString().trim());
    }

    // tinh toan do uu tien de thuc hien push operator
    public static int priority(String token) {
        int prior ;
        switch (token) {
            case "*":
            case "/":
                prior = 2;
                break;

            case "+":
            case "-":
                prior = 1;
                break;
            default:
                prior = 0;
                break;
        }
        return prior;
    }

    public static void main(String[] args) {
        System.out.println(changeBinary(233, 2));
        String PE = "12 23 1 * + 29 -";
        System.out.println(Evaluate(PE));
        infixToPostfix("( 1 + 5 ) - ( 3 - 2 ) * ( 8 / ( 4 - 1 ) ) - 2 ");
    }
}
