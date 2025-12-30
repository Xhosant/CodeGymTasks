package com.codegym.task.task18.task1822;

/* 
Finding data inside a file

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file=null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file= reader.readLine();
        }
        String line;
        String data = null;
        String id = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while ((line = reader.readLine())!=null){
                if (line.startsWith(id)) data=line;
            }
        }
        System.out.println(data);
    }
}
