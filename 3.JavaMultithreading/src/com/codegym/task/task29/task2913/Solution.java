package com.codegym.task.task29.task2913;

import java.util.Random;

/* 
Replace recursion

*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder out = new StringBuilder();
        out.append(a);
        int delta = b - a;
        delta = delta / Math.abs(delta);
        while (b != a) {
            a += delta;
            out.append(" " + a);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}