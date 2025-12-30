package com.codegym.task.task30.task3002;

/* 
Mastering the methods of the Integer class

*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); // 22
        System.out.println(convertToDecimalSystem("012"));  // 10
        System.out.println(convertToDecimalSystem("0b10")); // 2
        System.out.println(convertToDecimalSystem("62"));   // 62
    }

    public static String convertToDecimalSystem(String s) {
        //write your code here
        if (s.charAt(0)!='0') return s;
        int base = 0;
        if (s.charAt(1)=='b'){
            base=2;
            s=s.substring(2);
        } else if (s.charAt(1)=='x'){
            base=16;
            s=s.substring(2);
        } else{
            base=8;
            s=s.substring(1);
        }
       return Integer.toString(Integer.parseInt(s, base));


    }
}
