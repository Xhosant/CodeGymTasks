package com.codegym.task.task18.task1819;

/* 
Combining files

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        String output = null;
        String input = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            output= reader.readLine();
            input= reader.readLine();

        } catch (Exception ignored){}
        StringBuilder sb = new StringBuilder();
        try (FileReader reader2 = new FileReader(input);
             FileReader reader1 = new FileReader(output);
             ){

            while (reader2.ready()) sb.append((char)reader2.read());
            while (reader1.ready()) sb.append((char)reader1.read());
        } catch (Exception ignored){}
        try (FileWriter writer = new FileWriter(output, false)){
            writer.write(sb.toString());
        } catch (Exception ignored) {}
    }
}
