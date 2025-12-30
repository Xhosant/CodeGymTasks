package com.codegym.task.task26.task2601;

/* 
Read online about the median of a sample

*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        // Implement the logic here
        Arrays.sort(array);
        int length = array.length;
        int offset = (int) Math.ceil(length/2.0)-1;
        double median = (array[offset]+array[length-1-offset])/2.0;

        Comparator<Integer> compareMedianDistance = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int p1 = (int) Math.abs(o1-median);
                int p2 = (int) Math.abs(o2-median);
                int priority = p1-p2;
                if (priority!=0)return priority;
                else return o1-o2;
            }
        };

        Arrays.sort(array, compareMedianDistance);

        return array;
    }

}
