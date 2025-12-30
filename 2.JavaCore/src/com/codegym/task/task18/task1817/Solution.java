package com.codegym.task.task18.task1817;

/* 
Spaces

*/

import java.io.FileReader;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) {
        int letterCount=0;
        int spaceCount=0;
        try (FileReader reader = new FileReader(args[0])){
            while (reader.ready()){
                if ((char)reader.read()==' ') spaceCount++;
                letterCount++;
            }
        } catch (Exception ignored){}
        double ratio = (double) spaceCount / letterCount * 100;
        System.out.println(new DecimalFormat("###.##").format(ratio));
    }
}
