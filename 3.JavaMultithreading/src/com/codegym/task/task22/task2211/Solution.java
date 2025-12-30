package com.codegym.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Changing the encoding

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Charset win = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))){
            while (reader.ready()){
                byte[] buffer = reader.readLine().getBytes(win);
                writer.append(new String(buffer, utf));
            }
        }
    }
}
