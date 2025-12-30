package com.codegym.task.task19.task1908;

/* 
Picking out numbers

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {


        String in;
        String out;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            in = reader.readLine();
            out = reader.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(out))){
            StringBuilder b = new StringBuilder();
            while (reader.ready()){
                b.append((char) reader.read());
            }
            String[] string = b.toString().split(" ");
            ArrayList<String> list = new ArrayList<String>();
            for (String s: string) {
                if (s.matches("[0-9]+")) list.add(s);
            }
            writer.write(String.join(" ", list));
        }
    }
}
