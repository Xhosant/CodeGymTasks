package com.codegym.task.task32.task3201;

/* 
Writing to an existing file

*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args){
        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")){
            if (number >= raf.length()) number = (raf.length());
            raf.seek(number);
            raf.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
