package com.codegym.task.task22.task2202;

/* 
Find a substring

*/

public class Solution {
    public static void main(String[] args) throws StringTooShortException {
        System.out.println(getPartOfString("CodeGym is the best place to learn Java."));
    }

    public static String getPartOfString(String string) throws StringTooShortException {
        try {
            int firstIndex = string.indexOf(' ');

            int lastIndex = firstIndex;
            for (int i = 0; i < 3; i++) {
                lastIndex = string.indexOf(' ', lastIndex + 1);
                if (lastIndex<0) throw new Exception();
            }

            if (string.indexOf(' ', lastIndex + 1)>0) {
                lastIndex = string.indexOf(' ', lastIndex + 1);
                return string.substring(firstIndex + 1, lastIndex);
            } else return string.substring(firstIndex + 1);

        } catch (Exception e) {throw new StringTooShortException();}
    }

    public static class StringTooShortException extends RuntimeException {
    }
}
