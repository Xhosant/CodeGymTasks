package en.codegym.task.jdk13.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
One large array and two small ones
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] iLong = new int[20];

        int[] short1 = new int[10];
        int[] short2 = new int[10];

        for (int i = 0; i < 20; i++) {
            iLong[i]= Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < 20; i++) {
            if (i<10) short1[i]=iLong[i];
            else short2[i-10] = iLong[i];
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(short2[i]);

        }
    }
}
