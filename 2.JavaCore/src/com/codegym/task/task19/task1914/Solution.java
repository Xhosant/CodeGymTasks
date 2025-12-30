package com.codegym.task.task19.task1914;

/* 
Problem solving

*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        String result = outputStream.toString();
        String[] math = result.split(" ");
        int mathResult = 0;
        switch (math[1]){
            case ("+"):
                mathResult = Integer.parseInt(math[0]) + Integer.parseInt(math[2]);
                break;
            case ("-"):
                mathResult = Integer.parseInt(math[0]) - Integer.parseInt(math[2]);
                break;
            case ("*"):
                mathResult = Integer.parseInt(math[0]) * Integer.parseInt(math[2]);
                break;
        }
        System.out.println(math[0] + " " + math[1] + " " + math[2] + " = " + mathResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

