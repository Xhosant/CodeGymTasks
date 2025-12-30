package com.codegym.task.task18.task1824;

/* 
Files and exceptions

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String file;
            while ((file= reader.readLine())!=null){
                try (FileReader reader1 = new FileReader(file)){

                } catch (FileNotFoundException e){
                    System.out.println(file);
                    return;
                }
            }
        }
    }
}
