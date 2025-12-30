package com.codegym.task.task19.task1909;

/* 
Changing punctuation marks

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String in;
        String out;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            in = reader.readLine();
            out = reader.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(out))) {
            StringBuilder b = new StringBuilder();
            while (reader.ready()){
                b.append((char) reader.read());
            }
            String s = b.toString().replace(".","!");
            writer.write(s);
        }
    }
}
