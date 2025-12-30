package com.codegym.task.task19.task1920;

/* 
The richest

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

            //StringBuilder fileBuilder = new StringBuilder();

            TreeMap<String, Double> sal = new TreeMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
                while (reader.ready()) {
                    String in = reader.readLine();
                    sal.merge(in.split(" ")[0], Double.parseDouble(in.split(" ")[1]), Double::sum);
                }
            }

            double max = 0;
        for (double d: sal.values()) {
            if (max<d) max=d;
        }

            for (String s: sal.keySet()) {
                if (Math.abs(sal.get(s)-max) < 0.000001d)
                    System.out.println(s);
            }

    }
}
