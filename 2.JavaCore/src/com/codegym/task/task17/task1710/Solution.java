package com.codegym.task.task17.task1710;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* 
CRUD

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        // Start here

        Person p;
        switch (args[0]){
            case "-c":
                if (args[2].equals("m")){
                    try {allPeople.add(Person.createMale(args[1], new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(args[3])));} catch (Exception ignored){}
                }
                else if (args[2].equals("f")){
                    try {allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(args[3])));} catch (Exception ignored){}
                }
                System.out.println(allPeople.size()-1);
                break;
            case "-u":
                p = allPeople.get(Integer.parseInt(args[1]));
                p.setName(args[2]);
                try {p.setBirthDate(new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(args[4]));}catch (Exception ignored){}
                if (args[3].equals("m")){p.setSex(Sex.MALE);}
                else if (args[3].equals("f")){p.setSex(Sex.FEMALE);}
                break;
            case "-d":
                p = allPeople.get(Integer.parseInt(args[1]));
                p.setName(null);
                p.setSex(null);
                p.setBirthDate(null);
                break;
            case "-i":
                p = allPeople.get(Integer.parseInt(args[1]));
                String output="";
                output = p.getName() + " ";
                if (p.getSex().equals(Sex.MALE)) output = output + "m ";
                else if (p.getSex().equals(Sex.FEMALE)) output = output + "f ";
                output = output + new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH).format(p.getBirthDate());

                System.out.println(output);
                break;
        }
    }
}
