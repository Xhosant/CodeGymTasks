package en.codegym.task.jdk13.task07.task0702;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
String array in reverse order
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] SArray=new String[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            SArray[i] = reader.readLine();
        }

        for (int i = 9; i >=0 ; i--) {
            System.out.println(SArray[i]);
        }
    }
}