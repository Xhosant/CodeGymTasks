package com.codegym.task.task15.task1517;

/* 
Static modifiers and exceptions

*/

public class Solution {
    public static int A = 0;

    static{
        // Throw an exception here
        try {if (A==0) throw new Exception();}
        catch (Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
