package com.codegym.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
File in a static block

*/

public class Solution {
    public static List<String> lines = new ArrayList<>();
    static {
        try (BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME))){
            String s=null;
            while ((s = reader.readLine()) != null) {
                lines.add(s);
            }

        }
        catch (Exception e){}
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
