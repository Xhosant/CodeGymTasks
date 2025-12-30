package com.codegym.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome extends Thread{
    private List<Horse> horses;
    static Hippodrome game;

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("A", 3, 0));
        game.getHorses().add(new Horse("B", 3, 0));
        game.getHorses().add(new Horse("C", 3, 0));
        game.run();
        game.printWinner();
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    void move(){
        for (Horse horse : horses
             ) {
            horse.move();
        }
    }
    void print(){
        for (Horse horse : horses
        ) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        double distance = 0;
        Horse winner = null;
        for (Horse horse: horses
             ) {
            if (horse.distance > distance) {
                winner = horse;
                distance = horse.distance;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("The winner is " + getWinner().name + "!");
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
