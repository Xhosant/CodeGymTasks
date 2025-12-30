package com.codegym.task.task18.task1808;

/* 
Splitting a file

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        String file1;
        String file2;
        String file3;
        byte[] buffer;
        int count;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file1 = reader.readLine();
            file2 = reader.readLine();
            file3 = reader.readLine();
        } catch (Exception ignored){return;}
        try(FileInputStream input = new FileInputStream(file1)){
            buffer = new byte[input.available()];
            count = input.read(buffer);
        } catch (Exception ignored){return;}

        int count2= count/2;
        count2=count-count2;

        try(FileOutputStream output1 = new FileOutputStream(file2)){
            output1.write(buffer, 0, count2);
        } catch (Exception ignored){}

        try(FileOutputStream output2 = new FileOutputStream(file3)){
            output2.write(buffer, count2, count-count2);
        } catch (Exception ignored){}

    }
}
