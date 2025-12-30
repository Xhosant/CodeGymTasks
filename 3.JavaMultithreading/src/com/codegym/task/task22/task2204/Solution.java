package com.codegym.task.task22.task2204;

import java.util.Locale;

/* 
String formatting

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(Locale.ENGLISH, getStringFormat(), 20.0 / 7.0, 10.0 / 3.0));
        // The output should be
        // 20 / 7 = 2.86
        // Exp = 3.33e+00
    }

    public static String getStringFormat() {
        return "20 / 7 = %.2f%nExp = %.2e";
    }
}
