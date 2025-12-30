package com.codegym.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Minimum byte

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String file = reader.readLine();
            FileInputStream in = new FileInputStream(file);
            int min = in.read();
            while (in.available() > 0) {
                int temp = in.read();
                if (min > temp) min = temp;
            }
            in.close();
            System.out.println(min);
        }
    }
}
