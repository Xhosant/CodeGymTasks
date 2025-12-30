package com.codegym.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* 
John Johnson

*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] in = reader.readLine().split(" ");
                int length = in.length;

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, Integer.parseInt(in[length-1]));
                calendar.set(Calendar.MONTH, Integer.parseInt(in[length-3])-1);
                calendar.set(Calendar.DATE, Integer.parseInt(in[length-2]));
                Date date = calendar.getTime();

                StringBuilder name = new StringBuilder();
                for (int i=0; i<length-3; i++){
                    name.append(in[i]).append(" ");
                }

                PEOPLE.add(new Person(name.toString().trim(), date));
            }
        }
    }
}
