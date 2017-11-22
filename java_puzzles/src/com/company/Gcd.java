package com.company;

/**
    Given 2 non negative integers m and n, find gcd(m, n)

    GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
    Both m and n fit in a 32 bit signed integer.

    Example

    m : 6
    n : 9

    GCD(m, n) : 3
    NOTE : DO NOT USE LIBRARY FUNCTIONS
 */

public class Gcd {
    public static void main(String[] args) {
        gcd(9,6);
    }
        public static int gcd(int a, int b) {
            if(a == b) {
                return a;
            } else if(a > b) {
                return calc(a, b);
            } else {
                return calc(b, a);
            }
        }

        public static int calc(int a, int b) {
            int val = b;
            while(val>=1) {
                if(a%val == 0 && b%val ==0) {
                    return val;
                }
                val--;
            }
            return a;
        }


}
