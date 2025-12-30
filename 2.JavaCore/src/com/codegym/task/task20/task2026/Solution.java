package com.codegym.task.task20.task2026;

/* 
Rectangle algorithms

*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Must be 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Must be 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = a[0][0];
        for (int i=1; i<a.length;i++){
            if (a[i][0] - a[i-1][0]==1) count++;
            if (a[0][i] - a[0][i-1]==1) count++;
        }
        for (int i=1; i<a.length;i++) for (int j=1;j<a.length;j++){
            if (a[i][j] - a[i-1][j] - a[i][j-1] ==1) count++;
        }

        return count;
    }
}
