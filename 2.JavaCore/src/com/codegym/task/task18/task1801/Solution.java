package com.codegym.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Maximum byte

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String file = reader.readLine();
            FileInputStream in = new FileInputStream(file);
            int max = 0;
            while (in.available()>0){
                int temp = in.read();
                if (max<temp)max=temp;
            }
            in.close();
            System.out.println(max);
        }
    }
}
