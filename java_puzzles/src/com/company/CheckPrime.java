package com.company;

public class CheckPrime {

    public static void main(String[] args) {
        System.out.println(isPrime(23));
        System.out.println(isPrime(2));
        System.out.println(isPrime(1));
        System.out.println(isPrime(137));
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
