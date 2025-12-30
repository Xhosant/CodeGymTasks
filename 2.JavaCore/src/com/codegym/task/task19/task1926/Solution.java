package com.codegym.task.task19.task1926;

/* 
Mirror image

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(r.readLine()))){
            while (reader.ready()) {
                char[] line = reader.readLine().toCharArray();
                for (int i = line.length - 1; i > -1; i--) System.out.print(line[i]);
                System.out.println();
            }
        }
    }
}
