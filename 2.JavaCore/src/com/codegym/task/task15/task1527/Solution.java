package com.codegym.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* 
Request parser

*/

public class Solution {
    public static void main(String[] args) {
        //write your code here
        String[] parameters=null;
        ArrayList<String> objects = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String url = reader.readLine();
            parameters = url.split("\\?")[1].split("&");
        } catch (IOException ignored) {}
        for (int i = 0; i< Objects.requireNonNull(parameters).length; i++){
            String[] temp = parameters[i].split("=");
            parameters[i] = temp[0];
            if (temp[0].equals("obj")) objects.add(temp[1]);
        }
        for (String parameter : parameters) {
            System.out.print(parameter + " ");
        }
        System.out.println();

        for (String object : objects) {
            try {
                alert(Double.parseDouble(object));
            } catch (NumberFormatException e) {
                alert(object);

            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
