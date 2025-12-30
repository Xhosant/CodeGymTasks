package com.codegym.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Factorial

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //write your code here
        if (n==0) return "1";
        if (n<0) return "0";
        BigInteger result = new BigInteger("1");
        for (int i = n; i>0; i--){
            result = result.multiply(new BigInteger(Integer.toString(i)));
        }

        return  result.toString();
    }
}
