package com.codegym.task.task17.task1711;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* 
CRUD 2

*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        // Start here
        Person p;
        int count;
        switch (args[0]){
            case "-c":
                synchronized (allPeople){
                count = (args.length-1)/3;
                for (int i=0; i<count; i++){
                    if (args[i*3+2].equals("m")){
                        try {allPeople.add(Person.createMale(args[i*3+1], new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(args[i*3+3])));} catch (Exception ignored){}
                    }
                    else if (args[i*3+2].equals("f")){
                        try {allPeople.add(Person.createFemale(args[i*3+1], new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(args[i*3+3])));} catch (Exception ignored){}
                    }
                    System.out.println(allPeople.size()-1);
                }}
                break;
            case "-u":
                synchronized (allPeople){
                count = (args.length-1)/4;
                for (int i=0; i<count; i++){
                    p = allPeople.get(Integer.parseInt(args[i*4+1]));
                    p.setName(args[i*4+2]);
                    try {p.setBirthDate(new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(args[i*4+4]));}catch (Exception ignored){}
                    if (args[i*4+3].equals("m")){p.setSex(Sex.MALE);}
                    else if (args[i*4+3].equals("f")){p.setSex(Sex.FEMALE);}
                }}
                break;
            case "-d":
                synchronized (allPeople){
                count = (args.length-1);
                for (int i=0; i<count; i++){
                    p = allPeople.get(Integer.parseInt(args[i+1]));
                    p.setName(null);
                    p.setSex(null);
                    p.setBirthDate(null);
                }}
                break;
            case "-i":
                synchronized (allPeople){
                count = (args.length-1);
                for (int i=0; i<count; i++){
                    p = allPeople.get(Integer.parseInt(args[i+1]));
                    String output="";
                    output = p.getName() + " ";
                    if (p.getSex().equals(Sex.MALE)) output = output + "m ";
                    else if (p.getSex().equals(Sex.FEMALE)) output = output + "f ";
                    output = output + new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH).format(p.getBirthDate());
                    System.out.println(output);
                }}
                break;
        }
    }
    
}
