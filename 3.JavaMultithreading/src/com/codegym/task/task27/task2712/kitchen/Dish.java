package com.codegym.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
                String st = "";
                for (Dish d: Dish.values()
                     ) {
                        if (!"".equals(st)){
                                st+=", ";
                        }
                        st+=d.name();
                }
                return st;
        }
}
