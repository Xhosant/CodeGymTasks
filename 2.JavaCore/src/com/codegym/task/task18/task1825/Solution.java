package com.codegym.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* 
Building a file

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> parts = new ArrayList<Integer>();
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String f = reader.readLine();
            String[] fPart = new String[2];
            fPart = f.split(".part");
            fileName = fPart[0];
            parts.add(Integer.parseInt(fPart[1]));

            while (!(f= reader.readLine()).equals("end")){
                parts.add(Integer.parseInt(f.split(".part")[1]));
            }
        }
        Collections.sort(parts);
        try (FileOutputStream writer = new FileOutputStream(fileName)){
            for (int part: parts) {
                try (FileInputStream reader = new FileInputStream(fileName + ".part" + part)){
                    byte[] buffer = new byte[reader.available()];
                    while (reader.available()>0){
                        int bytesRead = reader.read(buffer);
                        writer.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
}
