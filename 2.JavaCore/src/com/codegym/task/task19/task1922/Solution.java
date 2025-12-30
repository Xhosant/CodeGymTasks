package com.codegym.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Searching for the right lines

*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("file");
        words.add("view");
        words.add("In");
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(r.readLine()))){
            while (reader.ready()){
                String[] line = reader.readLine().split(" ");
                int wordCount=0;
                for (String word : words) {
                    for (String l : line){
                        if (word.equals(l)) wordCount++;
                    }
                }
                if (wordCount==2) {
                    StringBuilder sb = new StringBuilder();
                    for (String s: line) {
                        sb.append(s).append(" ");
                    }
                    System.out.println(sb.toString().trim());
                }
            }
        }
    }
}
