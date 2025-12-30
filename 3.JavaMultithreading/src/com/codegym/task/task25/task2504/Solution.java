package com.codegym.task.task25.task2504;

/* 
A switch for threads

*/

public class Solution {
    public static void processThreads(Thread... threads) {
        // Implement this method
        for (Thread t: threads
             ) {

            switch (t.getState()){
                case NEW:
                    t.start();
                    break;
                case RUNNABLE:
                    t.isInterrupted();
                    break;
                case TIMED_WAITING:
                case WAITING:
                case BLOCKED:
                    t.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(t.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
