package com.company;

/**
 * Use breakpoints to see the contents of each variable at each step.
 */
public class DataTypes {

    public static void main(String[] args) {

        /**
         * Byte Primitive type - twos complement integer - Size: 8 bits (Short is the same only Size: 16 bits)
         */
        byte maxByte = (byte)128; //Furthest bit set - two's complement. = -128
        maxByte = (byte)127; // Max value that can be represented. = 127

        byte hexValue = 0x11; // = 17
        hexValue = 0xF; // = 15
        hexValue = 0x7F; // Max value represented as Hex = - 127
        hexValue = (byte) 0x80; //2's Compliment: -128

        /**
         * Int Primitive type - twos complement integer - Size: 32 bits (long is same only Size: 64 bits)
         */
        int maxInt = 0x80000000; // Furthest bit set - two's complement = -2,147,483,648
        maxInt = 0x7FFFFFFF; // second most significant bit set - highest non negative int representing. = 2,147,483,647

        int character = 'a'; // returns ascii value of character (97)
        character = ' '; // (32)

        /**
         * Java Bitwise and Bit Shift Operators
         */

        //Bitwise OR -> |
        int one = 1;
        int zero = 0;
        int result = one ^ zero; // result is 1

        /*
            0111 1111 1111 1111 1111 1111 1111 1111
            1000 0000 0000 0000 0000 0000 0000 0000
            --------------------------------------- OR
            1111 1111 1111 1111 1111 1111 1111 1111 = 2,147,483,647 - (	-2,147,483,648) = -1
         */
        result = 0x7FFFFFFF | 0x80000000; // = -1

        //Bitwise AND -> &
        result = one & one; // 1 & 1 = 1

        //Bitwise XOR -> ^ (returns one if values are different)
        result = one ^ one;


        //Signed Left Shift -> <<
        int resultOfLeftShift = 8 << 1; //8 << 1 evaluates to 16 (In binary: 1000 -> 0001 0000)

        //Signed Right Shift -> >>
        int resultOfRightShift = 8 >> 1; //8 >> 1 evaluates to 4 (In binary: 1000 -> 0100)

    }
}
