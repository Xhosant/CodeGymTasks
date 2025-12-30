package com.codegym.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Most frequent bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {

        PairArray pairs = new PairArray();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String file = reader.readLine();
            FileInputStream in = new FileInputStream(file);
            while (in.available() > 0) {
                pairs.add(in.read());
            }
            in.close();
            for (Integer i: pairs.getCommon()) {
                System.out.print(i + " ");
            }
        }
    }

    public static class PairArray{
        ArrayList<Integer> contents = new ArrayList<Integer>();
        ArrayList<Integer>  counts= new ArrayList<Integer>();

        public void add(int input){
            int index = contents.indexOf(input);
            if (index==-1) {
                contents.add(input);
                counts.add(1);
            }
            else {
                counts.set(index, counts.get(index)+1);
            }
        }

        public ArrayList<Integer> getCommon(){
            ArrayList<Integer> output = new ArrayList<Integer>();
            int maxCount = 0;
            for (int i=0; i< contents.size(); i++) {
                if (counts.get(i)>maxCount){
                    maxCount=counts.get(i);
                    output.clear();
                    output.add(contents.get(i));
                }
                else if (counts.get(i)==maxCount){
                    output.add(contents.get(i));
                }
            }

            return output;
        }
    }
}
