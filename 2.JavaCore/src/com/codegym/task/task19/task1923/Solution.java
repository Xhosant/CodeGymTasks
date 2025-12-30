package com.codegym.task.task19.task1923;

/* 
Words with numbers

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                for (String s: line) {
                    if (s.matches(".+[0-9].+")) words.add(s);
                }
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))){
            for (String s : words) {
                writer.write(s + " ");
            }
        }
    }
}
