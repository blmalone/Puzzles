package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(numSetBits(11));
    }

    public static int numSetBits(long A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) != 0)
                count++;
            A >>= 1;
        }
        return count;
    }




}
