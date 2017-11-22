package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Example :
 * Input : [1 2 2 3 1]
 * Output : 3
 *
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new ArrayList<Integer>(Arrays.asList(1,2,2,3,1))));
    }

    public static int singleNumber(final List<Integer> a) {
        int res = 0;
        for(int i =0; i<a.size(); i++) {
            res = res ^ a.get(i);
        }
        return res;
    }
}
