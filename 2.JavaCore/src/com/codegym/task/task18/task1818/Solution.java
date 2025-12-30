package com.codegym.task.task18.task1818;

/* 
Two in one

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String output = null;
        String input1 = null;
        String input2 = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            output= reader.readLine();
            input1= reader.readLine();
            input2= reader.readLine();
        } catch (Exception ignored){}
        try (FileReader reader1 = new FileReader(input1);
            FileReader reader2 = new FileReader(input2);
            FileWriter writer = new FileWriter(output)){
            while (reader1.ready()){
                writer.write(reader1.read());
            }
            while (reader2.ready()){
                writer.write(reader2.read());
            }
        } catch (Exception ignored){}
    }
}
