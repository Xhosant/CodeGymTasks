package com.codegym.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* 
Password generator

*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {


        ArrayList<Byte> pass = new ArrayList<Byte>();
        pass.add(Range.get(0));
        pass.add(Range.get(1));
        pass.add(Range.get(2));
        for (int i = 0; i < 5; i++) {
            pass.add(Range.get());
        }
        Collections.shuffle(pass);

        ByteArrayOutputStream out = new ByteArrayOutputStream(pass.size());

        for (byte b: pass
             ) {
            out.write(b);
        }
        try{
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    public static class Range{
        static int start1 = 'a';
        static int range1 = 'z' - start1;
        static int start2 = 'A';
        static int range2 = 'Z' - start2;
        static int start3 = '0';
        static int range3 = '9' - start3;
        static int[][] ranges = {{start1, range1},{start2, range2},{start3, range3}};

        public static byte get(){
            return get((int) (Math.random()*3));
        }

        public static byte get(int category){
            return (byte) (Math.random()*ranges[category][1] + ranges[category][0]);
        }
    }
}
