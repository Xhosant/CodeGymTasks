package en.codegym.task.jdk13.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
2 arrays
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] sArray= new String[10];
        int[] iArray = new int[10];

        for (int i = 0; i < 10; i++) {
            sArray[i] = reader.readLine();
        }

        for (int i = 0; i < 10; i++) {
            iArray[i] = sArray[i].length();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(iArray[i]);
        }
    }
}
