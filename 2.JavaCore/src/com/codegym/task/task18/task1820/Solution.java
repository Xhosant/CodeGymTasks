package com.codegym.task.task18.task1820;

/* 
Rounding numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String output = null;
        String input = null;
        int[] rounded=null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            input= reader.readLine();
            output= reader.readLine();
        } catch (Exception ignored){}

        try (BufferedReader reader = new BufferedReader(new FileReader(input))){
            String s = reader.readLine();
            String[] numbers = s.split(" ");
            rounded = new int[numbers.length];
            for(int i = 0; i < numbers.length; i++) {
                rounded[i] = (int) Math.round((Double.parseDouble(numbers[i]) *100)/100);
            }

            /*for (int i = 0; i<numbers.length;i++) {
                String[] temp = numbers[i].split("\\.");
                rounded[i]=Integer.parseInt(temp[0]);
                int adjust=0;
                if (rounded[i]>0 && Integer.parseInt(temp[1].substring(0, 1))>4){
                    adjust=1;
                }
                else if (rounded[i]<0 &&
                        ( Integer.parseInt(temp[1].substring(0, 1))>5 ||
                                (temp[1].length()>1 && Integer.parseInt(temp[1].substring(0, 2))>50))){
                    adjust=-1;
                }
                rounded[i]+=adjust;
            }*/
        } catch (Exception ignored) {}

        try (FileWriter writer = new FileWriter(output)){
            writer.write("" +rounded[0]);
            for (int i = 1; i<rounded.length;i++) {
                writer.write(" " + (rounded[i]));
            }
        } catch (Exception ignored) {}
    }
}
