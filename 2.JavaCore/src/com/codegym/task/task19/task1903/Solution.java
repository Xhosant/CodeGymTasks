package com.codegym.task.task19.task1903;
import java.util.Arrays;

/* 
Adapting multiple interfaces

*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    static{
        countries.put("UA", "Ukraine");
        countries.put("US", "United States");
        countries.put("FR","France");
    }

    public static void main(String[] args) {
        IncomeDataAdapter a = new IncomeDataAdapter(new Example());
        String company = a.getCompanyName();
        String country = a.getCountryName();
        String name = a.getName();
        String phone = a.getPhoneNumber();
        String ab="potat";}



    public static class Example implements IncomeData{
        public String getCountryCode() { return "US";}
        public String getCompany() {
            return "CodeGym Ltd.";}
        public String getContactFirstName() {
            return "John";
        }   // For example: John
        public String getContactLastName(){
            return "Smith";
        }    // For example: Smith
        public int getCountryPhoneCode(){
            return 1;
        }      // For example: 1
        public int getPhoneNumber(){
            return 991234567;
        }

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;
        public IncomeDataAdapter(IncomeData incomeData){
            this.data=incomeData;
        }
        
        public String getCompanyName(){
            return data.getCompany();
            
        }
        public String getCountryName(){
            return countries.get(data.getCountryCode());
        }
        public String getName(){
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }
        public String getPhoneNumber(){
            return String.format("+%d(%2$s)%3$s-%4$s-%5$s", data.getCountryPhoneCode(),
                    String.format("%010d", data.getPhoneNumber()).substring(0, 3),
                    String.format("%010d", data.getPhoneNumber()).substring(3, 6),
                    String.format("%010d", data.getPhoneNumber()).substring(6, 8),
                    String.format("%010d", data.getPhoneNumber()).substring(8));
        }
    }


    public static interface IncomeData {
        String getCountryCode();        // For example: US

        String getCompany();            // For example: CodeGym Ltd.

        String getContactFirstName();   // For example: John

        String getContactLastName();    // For example: Smith

        int getCountryPhoneCode();      // For example: 1

        int getPhoneNumber();           // For example: 991234567
    }

    public static interface Customer {
        String getCompanyName();        // For example: CodeGym Ltd.

        String getCountryName();        // For example: United States
    }

    public static interface Contact {
        String getName();               // For example: Smith, John

        String getPhoneNumber();        // For example: +1(099)123-45-67
                                        // For example: +1(099)123-45-67
    }
}