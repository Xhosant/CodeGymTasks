package com.codegym.task.task25.task2502;

import java.util.*;

/* 
Don't take the car to the shop!

*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            // Init wheels here
            String[] w = loadWheelNamesFromDB();
            if (w.length != 4) throw new IllegalArgumentException();
            wheels = new ArrayList<Wheel>();
            for (String s: w
                 ) {
                wheels.add(Wheel.valueOf(s));
            }
        }

        protected String[] loadWheelNamesFromDB() {
            // This method returns mock data
            Wheel[] w = Wheel.values();
            String[] s = new String[w.length];
            for (int i = 0; i < w.length; i++) {
                s[i]=w[i].toString();
            }
            return s;
        }
    }

    public static void main(String[] args) {
    }
}
