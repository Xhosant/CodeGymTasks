package com.codegym.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Using RandomAccessFile

*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")){
            raf.seek(number);
            byte[] b = new byte[text.length()];
            raf.read(b, 0, text.length());
            raf.seek(raf.length());
            if (Arrays.equals(b, text.getBytes())) raf.write("true".getBytes());
            else raf.write("false".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}