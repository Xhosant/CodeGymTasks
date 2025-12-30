package com.codegym.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread target;
    public LoggingStateThread(Thread target) {
        this.target=target;
    }

    @Override
    public void run() {
        Thread.State oldState = target.getState();
        System.out.println(oldState.toString());
        super.run();
        while (true){
            Thread.State newState = target.getState();
            if (newState!=oldState){
                oldState = newState;
                System.out.println(newState.toString());
            }
            if (oldState==State.TERMINATED) return;
        }
    }
}
