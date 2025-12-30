package com.codegym.task.task23.task2305;

/* 
Inner

*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] out = new Solution[2];
        for (int i=0; i<out.length;i++){
            out[i]=new Solution();
            out[i].innerClasses[0] = new InnerClass();
            out[i].innerClasses[1] = new InnerClass();
        }
        return out;
    }

    public static void main(String[] args) {

    }
}
