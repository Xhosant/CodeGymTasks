package com.codegym.task.task22.task2212;

/* 
Phone number verification

*/

public class Solution {
    public static boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber==null) return false;
        if (phoneNumber.matches("^\\+.*")) //works
        {
            if (!phoneNumber.matches("^\\D*(\\d\\D*){12}$")) return false; //works
        }
        else if (!phoneNumber.matches("^\\D*(\\d\\D*){10}$")) return false; //works

        if (phoneNumber.contains("--")) return false; //works
        if (phoneNumber.matches(".*-.*-.*-.*")) return false; //works
        if (phoneNumber.matches(".*\\(.*")) { //works
            if (phoneNumber.matches(".*\\(.*\\(.*") || phoneNumber.matches(".*\\).*\\).*")) return false;
            if (!phoneNumber.matches(".*\\(...\\).*")) return false;
            if (phoneNumber.matches(".*-.*\\(.*")) return false;
        }
        if (!phoneNumber.matches(".*\\d$")) return false; //works
        if (phoneNumber.matches(".*[^0-9\\-()+].*")) return false; //works

        return true;
    }

    public static void main(String[] args) {

    }
}
