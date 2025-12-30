package com.codegym.task.task18.task1807;

/* 
Counting commas

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int count=0;
        try(FileInputStream input = new FileInputStream(
                new BufferedReader(new InputStreamReader(System.in)).readLine())){
            while (input.available()>0){
                if (input.read()==44) count++;
            }
            System.out.println(count);
        } catch (Exception ignored){}
    }
}
