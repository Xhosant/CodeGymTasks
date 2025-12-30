package com.codegym.task.task29.task2909.human;

public class BloodType {
    public int getCode() {
        return code;
    }

    private final int code;

    private BloodType(int code) {
        this.code = code;
    }

    public static BloodType first() {
        return new BloodType(1);
    }

    public static BloodType second() {
        return new BloodType(2);
    }

    public static BloodType third() {
        return new BloodType(3);
    }

    public static BloodType fourth() {
        return new BloodType(4);
    }
}
