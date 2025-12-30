package com.codegym.task.task19.task1919;

/* 
Calculating salaries

*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //StringBuilder fileBuilder = new StringBuilder();

        TreeMap<String, Double> sal = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()) {
                String in = reader.readLine();
                sal.merge(in.split(" ")[0], Double.parseDouble(in.split(" ")[1]), Double::sum);
                /*if (sal.containsKey(in.split(" ")[0])){

                }
                else sal.put(in.split(" ")[0], Double.parseDouble(in.split(" ")[1]));*/
            }
        }
        for (String s: sal.keySet()) {
            System.out.println(s + " " + sal.get(s));
        }
    }
}
