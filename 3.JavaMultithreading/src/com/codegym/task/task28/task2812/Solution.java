package com.codegym.task.task28.task2812;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
shutdownNow!

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }

        List<Runnable> list = executor.shutdownNow();
        for (Runnable r: list
        ) {
            String name = r.toString().split("\\[Not")[0];
            System.out.println(name+ " was not completed");
        }
        //Thread t = new Thread(new Runnable() {
        //    @Override
        //    public void run() {
        //        try {
        //            Thread.sleep(10);
        //        } catch (InterruptedException e) {
        //            throw new RuntimeException(e);
        //        }
        //
        //    }
        //});
        //t.join();
        //t.start();
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
