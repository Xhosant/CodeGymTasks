package com.codegym.task.task29.task2909.car;

public class Cabriolet extends Car{
    static final int MAX_CABRIOLET_SPEED = 90;

    public Cabriolet(int numberOfPassengers) {
        super(2, numberOfPassengers);
    }

    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
