package com.codegym.task.task30.task3009;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Character.isDigit;

/* 
Palindrome?

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        // Expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        // Expected output: [6]
        System.out.println(getRadix("5321"));       // Expected output: []
        System.out.println(getRadix("1A"));         // Expected output: []
    }

    private static Set<Integer> getRadix(String number){
        Set<Integer> validSet = new HashSet<>();

        try{
            Integer.parseInt(number);
        } catch (NumberFormatException e) {return  validSet;}

        for (int i =2; i<37;i++){
            if (decimalToSystem(number, i)) validSet.add(i);
        }

        return validSet;
    }

    private static boolean decimalToSystem(String number, int base){

        List<Integer> nNum= new ArrayList<>();
        int value = Integer.parseInt(number);
        while (value>0){
            nNum.add(value%base);
            value/=base;
        }

        //List<Character> nStr = new ArrayList<>();
        //
        //for (int i = 0; i<nNum.size();i++){
        //    nStr.add((char) (int) nNum.get(i));
        //   //if (nNum.get(i) < 10) nStr.add(Integer.toString(nNum.get(i)));
        //   //else {
        //   //    nStr.add(Character.to)
        //   //}
        //}
        int bounds = nNum.size();
        for (int i = 0; i<bounds/2;i++){
            if (!nNum.get(i).equals(nNum.get(bounds-1-i))) return false;
        }
        return true;


    }

    private static boolean isPalindrome(String number){
        for (int i = 0; i<number.length()/2;i++){
            if (number.charAt(i)!=number.charAt(number.length()-1-i)) return false;
        }
        return true;
    }
}