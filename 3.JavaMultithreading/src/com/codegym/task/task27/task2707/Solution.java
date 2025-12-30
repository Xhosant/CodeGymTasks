package com.codegym.task.task27.task2707;

/* 
Determining locking order

*/

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }


    private static volatile boolean goFlag=false;
    private static volatile boolean orderCorrect=false;

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {

        //manufacture deadlock if wrong order
        //start a slow order=false that only wins by deadlock

        Thread competingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    synchronized (o2) {
                        try {
                            Thread.sleep(100000);
                        } catch (InterruptedException e) {
                            System.out.println("Competing crashed");
                        }
                    }
                }
            }
        });

        Thread methodThread = new Thread(new Runnable() {
            @Override
            public void run() {
                        solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        });

        Thread deadlockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    competingThread.start();
                    methodThread.start();
                    try {
                        Thread.sleep(10);
                        //methodThread.join();
                    } catch (InterruptedException e) {
                        System.out.println("Competing crashed");
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Thread.sleep(10);

                } catch (InterruptedException e) {
                    System.out.println("Competing crashed");
                    throw new RuntimeException(e);
                }
                //System.out.println(competingThread.getState());
                if (competingThread.getState()!= Thread.State.BLOCKED){
                orderCorrect = true;}
            }
        });

        Thread delayThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                goFlag=true;
            }
        });

        deadlockThread.start();
        delayThread.start();

        while (!goFlag){System.out.print("");}
        return orderCorrect;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
