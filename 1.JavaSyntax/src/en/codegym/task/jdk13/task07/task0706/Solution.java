package en.codegym.task.jdk13.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Street and houses
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] iArray = new int[15];
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < 15; i++) {
            iArray[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < 15; i+=2) {
            sumEven += iArray[i];
        }
        for (int i = 1; i < 15; i+=2) {
            sumOdd += iArray[i];
        }

        if (sumOdd>sumEven) System.out.println("Odd-numbered houses have more residents.");
        else if (sumEven>sumOdd) System.out.println("Odd-numbered houses have more residents.");
    }
}
