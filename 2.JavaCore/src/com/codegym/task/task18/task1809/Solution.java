package com.codegym.task.task18.task1809;

/* 
Reversing a file

*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        String file1;
        String file2;

        byte[] buffer;
        int count;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file1 = reader.readLine();
            file2 = reader.readLine();

        } catch (Exception ignored){return;}
        try(FileInputStream input = new FileInputStream(file1)){
            buffer = new byte[input.available()];
            count = input.read(buffer);
        } catch (Exception ignored){return;}

        try(FileOutputStream output1 = new FileOutputStream(file2)){
            for (int i = count-1;i>=0;i--)
            output1.write(buffer[i]);
        } catch (Exception ignored){}


    }
}