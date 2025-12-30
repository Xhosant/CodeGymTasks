package com.codegym.task.task22.task2210;

/* 
StringTokenizer

*/

import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] output = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            output[i]=st.nextToken();
            i++;
        }
        return output;
    }
}
