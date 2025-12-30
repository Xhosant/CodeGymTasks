package com.codegym.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Threads and bytes

*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String file;
            while (!(file = reader.readLine()).equals("exit")){
                ReadThread t = new ReadThread(file);
                t.start();
            }
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            // Implement constructor body
            this.fileName=fileName;
        }
        // Implement file reading here
        public void run(){
            int[] count = new int[128];
            try (FileReader reader = new FileReader(fileName)) {
                while (reader.ready()){
                    count[reader.read()]++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int max=0;

            for (int i=0;i<128;i++) {
                if (count[i]>count[max]) {
                    max=i;
                }
            }
            resultMap.put(fileName, max);
        }
    }
}
