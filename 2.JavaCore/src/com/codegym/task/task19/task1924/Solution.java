package com.codegym.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Replacing numbers

*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static{
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7,"seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
    }

    public static void main(String[] args) throws IOException {
        //String[] s = "This costs 1 dollar, but this is 12.".split("\\W+");
        //String[] p = "This costs 1 dollar, but this is 12.".split("\\w+");
        //System.out.println(Arrays.toString(s));
        //System.out.println(Arrays.toString(p));
        //String line = "110 is a number.";
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(r.readLine()))){
            while (reader.ready()){
                String line = reader.readLine();

                for (Map.Entry<Integer, String> entry: map.entrySet()) {
                    line=line.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                }
                System.out.println(line);
            }
        }
    }
}
