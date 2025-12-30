package com.codegym.task.task22.task2203;

/* 
Between tabs

*/

public class Solution {
    public static String getPartOfString(String string) throws StringTooShortException {
        try {
            int startIndex = string.indexOf('\t');
            int lastIndex = string.indexOf('\t', startIndex+1);
            if (lastIndex <0) throw new Exception();

            return string.substring(startIndex+1, lastIndex);
        } catch (Exception e) {
            throw new StringTooShortException();
        }

    }

    public static class StringTooShortException extends Exception {
    }

    public static void main(String[] args) throws StringTooShortException {
        System.out.println(getPartOfString("\tCodeGym is the best place \tto learn Java\t."));
    }
}
