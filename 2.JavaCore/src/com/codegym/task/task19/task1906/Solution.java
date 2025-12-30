package com.codegym.task.task19.task1906;

/* 
Even characters

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

        try (FileReader reader = new FileReader(in);
                FileWriter writer = new FileWriter(out)){
            char[] cbuf = new char[2];
            while (reader.read(cbuf)>1){
                writer.write(cbuf[1]);
            }
        }
    }
}
