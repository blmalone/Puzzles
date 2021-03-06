package com.company;

public class ReverseString {

    public static void main( String[] args ) {
        String name = "blaine";

        /*
            Using iteration
         */
        String res = "";
        for(int i = name.length() -1; i >= 0; i--) {
            res = res + name.charAt(i);
        }

        System.out.println("Name: " + name + " Reverse Name: " + res + " -> ITERATIVE");

        /*
            Using recursion
         */
        res = recursiveReverseString(name);
        System.out.println("Name: " + name + " Reverse Name: " + res + " -> RECURSIVE");
        System.out.println();

    }

    public static String recursiveReverseString(String str) {
        if (str.length() == 1) {
            return str;
        } else {
            return recursiveReverseString(str.substring(1)) + str.substring(0,1);
        }
    }
}
