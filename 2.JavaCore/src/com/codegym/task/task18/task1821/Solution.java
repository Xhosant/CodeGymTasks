package com.codegym.task.task18.task1821;

/* 
Symbol frequency

*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        int[] count = new int[128];
        Arrays.fill(count, 0);
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()){
                count[reader.read()]++;
            }
        } catch (Exception ignored) {}
        for (int i=0; i<128; i++){
            if (count[i]>0) System.out.println((char)i + " " + count[i]);
        }
    }
}
