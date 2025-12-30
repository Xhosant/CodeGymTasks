package com.codegym.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import  java.lang.StringBuilder;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //write your code here
    static{
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (Exception ignored){}
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //write your code here
        f.join();
        System.out.println(f.getFileContents());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContents();

        void join() throws InterruptedException;

        void start();
    }

    //write your code here
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String name;
        private String contents="";
        
        public void setFileName(String fullFileName){
            this.name=fullFileName;
        }
        
        public String getFileContents(){
            return contents;
        }
        
        public void run(){
            StringBuilder buffer = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(name))){
                String line;
                while((line = reader.readLine()) != null) {
                    buffer.append(line).append(" ");
                }
                contents = buffer.toString();
            }
            catch (Exception e) {};
        }
    }
    
    
}
