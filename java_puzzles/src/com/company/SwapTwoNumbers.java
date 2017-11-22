package com.company;

/**
 * Swapping two numbers without using a temp variable.
 * Two ways of swapping numbers - two that can cause potential problems.
 */
public class SwapTwoNumbers {

    public static void main(String[] args) {

        /*
            Swap integers with addition - (Potential overflow problems)
         */
        int a = 10;
        int b = 20;

        a = a + b; // a = 30
        b = a - b; // b = 10
        a = a - b; // a = 20
        System.out.println("a: " + a + " b: " + b + " -> previously -> a: 10  b: 20");

        /*
            Swap integers with Bitwise Operator XOR - (Proper way to do it)
         */
        a = 2; // 0010
        b = 4; // 0100

        a = a ^ b; // 0110
        /*
            0110
            0100
            ----
            0010
         */
        b = a ^ b; // 0010
        /*
            0110
            0010
            ----
            0100
         */
        a = a ^ b; // 0100
        System.out.println("a: " + a + " b: " + b + " -> previously -> a: 2  b: 4");

    }

}
