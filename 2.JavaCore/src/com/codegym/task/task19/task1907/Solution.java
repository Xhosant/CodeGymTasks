package com.codegym.task.task19.task1907;

/* 
Counting words

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        String in;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            in = reader.readLine();
        }
        StringBuilder build=new StringBuilder();
        try (FileReader reader = new FileReader(in)){
            while (reader.ready()) build.append((char) reader.read());
        }
        String file = build.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");;
        int counter = 0;
        for (String s:file.split(" ")) {
            if (s.equals("world")) counter++;
        }
        System.out.println(counter);
    }
}