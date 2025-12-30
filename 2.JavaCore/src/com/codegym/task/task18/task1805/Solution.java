package com.codegym.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Sorting bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {

        SinglesArray pairs = new SinglesArray();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String file = reader.readLine();
            FileInputStream in = new FileInputStream(file);
            while (in.available() > 0) {
                pairs.add(in.read());
            }
            in.close();
            for (Integer i: pairs.getSorted()) {
                System.out.print(i + " ");
            }
        }
    }

    public static class SinglesArray{
        ArrayList<Integer> contents = new ArrayList<Integer>();

        public void add(int input){
            if (!contents.contains(input)) {
                contents.add(input);
            }
        }

        public ArrayList<Integer> getSorted(){
            Collections.sort(contents);

            return contents;
        }
    }
}

