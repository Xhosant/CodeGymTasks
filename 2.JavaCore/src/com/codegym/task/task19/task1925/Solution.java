package com.codegym.task.task19.task1925;

/* 
Long words

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))){

            ArrayList<String> input = new ArrayList<>();
            while (reader.ready()) {
                String[] in =reader.readLine().split(" ");
                for (String s: in) {
                    if (s.length()>6) input.add(s);
                }
            }
            if (input.size()==0) return;
            writer.write(input.get(0));
            for (int i= 1; i<input.size();i++) writer.append(","+input.get(i));
        }
    }
}
