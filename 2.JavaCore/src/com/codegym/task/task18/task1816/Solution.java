package com.codegym.task.task18.task1816;

/* 
ABCs

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int count=0;
        try (FileReader reader = new FileReader(args[0])){
            int c = reader.read();
            while (c!=-1){
                if ((c>64 && c<91) ||(c>96 && c<123)) count++;
                c= reader.read();
            }
        } catch (Exception ignored){}
        System.out.println(count);
    }
}
