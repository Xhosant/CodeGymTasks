package com.codegym.task.task18.task1826;

/* 
Encryption

*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream(args[1]);
             FileOutputStream out = new FileOutputStream(args[2])){
             byte[] bytes = new byte[in.available()];
             byte[] newBytes = new byte[in.available()];
             in.read(bytes);
             if (args[0].equals("-d")){
                 for (int i=0; i<bytes.length;i++) {
                     newBytes[i]=(byte) Decrypt(bytes[i]);
                 }
             }
             else if (args[0].equals("-e")){
                 for (int i=0; i<bytes.length;i++) {
                     newBytes[i]=(byte) Encrypt(bytes[i]);
                 }
             }
             out.write(newBytes);
        }
    }

    public static int Encrypt(byte b){
        if (b==0) return 127;
        else return b-1;
    }
    public static int Decrypt(byte b){
        if (b==127) return 0;
        else return b+1;
    }

}
