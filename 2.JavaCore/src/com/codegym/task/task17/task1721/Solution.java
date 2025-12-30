package com.codegym.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Transactionality

*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)))) {
            BufferedReader fReader1 = new BufferedReader(new FileReader(reader.readLine()));
            String input;
            while ((input = fReader1.readLine()) != null)
                allLines.add(input);
            fReader1.close();
            BufferedReader fReader2 = new BufferedReader(new FileReader(reader.readLine()));
            while ((input = fReader2.readLine()) != null)
                linesForRemoval.add(input);
            fReader2.close();
        } catch (Exception ignored){}
        try {new Solution().joinData();}
        catch (CorruptedDataException ignored){

        }

    }

    public void joinData() throws CorruptedDataException {
        for (String s : linesForRemoval) {
            int index = allLines.indexOf(s);
            if (index==-1){
                allLines.clear();
                throw new CorruptedDataException();
            }
            else allLines.remove(index);
        }

    }
}
