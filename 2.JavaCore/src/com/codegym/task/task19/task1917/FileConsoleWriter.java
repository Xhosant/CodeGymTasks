package com.codegym.task.task19.task1917;

/* 
Your own FileWriter

*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter(FileDescriptor fd){
        fileWriter = new FileWriter(fd);
    }
    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println((char) c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        //char[] sub = new char[len];
        //System.arraycopy(cbuf, off, sub, 0, len);
        StringBuilder s = new StringBuilder();
        for (int i=off; i<len+off; i++){
            s.append(cbuf[i]);
        }
        System.out.println(s);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        String sub = str.substring(off, len+off);
        System.out.println(sub);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(cbuf);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public static void main(String[] args) throws IOException {

        FileConsoleWriter f = new FileConsoleWriter("f:\\output1.txt");
        char[] c = new char[]{'1', 'T', 'e', 's', 't', '2'};
        f.write(c, 1, 5);
        f.close();
    }

}
